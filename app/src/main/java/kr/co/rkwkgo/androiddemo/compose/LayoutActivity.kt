package kr.co.rkwkgo.androiddemo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.compose.ui.theme.AndroidDemoTheme

class LayoutActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					AlignInRow()
				}
			}
		}
	}
}

@Composable
fun UserData() {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Start,
		modifier = Modifier
			.fillMaxWidth()
			.background(Color.Yellow)
		) {
		Image(
			painter = painterResource(id = R.drawable.ic_empty_user_img),
			contentDescription = null,
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.padding(8.dp, 12.dp, 8.dp, 12.dp)
				.size(44.dp)
				.clip(shape = CircleShape)
		)
		Column {
			Text(text = "name")
			Text(text = "lastSeenOnline",
				Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
				)
		}
	}
}

@Composable
fun AlignInRow(){
	Row(
		modifier = Modifier
			.size(150.dp)
			.background(Color.Yellow),
		horizontalArrangement = Arrangement.End,
		verticalAlignment = Alignment.CenterVertically
	) {
		Box(modifier = Modifier
			.size(50.dp)
			.background(Color.Red)
		)
		Box(modifier = Modifier
			.size(50.dp)
			.background(Color.Green),
			contentAlignment = Alignment.Center
		){
			Box(modifier = Modifier
				.size(30.dp)
				.background(Color.Blue)
			)
		}
	}
}

@Composable
fun ArtistCard(
	onClick: () -> Unit
){
	val padding = 16.dp
	Column(
		Modifier
			.clickable(onClick = onClick)
			.padding(padding)
			.fillMaxWidth()
	) {
		UserData()
		Spacer(modifier = Modifier.size(padding))
		Card(elevation = 4.dp) {
			Image(painter = painterResource(id = R.drawable.ic_empty_user_img),
				contentDescription = null,
				modifier = Modifier.fillMaxWidth(),
				contentScale = ContentScale.Crop
			)
		}
	}
}

@Composable
fun FixedSizeComposable(){
	Box(modifier = Modifier
		.size(90.dp, 150.dp)
		.background(Color.Green)){
		Box(modifier = Modifier
			.requiredSize(100.dp, 100.dp)
			.background(Color.Red))
	}
}

@Composable
fun FillSizeComposable(){
	Box(modifier = Modifier
		.background(Color.Green)
		.size(50.dp)
		.padding(10.dp)){
		Box(modifier = Modifier
			.background(Color.Blue)
			.fillMaxSize())
	}
}

@Composable
fun MatchParentSizeComposable(){
	Box {
		Spacer(modifier =
		Modifier
			.matchParentSize()
			.background(Color.Green))
		Text(text = "Hello World")
	}
}

@Composable
fun TextWithPaddingFromBaseline(){
	Box(modifier = Modifier.background(Color.Yellow)){
		Text(text = "Hi there!", Modifier.paddingFromBaseline(top = 32.dp))
	}
}

@Composable
fun OffsetComposable() {
	Box(modifier = Modifier
		.background(Color.Yellow)
		.size(width = 150.dp, height = 70.dp)){
		Text(text = "Layout offset modifier sample",
			Modifier.offset(x = 15.dp, y = 20.dp)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
	AndroidDemoTheme {
		OffsetComposable()
	}
}