package kr.co.rkwkgo.androiddemo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.compose.ui.theme.AndroidDemoTheme

class StateActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					HelloScreen()
				}
			}
		}
	}
}

@Composable
fun HelloScreen() {
	var name by rememberSaveable {
		mutableStateOf("")
	}
	HelloContent(name = name, onNameChange = {name = it})
}


@Composable
fun HelloContent(name:String, onNameChange: (String) -> Unit){
	Column(modifier = Modifier
		.padding(16.dp)
		.background(Color.White)
		.fillMaxSize()
	) {
		Text(
			text = "Hello, $name",
			modifier = Modifier.padding(bottom = 8.dp),
			style = MaterialTheme.typography.h5
		)
		OutlinedTextField(
			value = name,
			onValueChange = onNameChange ,
			label = { Text(text = "Name")}
		)
	}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
	AndroidDemoTheme {
		HelloScreen()
	}
}