package kr.co.rkwkgo.androiddemo.kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.collection.arraySetOf
import androidx.core.content.edit
import kr.co.rkwkgo.androiddemo.R

/**
 * Kotlin Coroutine
 * https://developer.android.com/kotlin/coroutines
 * 동시 실행 설계 패턴
 */
class CoroutineDemoActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_coroutine_demo)
	}

	fun combine(){
		val combinedArraySet = arraySetOf(1,2,3) + arraySetOf(4,5,6)
		val newArraySet = combinedArraySet + 7 + 8
	}

	fun saveData(){
		val sharedPref = getSharedPreferences("prefKey", Context.MODE_PRIVATE)
		sharedPref.edit().putBoolean("key", true).apply()

		sharedPref.edit { putBoolean("key", true) }
		sharedPref.edit(commit = true){
			putBoolean("key", true)
		}
	}

}