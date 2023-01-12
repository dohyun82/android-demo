package kr.co.rkwkgo.androiddemo.architecture.components.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.databinding.ActivityLiveDataDemoBinding

/**
 * LiveData
 * https://developer.android.com/topic/libraries/architecture/livedata
 */
class LiveDataDemoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLiveDataDemoBinding

	private val viewModel: LiveDataViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLiveDataDemoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		viewModel.liveData.observe(this){
			binding.tvTest.text = it
		}
		binding.btnAdd.setOnClickListener {
			viewModel.addData()
		}
	}
}

class LiveDataViewModel : ViewModel(){

	private var count = 0

	private val _liveData = MutableLiveData<String>()
	val liveData: LiveData<String> = _liveData

	fun addData() = viewModelScope.launch {
		_liveData.value = "${++count}"
	}
}