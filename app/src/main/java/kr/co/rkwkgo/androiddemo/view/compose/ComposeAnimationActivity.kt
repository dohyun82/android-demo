package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.animateRect
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.ShoppingCart
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch
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
		AnimationPage(Modifier.padding(it))
	}
}

@Composable
private fun AnimationPage(
	modifier: Modifier = Modifier
){
	Box(
		modifier = modifier.fillMaxWidth(),
		contentAlignment = Alignment.Center
	){
		DemoRememberInfiniteTransition2()
//		AnimatingBox()
//		DemoTransitionWithAnimatedVisibilityAndAnimatedContent()
//		DemoAnimateFloatAsState2()
//		DemoAnimateContentSize2()
//		DemoCrossfade()
//		DemoAnimatedContentSizeTransForm()
//		DemoAnimatedContentTransitionSpec()
//		DemoAnimateContent()
//		DemoTransitionAnimate()
//		DemoAnimatedVisibilityChildren()
//		DemoMutableTransitionState()
//		DemoAnimatedVisibility2()
//		DemoUpdateTransition()
//		DemoConcurrentAnimation()
//		DemoSequentialAnimation()
//		DemoLaunchAnimation()
//		DemoRememberInfiniteTransition()
//		DemoEnterExitTransition()
//		DemoAnimatedContent()
//		DemoAnimateColor()
//		DemoTextMotion()
//		DemoAnimateDpAsStateForElevation()
//		DemoAnimateDpAsStateForPadding()
//		DemoAnimateLayout()
//		DemoAnimateIntOffsetAsState()
//		DemoAnimateContentSize()
//		DemoAnimateColorAsState()
//		DemoAnimateFloatAsState()
//		DemoAnimatedVisibility()
	}
}

@Composable
private fun DemoRememberInfiniteTransition2(){
	val infiniteTransition = rememberInfiniteTransition(label = "")
	val color by infiniteTransition.animateColor(
		initialValue = Color.Red,
		targetValue = Color.Green,
		animationSpec = infiniteRepeatable(
			animation = tween(1000, easing = LinearEasing),
			repeatMode = RepeatMode.Reverse
		), label = ""
	)
	Box(Modifier.fillMaxSize().background(color))
}

@Composable
private fun AnimatingBox(){
	
	val currentState = remember{
		MutableTransitionState(BoxState.Collapsed)
	}
	val transitionData = updateTransitionData(currentState.targetState)
	Box(
		modifier = Modifier
			.background(transitionData.color)
			.size(transitionData.size)
			.clickable {
				currentState.targetState = if (currentState.targetState == BoxState.Collapsed) {
					BoxState.Expanded
				} else {
					BoxState.Collapsed
				}
			}
	)
}

private class TransitionData(
	color: State<Color>,
	size: State<Dp>
){
	val color by color
	val size by size
}

@Composable
private fun updateTransitionData(boxState: BoxState): TransitionData{
	val transition = updateTransition(targetState = boxState, label = "box state")
	val color = transition.animateColor(label = "color") { state ->
		when(state){
			BoxState.Collapsed -> Color.Gray
			BoxState.Expanded -> Color.Red
		}
	}
	val size = transition.animateDp(label = "size") { state ->
		when(state){
			BoxState.Collapsed -> 64.dp
			BoxState.Expanded -> 128.dp
		}
	}
	return remember(transition) { TransitionData(color, size) }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoTransitionWithAnimatedVisibilityAndAnimatedContent(){
	var selected by remember { mutableStateOf(false) }
	val transition = updateTransition(selected, label = "selected state")
	val borderColor by transition.animateColor(label = "border color") { isSelected ->
		if (isSelected) Color.Magenta else Color.White
	}
	val elevation by transition.animateDp(label = "elevation") { isSelected ->
		if(isSelected) 10.dp else 2.dp
	}
	Surface(
		onClick = {
			selected = !selected
		},
		shape = RoundedCornerShape(8.dp),
		border = BorderStroke(2.dp, borderColor),
		shadowElevation = elevation
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
		) {
			Text(text = "Hello, world!")
			transition.AnimatedVisibility(
				visible = { targetSelected -> targetSelected },
				enter = expandVertically(),
				exit = shrinkVertically()
			) {
				Text("It is find today.")
			}
			transition.AnimatedContent { targetState ->
				if(targetState){
					Text(text = "Selected")
				}else {
					Icon(imageVector = Icons.Default.Phone, contentDescription = null)
				}
			}
		}
	}
}

@Composable
private fun DemoTransition(){
//	var currentState = remember { MutableTransitionState(BoxState.Collapsed) }
//	currentState.targetState = BoxState.Expanded
	var currentState by remember { mutableStateOf(BoxState.Collapsed) }
	val transition = updateTransition(targetState = currentState, label = "box state")

	val rect by transition.animateRect(label = "rectangle") { state ->
		when(state){
			BoxState.Collapsed -> Rect(0f, 0f, 100f, 100f)
			BoxState.Expanded -> Rect(100f, 100f, 300f, 300f)
		}
	}

	val borderWidth by transition.animateDp(label = "border width") { state ->
		when(state){
			BoxState.Collapsed -> 1.dp
			BoxState.Expanded -> 0.dp
		}
	}

	val color by transition.animateColor(
		transitionSpec = {
			when{
				BoxState.Expanded isTransitioningTo BoxState.Collapsed -> {
					spring(stiffness = 50f)
				}
				else -> {
					tween(durationMillis = 500)
				}
			}
		}, label = "") { state ->
		when(state){
			BoxState.Collapsed -> MaterialTheme.colorScheme.primary
			BoxState.Expanded -> MaterialTheme.colorScheme.background
		}
	}



}


@Composable
private fun DemoAnimateFloatAsState2(){
	var enabled by remember { mutableStateOf(true) }
	val alpha: Float by animateFloatAsState(
		targetValue = if(enabled) 1f else 0.5f,
		label = ""
	)
	Box(
		Modifier
			.fillMaxSize()
			.graphicsLayer(alpha = alpha)
			.background(Color.Red)
			.clickable {
				enabled = !enabled
			}
	)
}

@Composable
private fun DemoAnimateContentSize2(){
	var expanded by remember { mutableStateOf(false) }
	Box(
		modifier = Modifier
			.background(Color.Blue)
			.animateContentSize()
			.height(if (expanded) 400.dp else 200.dp)
			.fillMaxWidth()
			.clickable(
				interactionSource = remember { MutableInteractionSource() },
				indication = null
			) {
				expanded = !expanded
			}
	)
}

@Composable
private fun DemoCrossfade(){
	Column {
		var currentPage by remember { mutableStateOf("A") }
		Crossfade(
			targetState = currentPage, label = "Crossfade"
		){ screen ->
			when(screen){
				"A" -> {
					Text("Page A")
				}
				"B" -> {
					Text("Page B")
				}
			}
		}
		Button(onClick = { currentPage = if(currentPage == "B") "A" else "B" }) {
			Text("변경")
		}
	}
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoAnimatedContentSizeTransForm(){
	var expanded by remember { mutableStateOf(false) }
	Surface(
		color = MaterialTheme.colorScheme.primary,
		onClick = { expanded = !expanded }
	) {
		AnimatedContent(
			targetState = expanded,
			transitionSpec = {
				fadeIn(
					animationSpec = tween(150, 150)
				) with
				fadeOut(
					animationSpec = tween(150)
				) using
					SizeTransform { initialSize, targetSize ->
						if(targetState){
							keyframes {
								IntSize(targetSize.width, initialSize.height) at 150
								durationMillis = 300
							}
						}else{
							keyframes {
								IntSize(initialSize.width, targetSize.height) at 150
								durationMillis = 300
							}
						}
					}

			}, label = "AnimatedContent"
		){ targetExpanded ->
			if (targetExpanded){
				Column(
					modifier = Modifier.fillMaxWidth()
				) {
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
					Text(text = "블라블라블라 ~")
				}
			}else{
				Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = null)
			}
		}
	}
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoAnimatedContentTransitionSpec(){
	Column {
		var count by remember { mutableStateOf(0) }
		AnimatedContent(
			targetState = count,
			transitionSpec = {
				if (targetState > initialState){
					slideInVertically { height -> height } + fadeIn() with
						slideOutVertically { height -> -height } + fadeOut()
				} else {
					slideInVertically { height -> -height } + fadeIn() with
						slideOutVertically { height -> height } + fadeOut()
				}.using(
					SizeTransform(clip = false)
				)
			}, label = "AnimatedContent"
		) { targetCount ->
			Text(text = "$targetCount")
		}
		Button(onClick = { count++ }) {
			Text("Add")
		}
	}
}

@Composable
private fun DemoAnimateContent(){
	Row {
		var count by remember { mutableStateOf(0) }
		Button(
			onClick = { count++ }
		){
			Text("Add")
		}
		AnimatedContent(targetState = count, label = "Count") { targetCount ->
			Text(
				text = "Count: $targetCount"
			)
		}
	}
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoTransitionAnimate(){
	var visible by remember { mutableStateOf(true) }
	AnimatedVisibility(
		visible = visible,
		enter = fadeIn(),
		exit = fadeOut()
	) {
		val background by transition.animateColor(label = "color") { state ->
			if (state == EnterExitState.Visible) Color.Blue else Color.Gray
		}
		Box(
			modifier = Modifier
				.size(128.dp)
				.background(background)
		)
	}
	Button(onClick = { visible = !visible }) {
		Text("변경")
	}
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DemoAnimatedVisibilityChildren(){
	var visible by remember {
		mutableStateOf(true)
	}
	Box{
		AnimatedVisibility(
			visible = visible,
			enter = EnterTransition.None,
			exit = ExitTransition.None
		){
			Box(
				Modifier
					.fillMaxSize()
					.background(Color.DarkGray)){
				Box(
					Modifier
						.align(Alignment.Center)
						.animateEnterExit(
							enter = slideInVertically(),
							exit = slideOutVertically()
						)
						.sizeIn(minWidth = 256.dp, minHeight = 256.dp)
						.background(Color.Red)
				){

				}
			}
		}
		Button(onClick = { visible = !visible }) {
			Text("변경")
		}
	}
}

@Composable
private fun DemoMutableTransitionState(){
	var state = remember {
		MutableTransitionState(false).apply {
			targetState = true
		}
	}
	Column {
		AnimatedVisibility(visibleState = state) {
			Text(text = "Hello, world!")
		}
		Text(
			text = when {
				state.isIdle && state.currentState -> "Visible"
				!state.isIdle && state.currentState -> "Disappearing"
				state.isIdle && !state.currentState -> "Invisible"
				else -> "Appearing"
			}
		)
		Button(onClick = { state.targetState = !state.currentState }) {
			Text("업데이트")
		}
	}
}

@Composable
private fun DemoAnimatedVisibility2(){
	var visible by remember {
		mutableStateOf(true)
	}
	val density = LocalDensity.current
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Top,
		horizontalAlignment = Alignment.CenterHorizontally
	){
		AnimatedVisibility(
			visible = visible,
			enter = slideInVertically {
				with(density) { -40.dp.roundToPx()}
			} + expandVertically(
				expandFrom = Alignment.Top
			) + fadeIn(
				initialAlpha = 0.3f
			),
			exit = slideOutVertically() + shrinkVertically() + fadeOut()
		) {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(300.dp)
					.background(Color.Red)
			)
		}
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.height(300.dp)
				.background(Color.Yellow)
		)
		Button(onClick = { visible = !visible }) {
			Text(if(visible) "hide" else "show")
		}
	}
}



enum class BoxState{
	Collapsed,
	Expanded
}

@Composable
private fun DemoUpdateTransition(){
	var currentState by remember { mutableStateOf(BoxState.Collapsed) }
	val transition = updateTransition(
		targetState = currentState,
		label = "transition"
	)
	val rect by transition.animateRect(label = "rect") { state ->
		when(state){
			BoxState.Collapsed -> Rect(0f, 0f, 100f, 100f)
			BoxState.Expanded -> Rect(100f, 100f, 300f, 300f)
		}
	}

	val borderWidth by transition.animateDp(label = "borderWidth") { state ->
		when(state){
			BoxState.Collapsed -> 1.dp
			BoxState.Expanded -> 0.dp
		}
	}
	Box(
		modifier = Modifier
			.background(Color.Yellow)
			.border(
				width = borderWidth,
				color = Color.Blue,
				shape = RectangleShape
			)
			.clickable {
				currentState = BoxState.Expanded
			}
	)

}

@Composable
private fun DemoConcurrentAnimation(){
	val alphaAnimation = remember{ Animatable(0f)}
	val yAnimation = remember{ Animatable(0f)}
	LaunchedEffect("animationKey"){
		launch {
			alphaAnimation.animateTo(1f, animationSpec = tween(3000))
			alphaAnimation.animateTo(0f, animationSpec = tween(3000))
		}
		launch {
			yAnimation.animateTo(100f, animationSpec = tween(3000))
			yAnimation.animateTo(0f, animationSpec = tween(3000))
		}
	}
	Box(
		modifier = Modifier
			.size(100.dp)
			.graphicsLayer {
				alpha = alphaAnimation.value
				translationY = yAnimation.value
			}
			.background(Color.Yellow)
	)
}

@Composable
private fun DemoSequentialAnimation(){
	val alphaAnimation = remember { Animatable(0f) }
	val yAnimation = remember { Animatable(0f) }
	LaunchedEffect("animationKey"){
		yAnimation.animateTo(100f, animationSpec = tween(3000))
		alphaAnimation.animateTo(1f, animationSpec = tween(3000))
		yAnimation.animateTo(500f, animationSpec = tween(3000))
		alphaAnimation.animateTo(0f, animationSpec = tween(3000))
	}
	Box(
		modifier = Modifier
			.fillMaxSize()
	){
		Box(
			modifier = Modifier
				.size(100.dp)
				.graphicsLayer {
					alpha = alphaAnimation.value
					translationY = yAnimation.value
				}
				.background(Color.Yellow)
		)
	}
}

@Composable
private fun DemoLaunchAnimation(){
	val alphaAnimation = remember{
		Animatable(0f)
	}
	LaunchedEffect(Unit){
		alphaAnimation.animateTo(1f)
	}
	Box(
		modifier = Modifier
			.fillMaxSize()
			.graphicsLayer {
				alpha = alphaAnimation.value
			}
			.background(Color.Yellow)
	)
}


@Composable
private fun DemoRememberInfiniteTransition(){
	val infiniteTransition = rememberInfiniteTransition(label = "infinite")
	val color by infiniteTransition.animateColor(
		initialValue = Color.Green,
		targetValue = Color.Blue,
		animationSpec = infiniteRepeatable(
			animation = tween(1000, easing = LinearEasing),
			repeatMode = RepeatMode.Reverse
		),
		label = "color"
	)
	Column(
		modifier = Modifier
			.fillMaxSize()
			.drawBehind {
				drawRect(color)
			}
	) {

	}
}

@Composable
private fun DemoEnterExitTransition(){
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = "landing",
		enterTransition = {
			EnterTransition.None
		},
		exitTransition = {
			ExitTransition.None
		}
	){
		composable("landing"){
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Blue)
			){
				Button(onClick = { navController.navigate("detail/rkwkgo") }) {
					Text("상세화면 이동")
				}
			}
		}
		composable(
			"detail/{photoUrl}",
			arguments = listOf(navArgument("photoUrl"){
				type = NavType.StringType
			}),
			enterTransition = {
				fadeIn(
					animationSpec = tween(
						300, easing = LinearEasing
					)
				) + slideIntoContainer(
					animationSpec = tween(300, easing = EaseIn),
					towards = AnimatedContentTransitionScope.SlideDirection.Start
				)
			},
			exitTransition = {
				fadeOut(
					animationSpec = tween(
						300, easing = LinearEasing
					)
				) + slideOutOfContainer(
					animationSpec = tween(300, easing = EaseOut),
					towards = AnimatedContentTransitionScope.SlideDirection.End
				)
			}
		){ backStackEntry ->
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Yellow)
			){
				Button(onClick = { navController.navigateUp() }) {
					Text("뒤로가기")
				}
			}
		}
	}
}

enum class UiState{
	Loading,
	Loaded,
	Error
}

@Composable
private fun DemoAnimatedContent(){
	var state by remember{
		mutableStateOf(UiState.Loading)
	}
	AnimatedContent(
		targetState = state,
		transitionSpec = {
			fadeIn(
				animationSpec = tween(3000)
			) togetherWith
			fadeOut(
				animationSpec = tween(3000)
			)
		},
		modifier = Modifier.clickable(
			interactionSource = remember{ MutableInteractionSource() },
			indication = null
		) {
			state = when(state){
				UiState.Loading -> UiState.Loaded
				UiState.Loaded -> UiState.Error
				UiState.Error -> UiState.Loading
			}
		},
		label = "Animated Content"
	) { targetState ->
		when(targetState){
			UiState.Loading -> {
				Text("로딩중")
			}
			UiState.Loaded -> {
				Text("로드 완료")
			}
			UiState.Error -> {
				Text("에러")
			}
		}
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
		}
	)
}

@Composable
private fun DemoTextMotion(){
	val infiniteTransition = rememberInfiniteTransition(
		label = "infinite transition"
	)
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
private fun DemoAnimateDpAsStateForElevation(){
	val mutableInteractionSource = remember{ MutableInteractionSource() }
	val pressed = mutableInteractionSource.collectIsPressedAsState()
	val elevation = animateDpAsState(
		targetValue = if (pressed.value){
			32.dp
		}else{
			8.dp
		},
		label = "elevation"
	)
	Box(
		modifier = Modifier
			.size(100.dp)
			.graphicsLayer {
				this.shadowElevation = elevation.value.toPx()
			}
			.clickable(
				interactionSource = mutableInteractionSource,
				indication = null
			) {

			}
			.background(Color.Green)
	)
}

@Composable
private fun DemoAnimateDpAsStateForPadding(){
	var toggled by remember{
		mutableStateOf(false)
	}
	val animatedPadding by animateDpAsState(
		targetValue = if (toggled) {
			0.dp
		} else {
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
				interactionSource = remember { MutableInteractionSource() },
				indication = null
			) {
				toggled = !toggled
			}
	)
}

@Composable
private fun DemoAnimateLayout(){
	val isLookingAhead = false
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
private fun DemoAnimateIntOffsetAsState(){
	var moved by remember {
		mutableStateOf(false)
	}
	val pxToMove = with(LocalDensity.current){
		100.dp.toPx().roundToInt()
	}
	val offset by animateIntOffsetAsState(
		targetValue = if (moved) {
			IntOffset(pxToMove, pxToMove)
		} else {
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
	var expanded by remember{
		mutableStateOf(false)
	}
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(
			modifier = Modifier
				.background(Color.Blue)
				.animateContentSize()
				.height(if (expanded) 400.dp else 200.dp)
				.fillMaxWidth()
				.clickable(
					interactionSource = remember { MutableInteractionSource() },
					indication = null
				) {
					expanded = !expanded
				}
		)
	}
}

@Composable
private fun DemoAnimateColorAsState(){
	var animateBackgroundColor by remember{
		mutableStateOf(true)
	}
	val animatedColor by animateColorAsState(
		targetValue = if(animateBackgroundColor) Color.Green else Color.Blue,
		label = "color"
	)
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(
			modifier = Modifier
				.size(200.dp)
				.drawBehind {
					drawRect(animatedColor)
				}
		)
		Button(
			onClick = {animateBackgroundColor = !animateBackgroundColor }
		){
			var text = if(animateBackgroundColor) "파랑" else "초록"
			Text(text)
		}
	}
}

@Composable
private fun DemoAnimateFloatAsState(){
	var visible by remember{
		mutableStateOf(true)
	}
	val animatedAlpha by animateFloatAsState(
		targetValue = if(visible) 1.0f else 0f,
		label = "alpha"
	)
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(
			modifier = Modifier
				.size(200.dp)
				.graphicsLayer {
					alpha = animatedAlpha
				}
				.clip(RoundedCornerShape(8.dp))
				.background(Color.Red)
		)
		Button(
			onClick = {visible = !visible }
		){
			var text = if(visible) "숨기기" else "보여주기"
			Text(text)
		}
	}

}

@Composable
private fun DemoAnimatedVisibility(){
	var visible by remember{
		mutableStateOf(true)
	}
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		AnimatedVisibility(visible = visible) {
			Box(
				Modifier
					.fillMaxWidth()
					.height(100.dp)
					.padding(horizontal = 20.dp)
					.clip(RoundedCornerShape(100.dp))
					.background(
						color = Color.Red
					)
			)
		}
		Button(
			onClick = {visible = !visible }
		){
			var text = if(visible) "숨기기" else "보여주기"
			Text(text)
		}
	}
}