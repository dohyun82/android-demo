package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

/**
 * Compose 컴포넌트
 */
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
			ComponentsPage()
		}
	}
}

@Preview
@Composable
private fun PreviewComponentsPage(){
	ComponentsPage()
}

@Composable
private fun ComponentsPage(){
	Scaffold(
		floatingActionButton = {
			ExtendedFABExample {

			}
		}
	){
		ComponentsBody(
			modifier = Modifier.padding(it)
		)
	}
}

@Composable
private fun ComponentsBody(
	modifier: Modifier = Modifier
){
	Column(
		modifier = modifier
	) {
		ButtonExample()
	}
}

@Composable
private fun ExtendedFABExample(
	onClick: () -> Unit
){
	ExtendedFloatingActionButton(
		onClick = onClick,
	){
		Row(
			verticalAlignment = Alignment.CenterVertically
		){
			Icon(Icons.Filled.Edit, "")
			Spacer(modifier = Modifier.width(16.dp))
			Text("Extended FAB")
		}
	}
}

@Composable
private fun LargeFABExample(
	onClick: () -> Unit
){
	LargeFloatingActionButton(
		onClick = onClick,
		shape = CircleShape
	) {
		Icon(Icons.Filled.Add, "Large FAB")
	}
}

@Composable
private fun SmallFABExample(
	onClick: () -> Unit
){
	SmallFloatingActionButton(
		onClick = onClick,
		containerColor = MaterialTheme.colorScheme.secondaryContainer,
		contentColor = MaterialTheme.colorScheme.secondary
	) {
		Icon(
			Icons.Filled.Add,
			"Small FAB"
		)
	}
}

@Composable
private fun FABExample(
	onClick: () -> Unit
){
	FloatingActionButton(onClick = onClick) {
		Icon(Icons.Filled.Add, "FAB")
	}
}

@Composable
private fun ButtonExample(){
	Column{
		FilledButtonExample{

		}
		FilledTonalButtonExample{

		}
		OutlinedButtonExample{

		}
		ElevatedButtonExample{

		}
		TextButtonExample{

		}
	}
}

@Composable
private fun FilledButtonExample(
	onClick: () -> Unit
){
	Button(onClick = onClick) {
		Text("Filled")
	}
}

@Composable
private fun FilledTonalButtonExample(
	onClick: () -> Unit
){
	FilledTonalButton(onClick = onClick) {
		Text("Tonal")
	}
}

@Composable
private fun OutlinedButtonExample(
	onClick: () -> Unit
){
	OutlinedButton(onClick = onClick) {
		Text("Outlined")
	}
}

@Composable
private fun ElevatedButtonExample(
	onClick: () -> Unit
){
	ElevatedButton(
		onClick = onClick
	) {
		Text("Elevated")
	}
}

@Composable
private fun TextButtonExample(
	onClick: () -> Unit
){
	TextButton(
		onClick = onClick
	){
		Text("Text Button")
	}
}