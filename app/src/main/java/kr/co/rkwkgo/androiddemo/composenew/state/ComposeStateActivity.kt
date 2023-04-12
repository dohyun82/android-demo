package kr.co.rkwkgo.androiddemo.composenew.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.co.rkwkgo.androiddemo.composenew.state.ui.theme.AndroidDemoTheme

class ComposeStateActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					WellnessScreen()
				}
			}
		}
	}
}

@Composable
private fun WellnessScreen(
	modifier: Modifier = Modifier,
	wellnessViewModel: ComposeStateViewModel = viewModel()
){
	Column(modifier = modifier) {
		StatefulCounter()

		WellnessTasksList(
			list = wellnessViewModel.tasks,
			onCheckedTask = {task, checked ->
				wellnessViewModel.changeTaskChecked(task, checked)
			},
			onCloseTask = { task ->
				wellnessViewModel.remove(task)
			}
		)
	}
}

@Composable
private fun WellnessTasksList(
	list: List<WellnessTask>,
	onCheckedTask: (WellnessTask, Boolean) -> Unit,
	onCloseTask: (WellnessTask) -> Unit,
	modifier: Modifier = Modifier,
){
	LazyColumn(modifier = modifier){
		items(
			items = list,
			key = { task -> task.id }
		) { task ->
			WellnessTaskItem(
				taskName = task.label,
				checked = task.checked,
				onCheckedChange = { checked -> onCheckedTask(task, checked) },
				onClose = { onCloseTask(task) }
			)
		}
	}
}

@Composable
private fun WellnessTaskItem(
	taskName: String,
	checked: Boolean,
	onCheckedChange: (Boolean) -> Unit,
	onClose: () -> Unit,
	modifier: Modifier = Modifier
){
	Row (
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
		){
		Text(
			modifier = Modifier
				.weight(1f)
				.padding(start = 16.dp),
			text = taskName
		)
		Checkbox(
			checked = checked,
			onCheckedChange = onCheckedChange
		)
		IconButton(onClick = onClose) {
			Icon(Icons.Filled.Close, contentDescription = "Close")
		}
	}
}


@Composable
private fun StatefulCounter(modifier: Modifier = Modifier){
	var waterCount by rememberSaveable {
		mutableStateOf(0)
	}
	StatelessCounter(count = waterCount, onIncrement = { waterCount ++ }, modifier = modifier)
}

@Composable
private fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
	Column(modifier = modifier.padding(16.dp)) {
		if(count > 0){
			Text("You've had $count glasses.")
		}
		Button(
			onClick = onIncrement,
			enabled = count < 10,
			modifier = Modifier.padding(start = 8.dp)
		) {
			Text("Add one")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview(){
	AndroidDemoTheme {
		WellnessScreen()
	}
}