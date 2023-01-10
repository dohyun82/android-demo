package kr.co.rkwkgo.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.rkwkgo.androiddemo.architecture.components.ui.layer.ViewBindingDemoActivity
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
	}

	private fun goViewBindingDemoActivity(){
		val intent = Intent(this, ViewBindingDemoActivity::class.java)
		startActivity(intent)
	}

}