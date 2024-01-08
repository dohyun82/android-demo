package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme
import kotlin.math.roundToInt

/**
 * Compose 애니메이션 Activity
 */
class ComposeAnimationActivity : ComponentActivity(){

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent{
			AnimationContent()
		}
	}
}

@Composable
private fun AnimationContent(){
	AndroidDemoTheme {
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			AnimationPage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewAnimationPage(){
	AnimationPage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AnimationPage(){
	val context = LocalContext.current
	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					Text("애니메이션 데모")
				},
				navigationIcon = {
					IconButton(onClick = {
						(context as ComposeAnimationActivity).finish()
					}) {
						Icon(
							imageVector = Icons.Filled.ArrowBack,
							contentDescription = "뒤로 가기"
						)
					}
				}
			)
		},
	) {
		AnimationBody(Modifier.padding(it))
	}
}

@Composable
private fun AnimationBody(
	modifier: Modifier = Modifier
){
	Box(
		modifier = modifier.fillMaxWidth(),
	){
		DemoCrossFade()
	}
}

@Composable
private fun DemoCrossFade(){
	var currentPage by remember {
		mutableStateOf("공지 1")
	}
	Column {
		Crossfade(
			targetState = currentPage,
			label = "currentPage",
			animationSpec = tween(
				durationMillis = 3000,
				delayMillis = 2500,
				easing = FastOutSlowInEasing
			)
		) {
			when(it){
				"공지 1" -> Text("불라블라블라 1")
				"공지 2" -> Text("ㅁㅇ라미ㅏ어라ㅣ멍ㄹ 2")
				"공지 3" -> Text("ㅁㄷㅂ닥비ㅑㄷ게ㅑㅂㄷㄱ 3")
			}
		}
		Button(onClick = {
			currentPage = switchText(currentPage)
		}) {
			Text("변경")
		}
	}
}

@Composable
private fun DemoTextSwitcher(){

	var currentText by remember {
		mutableStateOf("공지 1")
	}
	
	val alpha by remember{
		mutableFloatStateOf(1f)
	}
	
	val fadeInOutTransition = updateTransition(targetState = currentText, label = "fadeInOutTransition")

	val alphaValue by fadeInOutTransition.animateFloat(
		transitionSpec = {
			if(targetState == currentText){
				keyframes {
					durationMillis = 3000
					0.0f at 0 with LinearOutSlowInEasing
					1.0f at 3000
				}
			}else{
				keyframes {
					durationMillis = 3000
					1.0f at 0 with LinearOutSlowInEasing
					0.0f at 3000
				}
			}
		}, label = "alphaValue"
	){ state ->
		if(state == currentText) alpha else 1f
	}
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		Text(
			text = currentText,
			modifier = Modifier
				.padding(16.dp)
				.alpha(alphaValue)
		)
		Button(onClick = {
			currentText = switchText(currentText)
		}) {
			Text("변경")
		}
	}
}

fun switchText(currentText: String): String{
	return when(currentText){
		"공지 1" -> "공지 2"
		"공지 2" -> "공지 3"
		"공지 3" -> "공지 1"
		else -> "알수 없음"
	}
}

@Composable
private fun DemoAnimateColor(){
	val infiniteTransition = rememberInfiniteTransition(
		label = "infinite transition"
	)
	val animatedColor by infiniteTransition.animateColor(
		initialValue = Color(0xff60ddad),
		targetValue = Color(0xff4285f4),
		animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
		label = "color"
	)
	BasicText(
		text = "Hello Compose",
		color = {
			animatedColor
		},
		modifier = Modifier
			.fillMaxSize()
	)
}

@Composable
private fun DemoTextMotion(){
	val infiniteTransition = rememberInfiniteTransition(label = "무제한 이동")
	val scale by infiniteTransition.animateFloat(
		initialValue = 1f,
		targetValue = 8f,
		animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
		label = "scale"
	)
	Box(
		modifier = Modifier.fillMaxSize()
	){
		Text(
			text = "Hello",
			modifier = Modifier
				.graphicsLayer {
					scaleX = scale
					scaleY = scale
					transformOrigin = TransformOrigin.Center
				}
				.align(Alignment.Center),
			style = LocalTextStyle.current.copy(
				textMotion = TextMotion.Animated
			)
		)
	}
}

@Composable
private fun DemoElevation(){
	val mutableInteractionSource = remember{
		MutableInteractionSource()
	}
	val pressed = mutableInteractionSource.collectIsPressedAsState()
	val elevation = animateDpAsState(
		targetValue = if(pressed.value){
			32.dp
		}else{
			8.dp
		},
		label = "elevation"
	)
	Box(
		modifier = Modifier.fillMaxSize()
	){
		Box(
			modifier = Modifier
				.size(100.dp)
				.align(Alignment.Center)
				.graphicsLayer {
					shadowElevation = elevation.value.toPx()
				}
				.clickable(interactionSource = mutableInteractionSource, indication = null) {

				}
				.background(Color.Green)

		)
	}
}

@Composable
private fun DemoPadding(){
	var toggled by remember{
		mutableStateOf(false)
	}
	val animatedPadding by animateDpAsState(
		targetValue = if(toggled){
			0.dp
		}else{
			20.dp
		},
		label = "padding"
	)
	Box(
		modifier = Modifier
			.aspectRatio(1f)
			.fillMaxSize()
			.padding(animatedPadding)
			.background(Color(0xff53d9a1))
			.clickable(
				interactionSource = remember {
					MutableInteractionSource()
				},
				indication = null
			) {
				toggled = !toggled
			}
	)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun DemoLayout(){
	var toggled by remember{
		mutableStateOf(false)
	}
	val interactionSource = remember{
		MutableInteractionSource()
	}
	Column(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxSize()
			.clickable(
				indication = null,
				interactionSource = interactionSource
			) {
				toggled = !toggled
			}
	) {
		val offsetTarget = if(toggled){
			IntOffset(150, 150)
		}else{
			IntOffset.Zero
		}
		val offset = animateIntOffsetAsState(
			targetValue = offsetTarget,
			label = "offset"
		)
		Box(
			modifier = Modifier
				.size(100.dp)
				.background(Color.Blue)
		)
		Box(
			modifier = Modifier
				.layout { measurable, constraints ->
					val offsetValue = if (isLookingAhead) offsetTarget else offset.value
					val placeable = measurable.measure(constraints)
					layout(placeable.width + offsetValue.x, placeable.height + offsetValue.y) {
						placeable.placeRelative(offsetValue)
					}
				}
				.size(100.dp)
				.background(Color.Green)
		)
		Box(
			modifier = Modifier
				.size(100.dp)
				.background(Color.Blue)
		)
	}
}

@Composable
private fun DemoOffset(){
	var moved by remember{
		mutableStateOf(false)
	}
	val pxToMove = with(LocalDensity.current){
		100.dp.toPx().roundToInt()
	}
	val offset by animateIntOffsetAsState(
		targetValue = if(moved){
			IntOffset(pxToMove, pxToMove)
		}else{
			IntOffset.Zero
		},
		label = "offset"
	)
	Column {
		Box(
			modifier = Modifier
				.offset {
					offset
				}
				.background(Color.Blue)
				.size(100.dp)
				.clickable(
					interactionSource = remember {
						MutableInteractionSource()
					},
					indication = null
				) {
					moved = !moved
				}
		)
		Box(
			modifier = Modifier
				.size(200.dp)
				.background(Color.Red)
		)
	}
}

@Composable
private fun DemoAnimateContentSize(){
	var expanded by remember{
		mutableStateOf(false)
	}
	Box(
		modifier = Modifier
			.background(Color.Blue)
			.animateContentSize()
			.height(if (expanded) 400.dp else 200.dp)
			.fillMaxWidth()
			.clickable(
				interactionSource = remember {
					MutableInteractionSource()
				},
				indication = null
			) {
				expanded = !expanded
			}
	)
}

@Composable
private fun DemoAnimateColorAsState(){
	var animateBackgroundColor by remember {
		mutableStateOf(true)
	}
	val animatedColor by animateColorAsState(
		targetValue = if(animateBackgroundColor) Color.Green else Color.Blue,
		label = "color"
	)
	Column {
		Column(
			modifier = Modifier
				.size(200.dp)
				.drawBehind {
					drawRect(animatedColor)
				}
		) {

		}
		Button(onClick = {
			animateBackgroundColor = !animateBackgroundColor
		}) {
			Text("animateColorAsState 데모")
		}
	}

}

@Composable
private fun DemoAnimateFloatAsState(){
	var visible by remember {
		mutableStateOf(true)
	}
	val animatedAlpha by animateFloatAsState(
		targetValue = if (visible) 1.0f else 0f,
		label = "alpha"
	)
	Box(
		modifier = Modifier.fillMaxSize()
	){
		Box(
			modifier = Modifier
				.size(200.dp)
				.graphicsLayer {
					alpha = animatedAlpha
				}
				.clip(RoundedCornerShape(8.dp))
				.background(Color.Green)
				.align(Alignment.TopCenter)
		)
		Button(
			modifier = Modifier.align(Alignment.BottomCenter),
			onClick = {
				visible = !visible
			}
		) {
			Text("AnimateFloatAsState 테스트")
		}
	}
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoAnimatedVisibility(){
	var visible by remember{
		mutableStateOf(true)
	}
	AnimatedVisibility(
		visible = visible,
		enter = slideInVertically(),
		exit = slideOutVertically(),
	) {
		Box(
			modifier = Modifier
				.animateEnterExit(
					enter = fadeIn(),
					exit = fadeOut(),
					label = ""
				)
				.fillMaxWidth()
				.height(100.dp)
				.background(color = Color.Red)
		)
	}
	Button(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth(),
		onClick = { visible = !visible },
		colors = ButtonDefaults.buttonColors(
			containerColor = Color.Blue,
		)
	) {
		Text("AnimatedVisibility 테스트")
	}
}
