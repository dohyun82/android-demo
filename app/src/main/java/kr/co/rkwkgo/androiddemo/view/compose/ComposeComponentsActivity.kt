package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
		ProgressIndicatorsExample()
	}
}

@Composable
private fun ProgressIndicatorsExample(){
	LinearDeterminateIndicator()
	IndeterminateCircularIndicator()
}

@Composable
private fun IndeterminateCircularIndicator(){
	var loading by remember { mutableStateOf(false) }

	Button(
		onClick = {loading = true}, enabled = !loading
	){
		Text("Start loading")
	}
	if(!loading) return

	CircularProgressIndicator(
		modifier = Modifier.width(64.dp),
		color = MaterialTheme.colorScheme.secondary,
		trackColor = MaterialTheme.colorScheme.surfaceVariant
	)
}

@Composable
private fun LinearDeterminateIndicator(){
	var currentProgress by remember { mutableFloatStateOf(0f) }
	var loading by remember { mutableStateOf(false) }
	val scope = rememberCoroutineScope()
	Column(
		verticalArrangement = Arrangement.spacedBy(12.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier.fillMaxWidth()
	) {
		Button(
			onClick = {
				loading = true
				scope.launch {
					loadProgress {
						currentProgress = it
					}
					loading = false
				}
			},
			enabled = !loading
		){
			Text("Start loading")
		}
		if (loading){
			LinearProgressIndicator(
				progress = currentProgress,
				modifier = Modifier.fillMaxWidth()
			)
		}
	}
}

suspend fun loadProgress(updateProgress: (Float) -> Unit){
	for(i in 1..100){
		updateProgress(i.toFloat() / 100)
		delay(100)
	}
}

@Composable
private fun ChipExample(){
	Column {
		AssistChipExample()
		FilterChipExample()
		InputChipExample("Input chip"){

		}
		SuggestionChipExample()
	}
}

@Composable
private fun SuggestionChipExample(){
	SuggestionChip(onClick = {  }, label = { Text("Suggestion chip") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputChipExample(
	text: String,
	onDismiss: () -> Unit,
){
	var enabled by remember {
		mutableStateOf(true)
	}
	if(!enabled) return

	InputChip(
		selected = enabled,
		onClick = {
			onDismiss()
			enabled = !enabled
				  },
		label = { Text(text) },
		avatar = {
				 Icon(
					 Icons.Filled.Person,
					 contentDescription = null,
					 Modifier.size(InputChipDefaults.AvatarSize)
				 )
		},
		trailingIcon = {
			Icon(
				Icons.Default.Close,
				contentDescription = null,
				Modifier.size(
					InputChipDefaults.AvatarSize
				)
			)
		},
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FilterChipExample(){
	var selelected by remember {
		mutableStateOf(false)
	}
	FilterChip(
		selected = selelected,
		onClick = {
		  selelected = !selelected
				  },
		label = {
			Text("Filter chip")
		},
		leadingIcon = if(selelected){
			{
				Icon(
					imageVector = Icons.Filled.Done,
					contentDescription = null,
					modifier =  Modifier.size(FilterChipDefaults.IconSize)
				)
			}
		}else{
			null
		}
	)
}

@Composable
private fun AssistChipExample(){
	AssistChip(
		onClick = { },
		label = { Text("Assist chip") },
		leadingIcon = {
			Icon(
				Icons.Filled.Settings,
				contentDescription = null,
				Modifier.size(AssistChipDefaults.IconSize)
			)
		}
	)
}

@Composable
private fun OutlinedCardExample(){
	OutlinedCard(
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.surface
		),
		border = BorderStroke(1.dp, Color.Black),
		modifier = Modifier
			.size(
				width = 240.dp,
				height = 100.dp
			)
	) {
		Text(
			text = "Outlined",
			modifier = Modifier
				.padding(16.dp),
			textAlign = TextAlign.Center
		)
	}
}

@Composable
private fun ElevatedCardExample(){
	ElevatedCard(
		elevation = CardDefaults.cardElevation(
			defaultElevation = 6.dp
		),
		modifier = Modifier
			.size(
				width = 240.dp,
				height = 100.dp
			)
	) {
		Text(
			text = "Elevated",
			modifier = Modifier
				.padding(16.dp),
			textAlign = TextAlign.Center,
		)
	}
}

@Composable
private fun FilledCardExample(){
	Card(
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.surfaceVariant
		),
		modifier = Modifier
			.size(
				width = 240.dp,
				height = 100.dp
			)
	){
		Text(
			text = "Filled",
			modifier = Modifier
				.padding(16.dp),
			textAlign = TextAlign.Center
		)
	}
}

@Composable
private fun CardMinimalExample(){
	Card{
		Text("Hello, world!")
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