package kr.co.rkwkgo.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.rkwkgo.androiddemo.architecture.components.data.DataStoreDemoActivity
import kr.co.rkwkgo.androiddemo.architecture.components.ui.ViewBindingDemoActivity
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
	}

	private fun goViewBindingDemoActivity(){
		val intent = Intent(this, ViewBindingDemoActivity::class.java)
		startActivity(intent)
	}

	private fun goDataStoreDemoActivity(){
		val intent = Intent(this, DataStoreDemoActivity::class.java)
		startActivity(intent)
	}

}