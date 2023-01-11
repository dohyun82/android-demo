package kr.co.rkwkgo.androiddemo.architecture.components.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kr.co.rkwkgo.androiddemo.databinding.ActivityDataStoreDemoBinding

/**
 * DataStore
 * https://developer.android.com/topic/libraries/architecture/datastore
 * 데이터 저장 솔루션 : key-value pairs(Preferences DataStore), typed objects(Proto DataStore)
 * with Kotlin coroutines and Flow
 * SharedPreferences -> DataStore
 *
 */

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreDemoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDataStoreDemoBinding

	val EXAMPLE_COUNTER = intPreferencesKey("example_counter")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDataStoreDemoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		val exampleCounterFlow: Flow<Int> = dataStore.data.map {
			it[EXAMPLE_COUNTER] ?: 0
		}
		CoroutineScope(Dispatchers.Main).launch {
			exampleCounterFlow.collect{
				binding.tvCounter.text = "$it"
			}
		}
		binding.btnAddCounter.setOnClickListener {
			CoroutineScope(Dispatchers.IO).launch {
				incrementCounter()
			}
		}
		binding.btnSubtractCounter.setOnClickListener {
			CoroutineScope(Dispatchers.IO).launch {
				decreaseCounter()
			}
		}
	}

	private suspend fun incrementCounter(){
		dataStore.edit {
			val currentCounterValue = it[EXAMPLE_COUNTER] ?: 0
			it[EXAMPLE_COUNTER] = currentCounterValue + 1
		}
	}

	private suspend fun decreaseCounter(){
		dataStore.edit {
			val currentCounterValue = it[EXAMPLE_COUNTER] ?: 0
			it[EXAMPLE_COUNTER] = currentCounterValue - 1
		}
	}

}