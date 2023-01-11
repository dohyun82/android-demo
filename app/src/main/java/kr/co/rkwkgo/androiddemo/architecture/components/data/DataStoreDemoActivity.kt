package kr.co.rkwkgo.androiddemo.architecture.components.data

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.protobuf.InvalidProtocolBufferException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kr.co.rkwkgo.androiddemo.Settings
import kr.co.rkwkgo.androiddemo.databinding.ActivityDataStoreDemoBinding
import java.io.InputStream
import java.io.OutputStream

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

object SettingsSerializer : Serializer<Settings> {
	override val defaultValue: Settings = Settings.getDefaultInstance()
	override suspend fun readFrom(input: InputStream): Settings {
		try {
			return Settings.parseFrom(input)
		}catch (exception: InvalidProtocolBufferException){
			throw CorruptionException("Cannot read proto.", exception)
		}
	}

	override suspend fun writeTo(t: Settings, output: OutputStream) = t.writeTo(output)
}

val Context.settingsDataStore: DataStore<Settings> by dataStore(
	fileName = "settings.pb",
	serializer = SettingsSerializer
)

class DataStoreDemoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDataStoreDemoBinding

	val EXAMPLE_COUNTER = intPreferencesKey("example_counter")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDataStoreDemoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		preferenceDataStore()
		protoDataStore()
	}

	private fun preferenceDataStore(){
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

	private fun protoDataStore(){
		val exampleCounterFlow: Flow<Int> = settingsDataStore.data.map {
			it.exampleCounter
		}
		CoroutineScope(Dispatchers.Main).launch {
			exampleCounterFlow.collect{
				binding.tvProtoCounter.text = "$it"
			}
		}
		binding.btnAddProtoCounter.setOnClickListener {
			CoroutineScope(Dispatchers.IO).launch {
				incrementProtoCounter()
			}
		}
		binding.btnSubtractProtoCounter.setOnClickListener {
			CoroutineScope(Dispatchers.IO).launch {
				decreaseProtoCounter()
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

	private suspend fun incrementProtoCounter(){
		settingsDataStore.updateData {
			it.toBuilder().setExampleCounter(it.exampleCounter + 1).build()
		}
	}

	private suspend fun decreaseProtoCounter(){
		settingsDataStore.updateData {
			it.toBuilder().setExampleCounter(it.exampleCounter - 1).build()
		}
	}

}