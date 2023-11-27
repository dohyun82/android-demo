package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
		DemoAnimateLayout()
	}
}

@Composable
private fun DemoAnimateLayout(){
	val isLookingAhead = false
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
		val offsetTarget = if (toggled){
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
					val offsetValue = if(isLookingAhead) offsetTarget else offset.value
					val placeable = measurable.measure(constraints)
					layout(placeable.width + offsetValue.x, placeable.height + offsetValue.y){
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
private fun DemoAnimateIntOffset(){
	var moved by remember {
		mutableStateOf(false)
	}
	val pxToMove = with(LocalDensity.current){
		100.dp.toPx().roundToInt()
	}
	val offset by animateIntOffsetAsState(
		targetValue = if (moved) {
			IntOffset(pxToMove, pxToMove)
		}else {
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
private fun DemoAnimateContentSize(){
	var expanded by remember {
		mutableStateOf(false)
	}
	Box(
		modifier = Modifier
			.background(Color.Blue)
			.animateContentSize()
			.height(if (expanded) 400.dp else 200.dp)
			.fillMaxWidth()
			.clickable {
				expanded = !expanded
			}
	){
		Text("블라블라블라~~~\n블라블라블라~~~\n블라블라블라~~~\n블라블라블라~~~\n블라블라블라~~~\n블라블라블라~~~\n블라블라블라~~~"
			, color = Color.White
		)
	}
}

@Composable
private fun DemoAnimateColor(){
	var animateBackgroundColor by remember{
		mutableStateOf(true)
	}
	val animatedColor by animateColorAsState(
		if(animateBackgroundColor) Color.Green else Color.Blue,
		label = "color"
	)

	Column(
		modifier = Modifier
			.fillMaxSize()
			.drawBehind {
				drawRect(animatedColor)
			}
			.clickable {
				animateBackgroundColor = !animateBackgroundColor
			}
	){}

}

@Composable
private fun DemoAnimateFloatAsState(){
	var visible by remember {
		mutableStateOf(true)
	}
	val animatedAlpha by animateFloatAsState(
		targetValue = if(visible) 1.0f else 0f,
		label = "alpha"
	)
	Column {
		Box(
			modifier = Modifier
				.size(200.dp)
				.padding(16.dp)
				.graphicsLayer {
					alpha = animatedAlpha
				}
				.clip(RoundedCornerShape(8.dp))
				.background(Color.Green)
		)
		Box(
			modifier = Modifier
				.size(200.dp)
				.padding(16.dp)
				.clip(RoundedCornerShape(8.dp))
				.background(Color.Blue)
				.clickable {
					visible = !visible
				}
		)
	}
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoAnimatedVisibility(){
	var visible by remember{
		mutableStateOf(true)
	}
	Column {
		AnimatedVisibility(
			visible,
			enter = expandHorizontally(),
			exit = shrinkHorizontally()
		){
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(200.dp)
					.padding(16.dp)
					.background(Color.Green)
			){
				Text("....",
					fontSize = 90.sp,
					modifier = Modifier.animateEnterExit(
						enter = fadeIn(),
						exit = fadeOut()
						)
					)
			}
		}
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.height(200.dp)
				.padding(16.dp)
				.background(Color.Blue)
				.clickable {
					visible = !visible
				}
		)
	}
}

