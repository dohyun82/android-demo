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
					when(it){
						ComposeFeature.Tutorial -> {
							startActivity(Intent(this@ComposeMainActivity, ComposeTutorialActivity::class.java))
						}
						ComposeFeature.Tutorial2 -> {
							startActivity(Intent(this@ComposeMainActivity, TutorialActivity::class.java))
						}
						ComposeFeature.BasicLayout -> {
							startActivity(Intent(this@ComposeMainActivity, BasicLayoutActivity::class.java))
						}
						ComposeFeature.BasicCodeLab -> {
							startActivity(Intent(this@ComposeMainActivity, BasicCodeLabActivity::class.java))
						}
						ComposeFeature.BottomSheets -> {
							startActivity(Intent(this@ComposeMainActivity, BottomSheetsActivity::class.java))
						}
						ComposeFeature.Lifecycle -> {
							startActivity(Intent(this@ComposeMainActivity, ComposeLifecycleActivity::class.java))
						}
					}
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeMainLayout(onClick : (type: ComposeFeature)-> Unit){
	Scaffold(
		topBar = {
			TopAppBar(title = {
				Text(text = "Compose Main")
			})
		},
	){
		Column(modifier = Modifier.padding(it)) {
			Button(onClick = {
				onClick(ComposeFeature.Tutorial)
			}) {
				Text(text = ComposeFeature.Tutorial.name)
			}
			Button(onClick = {
				onClick(ComposeFeature.Tutorial2)
			}) {
				Text(text = ComposeFeature.Tutorial2.name)
			}
			Button(onClick = {
				onClick(ComposeFeature.BasicLayout)
			}) {
				Text(text = ComposeFeature.BasicLayout.name)
			}
			Button(onClick = {
				onClick(ComposeFeature.BasicCodeLab)
			}) {
				Text(text = ComposeFeature.BasicCodeLab.name)
			}
			Button(onClick = {
				onClick(ComposeFeature.BottomSheets)
			}) {
				Text(text = ComposeFeature.BottomSheets.name)
			}
			Button(onClick = {
				onClick(ComposeFeature.Lifecycle)
			}) {
				Text(text = ComposeFeature.Lifecycle.name)
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
enum class ComposeFeature{
	Tutorial,
	Tutorial2,
	BasicLayout,
	BasicCodeLab,
	BottomSheets,
	Lifecycle,
}