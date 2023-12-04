package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
	Box(
		modifier = modifier.fillMaxWidth(),
		contentAlignment = Alignment.Center
	){
		DemoAnimateColorState()
	}
}

@Composable
private fun DemoAnimateColorState(){
	var animateBackgroundColor by remember{
		mutableStateOf(false)
	}
	val animateColor by animateColorAsState(
		targetValue = if(animateBackgroundColor) Color.Red else Color.Blue, label = "color"
	)
	Column {
		Box(
			modifier = Modifier.fillMaxWidth().height(100.dp).drawBehind {
				drawRect(animateColor)
			}
		)
		TextButton(onClick = { animateBackgroundColor = !animateBackgroundColor }) {
			Text(text = "색상 바꾸기")
		}
	}
}
