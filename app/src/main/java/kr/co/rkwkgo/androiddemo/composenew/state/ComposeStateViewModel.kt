package kr.co.rkwkgo.androiddemo.composenew.state

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class ComposeStateViewModel : ViewModel() {
	private val _tasks = getWellnessTasks().toMutableStateList()
	val tasks: List<WellnessTask>
		get() = _tasks

	fun remove(item: WellnessTask){
		_tasks.remove(item)
	}

	fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
		tasks.find {
			it.id == item.id
		}?.let { task ->
			task.checked = checked
		}
}

class WellnessTask(
	val id: Int,
	val label: String,
	initialChecked: Boolean = false
){
	var checked by mutableStateOf(initialChecked)
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
