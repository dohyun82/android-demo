package kr.co.rkwkgo.androiddemo.composenew.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.composenew.material3.ui.theme.AndroidDemoTheme

class ComposeMaterial3Activity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				MyApp(modifier = Modifier.fillMaxSize())
			}
		}
	}
}

@Composable
private fun MyApp(
	modifier: Modifier = Modifier,
){

	var shouldShowOnboarding by rememberSaveable {
		mutableStateOf(true)
	}

	Surface(modifier = modifier) {
		if(shouldShowOnboarding){
			OnboardingScreen{
				shouldShowOnboarding = false
			}
		}else{
			Greetings()
		}
	}

}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked : () -> Unit){
	Column (
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Welcome to the Basics Codelab!")
		Button(
			modifier = Modifier.padding(vertical = 24.dp),
			onClick = onContinueClicked
		) {
			Text(text = "Continue")
		}
	}
}


@Composable
private fun Greetings(
	modifier: Modifier = Modifier,
	names: List<String> = List(1000) {"$it"}
){
	LazyColumn(modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
		items(items = names) { name ->
			Greeting(name = name)
		}
	}
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview(){
	AndroidDemoTheme {
		OnboardingScreen(onContinueClicked = {})
	}
}

@Composable
private fun Greeting(name: String){
	val expended = remember {
		mutableStateOf(false)
	}
	val extraPadding = if (expended.value) 48.dp else 0.dp

	Surface(
		color = MaterialTheme.colorScheme.primary,
		modifier = Modifier.padding(vertical = 4.dp)) {
		Row(
			modifier = Modifier.padding(24.dp)
		){
			Column(
				modifier = Modifier
					.weight(1F)
					.padding(extraPadding)
			) {
				Text(text = "Hello,")
				Text(text = name)
			}
			ElevatedButton(
				onClick = {
					expended.value = !expended.value
				},
			) {
				Text(if (expended.value) "Show less" else "Show more")
			}
		}

	}
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview(){
	AndroidDemoTheme {
		Greetings()
	}
}

@Preview
@Composable
fun MyAppPreview(){
	AndroidDemoTheme {
		MyApp(Modifier.fillMaxSize())
	}
}