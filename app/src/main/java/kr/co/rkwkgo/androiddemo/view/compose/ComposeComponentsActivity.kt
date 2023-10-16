package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

class ComposeComponentsActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ComponentsContent()
		}
	}
}

@Composable
fun ComponentsContent(){
	AndroidDemoTheme {
		// A surface container using the 'background' color from the theme
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
//			ScaffoldExample()
//			SmallTopAppBarExample()
//			CenterAlignedTopAppBarExample()
//			MediumTopAppBarExample()
//			LargeTopAppBarExample()
//			FilledButtonExample{}
//			FilledTonalButtonExample{}
//			OutlinedButtonExample{}
//			ElevatedButtonExample{}
//			TextButtonExample{}
//			FABExample{}
//			FABSmallExample{}
//			FABLargeExample{}
			FABExtendedExample{}
		}
	}
}

@Composable
private fun FABExtendedExample(onClick: () -> Unit){
	Box{
		ExtendedFloatingActionButton(
			onClick = onClick,
			icon = {
				   Icon(Icons.Filled.Edit, "Extended floating action button.")
			},
			text = {
				Text("Extended FAB")
			}
		)
	}
}

@Composable
private fun FABLargeExample(onClick: () -> Unit){
	Box{
		LargeFloatingActionButton(
			onClick = onClick,
			shape = CircleShape
		) {
			Icon(Icons.Filled.Add, "Large floating action button")
		}
	}
}

@Composable
private fun FABSmallExample(onClick: () -> Unit){
	Box{
		SmallFloatingActionButton(
			onClick = onClick,
			containerColor = MaterialTheme.colorScheme.secondaryContainer,
			contentColor = MaterialTheme.colorScheme.secondary
		) {
			Icon(imageVector = Icons.Filled.Add, contentDescription = "Small floating action button.")
		}
	}
}

@Composable
private fun FABExample(onClick: () -> Unit){
	Box(
		contentAlignment = Alignment.BottomEnd
	){
		FloatingActionButton(onClick = onClick) {
			Icon(imageVector = Icons.Filled.Add, contentDescription = "Floating action button.")
		}
	}
}

@Composable
private fun TextButtonExample(onClick: () -> Unit){
	Box{
		TextButton(onClick = onClick) {
			Text("Text Button")
		}
	}
}

@Composable
private fun ElevatedButtonExample(onClick: () -> Unit){
	Box{
		ElevatedButton(onClick = onClick) {
			Text("Elevated")
		}
	}
}

@Composable
private fun OutlinedButtonExample(onClick: () -> Unit){
	Box{
		OutlinedButton(onClick = onClick) {
			Text("Outlined")
		}
	}
}

@Composable
private fun FilledTonalButtonExample(onClick: () -> Unit){
	Box{
		FilledTonalButton(onClick = onClick) {
			Text("Tonal")
		}
	}
}


@Composable
private fun FilledButtonExample(onClick: () -> Unit){
	Box{
		Button(onClick = onClick) {
			Text("Filled")
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarExample(){
	val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = {
			LargeTopAppBar(
				colors = topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary
				),
				title = {
					Text(
						"Large Top App Bar",
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
				},
				navigationIcon = {
					IconButton(onClick = { }) {
						Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Localized description")
					}
				},
				actions = {
					IconButton(onClick = { }) {
						Icon(
							imageVector = Icons.Filled.Menu,
							contentDescription = null
						)
					}
				},
				scrollBehavior = scrollBehavior
			)
		}
	) {
		ScrollContent(innerPadding = it)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarExample(){
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = {
			MediumTopAppBar(
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary,
				),
				title = {
					Text(
						"Medium top App Bar",
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
				},
				navigationIcon = {
					IconButton(onClick = {  }) {
						Icon(
							imageVector = Icons.Filled.ArrowBack,
							contentDescription = "Localized description"
						)
					}
				},
				actions = {
					IconButton(onClick = { }) {
						Icon(
							imageVector = Icons.Filled.Menu,
							contentDescription = "Localized description"
						)
					}
				},
				scrollBehavior = scrollBehavior
			)
		},
	){
		ScrollContent(innerPadding = it)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarExample(){
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

		topBar = {
			CenterAlignedTopAppBar(
				colors = topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary
				),
				title = {
					Text(
						"Centered Top App Bar",
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
				},
				navigationIcon = {
					IconButton(onClick = {  }) {
						Icon(
							imageVector = Icons.Filled.ArrowBack,
							contentDescription = "Localized description"
						)
					}
				},
				actions = {
					IconButton(onClick = { }) {
						Icon(
							imageVector = Icons.Filled.Menu,
							contentDescription = "Localized description"
						)
					}
				},
				scrollBehavior = scrollBehavior
			)
		}

	) {
		ScrollContent(it)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample(){
	Scaffold(
		topBar = {
			TopAppBar(
				colors = topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary
				),
				title = {
					Text(text = "Small Top App Bar")
				}
			)
		},
	) {
		ScrollContent(it)
	}
}

@Composable
fun ScrollContent(innerPadding: PaddingValues){
	Column(
		modifier = Modifier
			.padding(innerPadding)
			.verticalScroll(rememberScrollState()),
		verticalArrangement = Arrangement.spacedBy(16.dp),
	) {
		Text(
			modifier = Modifier.padding(8.dp),
			text = """
					This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
					
					This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
					
					This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
					
					This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
					
					This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
					
					This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
				""".trimIndent()
		)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(){
	var presses by remember { mutableIntStateOf(0)}
	Scaffold(
		topBar = {
			TopAppBar(
				colors = topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary
				),
				title = {
					Text("Top app bar")
				},
			)
		},
		bottomBar = {
			BottomAppBar(
				containerColor = MaterialTheme.colorScheme.primaryContainer,
				contentColor = MaterialTheme.colorScheme.primary
			){
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
			modifier = Modifier.padding(innerPadding),
			verticalArrangement = Arrangement.spacedBy(16.dp)
		) {
			Text(
				modifier = Modifier.padding(8.dp),
				text = """
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
fun PreviewComponentsContent(){
	ComponentsContent()
}
