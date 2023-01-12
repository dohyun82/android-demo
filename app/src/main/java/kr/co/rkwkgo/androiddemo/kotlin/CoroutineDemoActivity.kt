package kr.co.rkwkgo.androiddemo.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}