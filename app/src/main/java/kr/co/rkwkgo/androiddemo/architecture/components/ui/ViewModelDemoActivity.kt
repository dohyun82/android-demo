package kr.co.rkwkgo.androiddemo.architecture.components.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.co.rkwkgo.androiddemo.databinding.ActivityViewModelDemoBinding
import kotlin.random.Random

/**
 * ViewModel
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 * business logic or screen level state holder
 */
class ViewModelDemoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityViewModelDemoBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityViewModelDemoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val viewModel: DiceRollViewModel by viewModels()
		lifecycleScope.launch{
			repeatOnLifecycle(Lifecycle.State.STARTED){
				viewModel.uiState.collect{
					// Update UI elements
				}
			}
		}

	}
}

data class DiceUiState(
	val firstDieValue: Int? = null,
	val secondDieValue: Int? = null,
	val numberOfRolls: Int = 0,
)

class DiceRollViewModel: ViewModel(){

	// Expose screen UI state
	private val _uiState = MutableStateFlow(DiceUiState())
	val uiState: StateFlow<DiceUiState> = _uiState.asStateFlow()

	// Handle business logic
	fun rollDice(){
		_uiState.update {
			it.copy(
				firstDieValue = Random.nextInt(from = 1, until = 7),
				secondDieValue = Random.nextInt(from = 1, until = 7),
				numberOfRolls = it.numberOfRolls + 1,
			)
		}
	}

}