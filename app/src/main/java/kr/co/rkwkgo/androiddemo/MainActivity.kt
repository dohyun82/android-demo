package kr.co.rkwkgo.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import kr.co.rkwkgo.androiddemo.architecture.components.data.DataStoreDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.LifecycleAwareDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.ViewBindingDemoActivity
import kr.co.rkwkgo.androiddemo.compose.ComposeDemo2Activity
import kr.co.rkwkgo.androiddemo.compose.ComposeDemoActivity
import kr.co.rkwkgo.androiddemo.compose.ComposeLazyColumnActivity
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
		binding.btnCompose2.setOnClickListener {
			goComposeDemo2Activity()
		}
		binding.btnLazyColumnCompose.setOnClickListener {
			goLazyColumnActivity()
		}
		binding.btnFlutter.setOnClickListener {
			goFlutterActivity()
		}
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

	private fun goComposeDemo2Activity(){
		val intent = Intent(this, ComposeDemo2Activity::class.java)
		startActivity(intent)
	}

	private fun goFlutterActivity(){
		startActivity(
			FlutterActivity.createDefaultIntent(this)
		)
	}

}