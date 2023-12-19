package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

/**
 * 레이아웃 화면
 */
class ComposeLayoutActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LayoutContent()
		}
	}
}

@Composable
private fun LayoutContent(){
	AndroidDemoTheme {
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			CustomLayoutPage()
		}
	}
}

@Preview
@Composable
private fun PreviewCustomLayoutPage(){
	CustomLayoutPage()
}

@Composable
private fun CustomLayoutPage(){
	Scaffold {
		CustomLayoutBody(Modifier.padding(it))
	}
}

/**
 * layout 수정자 사용 예제
 */
fun Modifier.firstBaselineToTop(
	firstBaselineToTop: Dp
) = layout { measurable, constraints ->
	// Measure the composable
	val placeable = measurable.measure(constraints)

	// Check the composable has a first baseline
	check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
	val firstBaseline = placeable[FirstBaseline]

	// Height of the composable with padding - first baseline
	val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
	val height = placeable.height + placeableY
	layout(placeable.width, height){
		// Where the composable gets placed
		placeable.placeRelative(0, placeableY)
	}
}

@Composable
private fun CustomLayoutBody(
	modifier: Modifier = Modifier
){
	MyBasicColumn(
		modifier = modifier.padding(8.dp)
	) {
		Text("Hi, Kim!",
			Modifier
				.firstBaselineToTop(32.dp)
				.background(Color.Red))
		Text("Hi, Kim!",
			Modifier
				.padding(top = 32.dp)
				.background(Color.Green))
		Text("MyBasicColumn")
		Greeting(name = "Kim")
	}
}

@Composable
fun MyBasicColumn(
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit,
){
	Layout(
		modifier = modifier,
		content = content
	){ measurables, constraints ->
		// Don't constrain child views further, measure them with given constraints
		// List of measured children
		val placeables = measurables.map { measurable ->
			// Measure each children
			measurable.measure(constraints)
		}

		// Set the size of the layout as big as it can
		layout(constraints.maxWidth, constraints.maxHeight){
			// Track the y co-ord we have placed children up to
			var yPosition = 0

			// Place children in the parent layout
			placeables.forEach { placeable ->
				// Position item on the screen
				placeable.placeRelative(x = 0, y = yPosition)
				// Record the y co-ord placed up to
				yPosition += placeable.height
			}
		}
	}
}

@Composable
private fun Greeting(name: String){
	Column(
		modifier = Modifier
			.background(Color.Blue)
			.padding(24.dp)
			.fillMaxWidth()
	) {
		Text(text = "Hello,")
		Text(text = name)
	}
}

@Composable
private fun ArtistCard(){
	val padding = 16.dp
	Column(
		Modifier
			.clickable(onClick = { })
			.padding(padding)
			.fillMaxWidth()
	) {

	}
}
