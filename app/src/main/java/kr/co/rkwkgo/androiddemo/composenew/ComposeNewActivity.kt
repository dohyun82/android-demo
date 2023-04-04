package kr.co.rkwkgo.androiddemo.composenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.layout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.composenew.ui.theme.AndroidDemoTheme

class ComposeNewActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MessageCard(
				Message("Android", "Jetpack Compose")
			)
		}
	}

	data class Message(val author: String, val body: String)

	@Composable
	fun MessageCard(msg: Message){
		Row {
			Image(
				painter = painterResource(id = R.drawable.ic_empty_user_img),
				contentDescription = "Contact profile picture"
			)
			Column {
				Text(text = msg.author)
				Text(text = msg.body)
			}
		}
	}


	@Preview
	@Composable
	fun PreviewMessageCard(){
		MessageCard(
			msg = Message("Colleague", "Hey, take a look at Jetpack Compose.")
		)
	}
}