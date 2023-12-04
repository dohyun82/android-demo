package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

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
	Column(
		modifier = modifier.fillMaxWidth(),
	){
		DemoAnimatedContent()
	}
}

enum class UIState{
	Loading, Loaded, Error
}

@Composable
private fun DemoAnimatedContent(){
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
			interactionSource = remember{ MutableInteractionSource() },
			indication = null
		) {
		  state = when(state){
			  UIState.Loading -> UIState.Loaded
			  UIState.Loaded -> UIState.Error
			  UIState.Error -> UIState.Loading
		  }
		},
		label = "AnimatedContent"
	) {targetState ->
		when(targetState){
			UIState.Loading -> {
				Box(
					modifier = Modifier.fillMaxSize()
				){
					Text("로딩중",
						modifier = Modifier.align(Alignment.Center)
					)
				}
			}
			UIState.Loaded -> {
				Box(
					modifier = Modifier.fillMaxSize()
				){
					Text("로드 완료",
						modifier = Modifier.align(Alignment.Center)
					)
				}
			}
			UIState.Error -> {
				Box(
					modifier = Modifier.fillMaxSize()
				){
					Text("에러",
						modifier = Modifier.align(Alignment.Center)
					)
				}
			}
		}
	}
}
