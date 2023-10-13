package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

class BottomSheetsActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
//		WindowCompat.setDecorFitsSystemWindows(window, false)
		setContent {
			BottomSheetsContent()
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsContent(){
	AndroidDemoTheme {
		// A surface container using the 'background' color from the theme
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			Scaffold(
				topBar = { TopAppBar(title = { Text("text") }) }
			) {
				BottomSheetsPage2(
					modifier = Modifier.padding(it)
				)
			}
		}
	}
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsPage(
	modifier: Modifier = Modifier
){
	val scope = rememberCoroutineScope()
	val scaffoldState = rememberBottomSheetScaffoldState()

	BottomSheetScaffold(
		scaffoldState = scaffoldState,
		sheetPeekHeight = 0.dp,
		sheetContent = {
			Box(
				Modifier
					.fillMaxWidth()
					.height(128.dp),
				contentAlignment = Alignment.Center
			) {
				Text("Swipe up to expand sheet")
			}
			Column(
				Modifier
					.fillMaxWidth()
					.padding(64.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text("Sheet content")
				Spacer(Modifier.height(20.dp))
				Button(
					onClick = {
						scope.launch { scaffoldState.bottomSheetState.partialExpand() }
					}
				) {
					Text("Click to collapse sheet")
				}
			}
		}) { innerPadding ->
		Box(modifier.padding(innerPadding)) {

			Button(onClick = {
				scope.launch {
					scaffoldState.bottomSheetState.expand()
				}
			}) {
				Text("Show Bottom Sheets")
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsPage2(
	modifier: Modifier = Modifier
){

	var openBottomSheet by rememberSaveable { mutableStateOf(false) }
	var skipPartiallyExpanded by remember { mutableStateOf(false) }
	var edgeToEdgeEnabled by remember { mutableStateOf(false) }
	val scope = rememberCoroutineScope()
	val bottomSheetState = rememberModalBottomSheetState(
		skipPartiallyExpanded = skipPartiallyExpanded
	)

// App content
	Column(
		modifier = modifier
			.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Row(
			Modifier.toggleable(
				value = skipPartiallyExpanded,
				role = Role.Checkbox,
				onValueChange = { checked -> skipPartiallyExpanded = checked }
			)
		) {
			Checkbox(checked = skipPartiallyExpanded, onCheckedChange = null)
			Spacer(Modifier.width(16.dp))
			Text("Skip partially expanded State")
		}
		Row(
			Modifier.toggleable(
				value = edgeToEdgeEnabled,
				role = Role.Checkbox,
				onValueChange = { checked -> edgeToEdgeEnabled = checked }
			)
		) {
			Checkbox(checked = edgeToEdgeEnabled, onCheckedChange = null)
			Spacer(Modifier.width(16.dp))
			Text("Toggle edge to edge enabled.")
		}
		Button(onClick = { openBottomSheet = !openBottomSheet }) {
			Text(text = "Show Bottom Sheet")
		}
	}


// Sheet content
	if (openBottomSheet) {
		val windowInsets = if (edgeToEdgeEnabled)
			WindowInsets(0) else BottomSheetDefaults.windowInsets

		ModalBottomSheet(
			onDismissRequest = { openBottomSheet = false },
			sheetState = bottomSheetState,
			windowInsets = windowInsets,
		) {
			Row(
				Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
				Button(
					// Note: If you provide logic outside of onDismissRequest to remove the sheet,
					// you must additionally handle intended state cleanup, if any.
					onClick = {
						scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
							if (!bottomSheetState.isVisible) {
								openBottomSheet = false
							}
						}
					}
				) {
					Text("Hide Bottom Sheet")
				}
			}
			var text by remember { mutableStateOf("") }
			OutlinedTextField(value = text, onValueChange = { text = it })
			LazyColumn {
				items(50) {
					ListItem(
						headlineContent = { Text("Item $it") },
						leadingContent = {
							Icon(
								Icons.Default.Favorite,
								contentDescription = "Localized description"
							)
						}
					)
				}
			}
		}
	}

}


@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetsPage(){
	BottomSheetsPage2()
}