package kr.co.rkwkgo.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import kr.co.rkwkgo.androiddemo.architecture.components.data.DataStoreDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.LifecycleAwareDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.ViewBindingDemoActivity
import kr.co.rkwkgo.androiddemo.biometric.BiometricActivity
import kr.co.rkwkgo.androiddemo.databinding.ActivityMainBinding
import kr.co.rkwkgo.androiddemo.view.compose.ComposeMainActivity

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		binding.btnViewBinding.setOnClickListener {
			goViewBindingDemoActivity()
		}
		binding.btnDataStore.setOnClickListener {
			goDataStoreDemoActivity()
		}
		binding.btnLifecycleAware.setOnClickListener {
			goLifecycleAwareDemoActivity()
		}
		binding.btnFlutter.setOnClickListener {
			goFlutterActivity()
		}
		binding.btnFlutterSettings.setOnClickListener {
			goFlutterSettingsActivity()
		}
		binding.btnBioMetric.setOnClickListener {
			goBioMetricActivity()
		}

		binding.btnComposeMain.setOnClickListener {
			goComposeMainActivity()
		}
	}

	private fun goBioMetricActivity(){
		val intent = Intent(this, BiometricActivity::class.java)
		startActivity(intent)
	}

	private fun goViewBindingDemoActivity(){
		val intent = Intent(this, ViewBindingDemoActivity::class.java)
		startActivity(intent)
	}

	private fun goDataStoreDemoActivity(){
		val intent = Intent(this, DataStoreDemoActivity::class.java)
		startActivity(intent)
	}

	private fun goLifecycleAwareDemoActivity(){
		val intent = Intent(this, LifecycleAwareDemoActivity::class.java)
		startActivity(intent)
	}

	private fun goFlutterActivity(){
		startActivity(
			FlutterActivity.createDefaultIntent(this)
		)
	}

	private fun goFlutterSettingsActivity(){
		startActivityForResult(
			FlutterActivity
				.withNewEngine()
				.initialRoute("/settings")
				.build(this), 1000
		)
	}


	/**
	 * Compose 메인 이동
	 */
	private fun goComposeMainActivity(){
		startActivity(Intent(this, ComposeMainActivity::class.java))
	}


	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if(requestCode == 1000){
			if(resultCode == RESULT_OK){
				val msg = data?.getStringExtra("msg")
				Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
			}
		}
	}

}