package kr.co.rkwkgo.androiddemo.architecture.components.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.rkwkgo.androiddemo.databinding.ActivityLifecycleAwareDemoBinding

/**
 * Lifecycle-Aware Components
 * https://developer.android.com/topic/libraries/architecture/lifecycle
 * Activity, Fragments components 의 lifecycle 상태 변경에 반응해서 액션을 수행한다.
 * better-organized, lighter-weight code, easier to maintain
 */
class LifecycleAwareDemoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLifecycleAwareDemoBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLifecycleAwareDemoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		binding.btnViewModel.setOnClickListener {
			goViewModelDemoActivity()
		}
		binding.btnLiveData.setOnClickListener {
			getLiveDataDemoActivity()
		}
	}

	private fun getLiveDataDemoActivity() {
		val intent = Intent(this, LiveDataDemoActivity::class.java)
		startActivity(intent)
	}

	private fun goViewModelDemoActivity(){
		val intent = Intent(this, ViewModelDemoActivity::class.java)
		startActivity(intent)
	}
}