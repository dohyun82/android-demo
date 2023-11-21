package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
		contentAlignment = Alignment.Center
	){
//		DemoAnimateAppearing()
//		DemoBackgroundColor()
//		DemoAnimateSize()
//		DemoAnimatePosition()
//		DemoAnimatePositionLayout()
//		DemoAnimatePadding()
//		DemoAnimateElevation()
//		DemoAnimateTextStyle()
//		DemoAnimateTextColor()
//		DemoSwitchDifferentContent()
	}
}


enum class UIState{
	Loading,
	Loaded,
	Error
}

@Composable
private fun DemoSwitchDifferentContent(){
	var state by remember{
		mutableStateOf(UIState.Loading)
	}
	AnimatedContent(
		targetState = state,
		transitionSpec = {
			fadeIn(
				animationSpec = tween(3000)
			) togetherWith fadeOut(animationSpec = tween(3000))
		},
		modifier = Modifier.clickable(
			interactionSource = remember { MutableInteractionSource() },
			indication = null
		) {
			state = when(state){
				UIState.Loading -> UIState.Loaded
				UIState.Loaded -> UIState.Error
				UIState.Error -> UIState.Loading
			}
		},
		label = "Animated Content"
	) {targetState ->
		Box(
			modifier = Modifier.fillMaxSize(),
		){
			when(targetState){
				UIState.Loading -> {
					Box(
						modifier = Modifier.size(100.dp, 100.dp).background(Color.Blue).align(
							Alignment.Center),
						contentAlignment = Alignment.Center
					){
						Text("로딩중",
							color = Color.White)
					}
				}
				UIState.Loaded -> {
					Box(
						modifier = Modifier.size(300.dp, 300.dp).background(Color.Green).align(
							Alignment.BottomCenter),
						contentAlignment = Alignment.Center
					){
						Text("완료",
							color = Color.White)
					}
				}
				UIState.Error -> {
					Box(
						modifier = Modifier.size(200.dp, 200.dp).background(Color.Red).align(
							Alignment.TopCenter),
						contentAlignment = Alignment.Center
					){
						Text("에러",
							color = Color.White)
					}
				}
			}
		}
	}
}

@Composable
private fun DemoAnimateTextColor(){
	val infiniteTransition = rememberInfiniteTransition(
		label = "infinite transition"
	)
	val animatedColor by infiniteTransition.animateColor(
		initialValue = Color.Red,
		targetValue = Color.Yellow,
		animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
		label = "color"
	)
	BasicText(text = "Hello Compose",
		color = {
			animatedColor
		})
}

@Composable
private fun DemoAnimateTextStyle(){
	val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
	val scale by infiniteTransition.animateFloat(
		initialValue = 1f,
		targetValue = 8f,
		animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
		label = "scale"
	)
	Box{
		Box(modifier = Modifier.fillMaxSize()){
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
}


@Composable
private fun DemoAnimateElevation(){
	val mutableInteractionSource = remember {
		MutableInteractionSource()
	}
	val pressed = mutableInteractionSource.collectIsPressedAsState()
	val elevation = animateDpAsState(
		targetValue = if (pressed.value){
			32.dp
		} else {
			8.dp
		},
		label = "elevation"
	)
	Box{
		Box(
			modifier = Modifier
				.size(100.dp)
				.align(Alignment.Center)
				.graphicsLayer {
					this.shadowElevation = elevation.value.toPx()
				}
				.clickable(
					interactionSource = mutableInteractionSource, indication = null
				) {}
				.background(Color.Green)
		)
	}

}

@Composable
private fun DemoAnimatePadding(){
	var toggled by remember{
		mutableStateOf(false)
	}
	val animatedPadding by animateDpAsState(
		targetValue = if(toggled) 0.dp else 20.dp,
		label = "padding"
	)
	Box(
		modifier = Modifier
			.aspectRatio(1f)
			.fillMaxSize()
			.padding(animatedPadding)
			.background(Color.Green)
			.clickable(
				interactionSource = remember {
					MutableInteractionSource()
				},
				indication = null
			) { toggled = !toggled }
	)
}

@Composable
private fun DemoAnimatePositionLayout(){

	var isLookingAhead by remember{
		mutableStateOf(false)
	}
	var toggled by remember {
		mutableStateOf(false)
	}
	val interactionSource = remember {
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
		val offsetTarget = if (toggled){
			IntOffset(150, 150)
		}else {
			IntOffset.Zero
		}
		val offset = animateIntOffsetAsState(
			targetValue = offsetTarget, label = "offset"
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
		Button(onClick = {isLookingAhead = !isLookingAhead}) {
			Text("isLookingAhead: $isLookingAhead")
		}
	}
}


@Composable
private fun DemoAnimatePosition(){
	var moved by remember {
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
	Box(
		modifier = Modifier
			.offset {
				offset
			}
			.background(Color.Blue)
			.size(100.dp)
			.clickable(
				interactionSource = remember { MutableInteractionSource() },
				indication = null
			) {
				moved = !moved
			}
	)
}

@Composable
private fun DemoAnimateSize(){
	var expanded by remember {
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
private fun DemoAnimateBackgroundColor(){
	var animateBackgroundColor by remember{
		mutableStateOf(true)
	}
	val animatedColor by animateColorAsState(
		targetValue = if (animateBackgroundColor) Color.Green else Color.Blue,
		label = "color"
	)
	Column(
		modifier = Modifier
			.fillMaxSize()
			.drawBehind {
				drawRect(animatedColor)
			}
	) {
		Button(onClick = { animateBackgroundColor = !animateBackgroundColor }) {
			Text("배경색 바꾸기")
		}
	}
}

@Composable
private fun DemoAnimateAppearing(){
	var visible by remember{
		mutableStateOf(true)
	}
	val animatedAlpha by animateFloatAsState(
		targetValue = if (visible) 1.0f else 0f,
		label = "alpha",
	)
	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	){
		Row{
			AnimatedVisibility(
				visible = visible,
				enter = expandVertically(),
				exit = shrinkVertically()
			) {
				Box(
					modifier = Modifier
						.size(200.dp)
						.clip(RoundedCornerShape(8.dp))
						.background(Color.Red)
				)
			}
			Box(
				modifier = Modifier
					.size(200.dp)
					.graphicsLayer {
						alpha = animatedAlpha
					}
					.clip(RoundedCornerShape(8.dp))
					.background(Color.Green)
			)
		}
		Button(onClick = {
			visible = !visible
		}) {
			Text(
				text = if(visible) "숨김" else "보여주기"
			)
		}
	}
}
