package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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

@Preview
@Composable
private fun PreviewScaffoldExample(){
	ScaffoldExample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScaffoldExample(){
	var presses by remember { mutableIntStateOf(0) }
	Scaffold(
		topBar = {
			TopAppBar(
				colors = topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary
				),
				title = {
					Text("Top app bar")
				}
			)
		},
		bottomBar = {
			BottomAppBar(
				containerColor = MaterialTheme.colorScheme.primaryContainer,
				contentColor = MaterialTheme.colorScheme.primary
			) {
				Text(
					modifier = Modifier.fillMaxWidth(),
					textAlign = TextAlign.Center,
					text = "Bottom app bar",
				)
			}
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { presses++ }) {
				Icon(Icons.Default.Add, contentDescription = "Add")
			}
		}
	) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding),
			verticalArrangement =  Arrangement.spacedBy(16.dp)
		) {
			Text(
				modifier = Modifier.padding(8.dp),
				text =
					"""
This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

It also contains some basic inner content, such as this text.

You have pressed the floating action button $presses times.
					""".trimIndent()
			)
		}
	}
}

@Preview
@Composable
private fun PreviewSmallTopAppBarExample(){
	SmallTopAppBarExample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SmallTopAppBarExample(){
	Scaffold(
		topBar = {
			TopAppBar(
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary
				),
				title = {
					Text("Small Top App Bar")
				}
			)
		}
	) { innerPadding ->
		ScrollContent(Modifier.padding(innerPadding))
	}
}

@Preview
@Composable
private fun PreviewBottomAppBarExample(){
	BottomAppBarExample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomAppBarExample(){
	Scaffold(
		bottomBar = {
			BottomAppBar(
				actions = {
					IconButton(onClick = { }) {
						Icon(Icons.Filled.Check, contentDescription = null)
					}
					IconButton(onClick = { }) {
						Icon(Icons.Filled.Edit, contentDescription = null)
					}
					IconButton(onClick = { }) {
						Icon(Icons.Filled.Mic, contentDescription = null)
					}
					IconButton(onClick = { }) {
						Icon(Icons.Filled.Image, contentDescription = null)
					}
				},
				floatingActionButton = {
					FloatingActionButton(
						onClick = {  },
						containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
						elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
					) {
						Icon(Icons.Filled.Add, "Localized description")
					}
				}
			)
		}
	) {
		Text(
			modifier = Modifier.padding(it),
			text = "Example of a scaffold with a bottom app bar."
		)
	}
}

@Preview
@Composable
private fun PreviewTopAppBarExample(){
	TopAppBarExample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarExample(){
	val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = {
			MediumTopAppBar(
				colors = topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary,
				),
				title = {
					Text(
						"Top App Bar",
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
				},
				navigationIcon = {
					IconButton(onClick = {  }) {
						Icon(
							imageVector = Icons.Filled.ArrowBack,
							contentDescription = null
						)
					}
				},
				actions = {
					IconButton(onClick = {}) {
						Icon(
							imageVector = Icons.Filled.Menu,
							contentDescription = null
						)
					}
				},
				scrollBehavior = scrollBehavior,
			)
		}
	) {
		ScrollContent(Modifier.padding(it))
	}
}

@Composable
private fun ScrollContent(
	modifier: Modifier = Modifier
){
	Column(
		modifier = modifier.verticalScroll(rememberScrollState()),
	) {
		Text("테스트", modifier = Modifier
			.height(300.dp)
			.fillMaxWidth()
			.background(Color.Red) )
		Text("테스트", modifier = Modifier
			.height(300.dp)
			.fillMaxWidth()
			.background(Color.Red) )
		Text("테스트", modifier = Modifier
			.height(300.dp)
			.fillMaxWidth()
			.background(Color.Red) )
		Text("테스트", modifier = Modifier
			.height(300.dp)
			.fillMaxWidth()
			.background(Color.Red) )
	}
}

