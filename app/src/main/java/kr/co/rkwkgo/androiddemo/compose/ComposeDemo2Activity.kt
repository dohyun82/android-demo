package kr.co.rkwkgo.androiddemo.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.compose.ui.theme.AndroidDemoTheme

class ComposeDemo2Activity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				Surface(modifier = Modifier.fillMaxSize()){
					Conversation2(SampleData2.conversationSample)
				}
			}
		}
	}
}

data class Message2(val author: String, val body: String)

@Composable
fun MessageCard2(msg: Message2){
	Row (modifier = Modifier.padding(all = 8.dp)) {
		Image(
			painter = painterResource(id = R.drawable.profile_picture),
			contentDescription = "Contact profile picture",
			modifier = Modifier
				.size(40.dp)
				.clip(CircleShape)
				.border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
		)

		Spacer(modifier = Modifier.width(8.dp))

		var isExpanded by remember {
			mutableStateOf(false)
		}

		val surfaceColor by animateColorAsState(
			if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
		)

		Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
			Text(
				text = msg.author,
				color = MaterialTheme.colors.secondaryVariant,
				style = MaterialTheme.typography.subtitle2
			)
			Spacer(modifier = Modifier.height(4.dp))
			Surface(
				shape = MaterialTheme.shapes.medium,
				elevation = 1.dp,
				color = surfaceColor,
				modifier = Modifier.animateContentSize().padding(1.dp)
				) {
				Text(
					text = msg.body,
					modifier = Modifier.padding(all = 4.dp),
					maxLines = if (isExpanded) Int.MAX_VALUE else 1,
					style = MaterialTheme.typography.body2
				)
			}
		}
	}
}

@Preview(name = "Light Mode")
@Preview(
	uiMode = Configuration.UI_MODE_NIGHT_YES,
	showBackground = true,
	name = "Dark Mode"
)
@Composable
fun PreviewMessageCard2(){
	AndroidDemoTheme {
		Surface {
			MessageCard2(msg = Message2("Colleague", "Hey, take a look at Jetpack Compose, it's great!"))
		}
	}
}

@Composable
fun Conversation2(messages: List<Message2>){
	LazyColumn {
		items(messages){message ->
			MessageCard2(msg = message)
		}
	}
}

@Preview
@Composable
fun PreviewConversation2(){
	AndroidDemoTheme {
		Conversation2(messages = SampleData2.conversationSample)
	}
}
object SampleData2 {
	// Sample conversation data
	val conversationSample = listOf(
		Message2(
			"Colleague",
			"Test...Test...Test..."
		),
		Message2(
			"Colleague",
			"List of Android versions:\n" +
					"Android KitKat (API 19)\n" +
					"Android Lollipop (API 21)\n" +
					"Android Marshmallow (API 23)\n" +
					"Android Nougat (API 24)\n" +
					"Android Oreo (API 26)\n" +
					"Android Pie (API 28)\n" +
					"Android 10 (API 29)\n" +
					"Android 11 (API 30)\n" +
					"Android 12 (API 31)\n"
		),
		Message2(
			"Colleague",
			"I think Kotlin is my favorite programming language.\n" +
					"It's so much fun!"
		),
		Message2(
			"Colleague",
			"Searching for alternatives to XML layouts..."
		),
		Message2(
			"Colleague",
			"Hey, take a look at Jetpack Compose, it's great!\n" +
					"It's the Android's modern toolkit for building native UI." +
					"It simplifies and accelerates UI development on Android." +
					"Less code, powerful tools, and intuitive Kotlin APIs :)"
		),
		Message2(
			"Colleague",
			"It's available from API 21+ :)"
		),
		Message2(
			"Colleague",
			"Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
		),
		Message2(
			"Colleague",
			"Android Studio next version's name is Arctic Fox"
		),
		Message2(
			"Colleague",
			"Android Studio Arctic Fox tooling for Compose is top notch ^_^"
		),
		Message2(
			"Colleague",
			"I didn't know you can now run the emulator directly from Android Studio"
		),
		Message2(
			"Colleague",
			"Compose Previews are great to check quickly how a composable layout looks like"
		),
		Message2(
			"Colleague",
			"Previews are also interactive after enabling the experimental setting"
		),
		Message2(
			"Colleague",
			"Have you tried writing build.gradle with KTS?"
		),
	)
}