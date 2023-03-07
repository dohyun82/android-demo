package kr.co.rkwkgo.androiddemo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.compose.ui.theme.AndroidDemoTheme

class ComposeDemo3Activity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					Greeting("Android")
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String) {
	Scaffold(
		topBar = { TopAppBar(title = {Text("rkwkgo")},backgroundColor = Color.Blue)
				 },
		floatingActionButtonPosition = FabPosition.End,
		floatingActionButton = { FloatingActionButton(onClick = {}){
			Text("클릭")
		} },
	) {
		MyComposableView()
	}
}

@Composable
fun MyRowItem(){
	Row(
		Modifier
			.padding(all = 10.dp)
			.background(color = Color(0xffabcdef))
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically
	){
		Text(text = "안녕하세요?!",
			Modifier
				.padding(all = 10.dp)
				.background(Color.Yellow))
		Spacer(modifier = Modifier.size(10.dp))
		Text(text = "안녕하세요?!")
		Spacer(modifier = Modifier.size(10.dp))
		Text(text = "안녕하세요?!")
	}
}

@Composable
fun MyComposableView(){
	Column(
		Modifier
			.background(Color.Green)
			.verticalScroll(rememberScrollState())
	) {
		for (i in 0..30){
			MyRowItem()
		}
	}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	AndroidDemoTheme {
		Greeting("프리뷰")
	}
}