package kr.co.rkwkgo.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import kr.co.rkwkgo.androiddemo.architecture.components.data.DataStoreDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.LifecycleAwareDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.ViewBindingDemoActivity
import kr.co.rkwkgo.androiddemo.compose.ComposeDemoActivity
import kr.co.rkwkgo.androiddemo.compose.ComposeLazyColumnActivity
import kr.co.rkwkgo.androiddemo.composenew.ComposeNewActivity
import kr.co.rkwkgo.androiddemo.composenew.material3.ComposeMaterial3Activity
import kr.co.rkwkgo.androiddemo.composenew.state.ComposeStateActivity
import kr.co.rkwkgo.androiddemo.databinding.ActivityMainBinding

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
		binding.btnCompose.setOnClickListener {
			goComposeDemoActivity()
		}
		binding.btnLazyColumnCompose.setOnClickListener {
			goLazyColumnActivity()
		}
		binding.btnFlutter.setOnClickListener {
			goFlutterActivity()
		}
		binding.btnFlutterSettings.setOnClickListener {
			goFlutterSettingsActivity()
		}
		binding.btnComposeNew.setOnClickListener {
			goComposeNewActivity()
		}
		binding.btnComposeMaterial3.setOnClickListener {
			goComposeMaterial3Activity()
		}
		binding.btnComposeState.setOnClickListener {
			goComposeStateActivity()
		}
	}

	private fun goComposeStateActivity() {
		val intent = Intent(this, ComposeStateActivity::class.java)
		startActivity(intent)
	}

	private fun goComposeMaterial3Activity() {
		val intent = Intent(this, ComposeMaterial3Activity::class.java)
		startActivity(intent)
	}

	private fun goComposeNewActivity() {
		val intent = Intent(this, ComposeNewActivity::class.java)
		startActivity(intent)
	}

	private fun goLazyColumnActivity() {
		val intent = Intent(this, ComposeLazyColumnActivity::class.java)
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

	private fun goComposeDemoActivity(){
		val intent = Intent(this, ComposeDemoActivity::class.java)
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