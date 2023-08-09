package kr.co.rkwkgo.androiddemo.view.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

/**
 * Jetpack Compose
 *
 */
class ComposeMainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				ComposeMainLayout {
					startActivity(Intent(this@ComposeMainActivity, ComposeTutorialActivity::class.java))
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeMainLayout(onClick : ()-> Unit){
//	modifier: Modifier = Modifier,
//	topBar: @Composable () -> Unit = {},
//	bottomBar: @Composable () -> Unit = {},
//	snackbarHost: @Composable () -> Unit = {},
//	floatingActionButton: @Composable () -> Unit = {},
//	floatingActionButtonPosition: FabPosition = FabPosition.End,
//	containerColor: Color = MaterialTheme.colorScheme.background,
//	contentColor: Color = contentColorFor(containerColor),
//	contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
//	content: @Composable (PaddingValues) -> Unit
	Scaffold(
		topBar = {
			TopAppBar(title = {
				Text(text = "Compose Main")
			})
		},
	){
		Column(modifier = Modifier.padding(it)) {
			Button(onClick = onClick) {
				Text(text = "Compose Tutorial")
			}
		}
	}
}

@Preview
@Composable
fun PreviewComposeMainLayout(){
	ComposeMainLayout {

	}
}