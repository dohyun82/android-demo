package kr.co.rkwkgo.androiddemo.architecture.components.ui.layer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.co.rkwkgo.androiddemo.databinding.ActivityViewBindingDemoBinding

/**
 * View Binding
 * https://developer.android.com/topic/libraries/view-binding
 * 뷰와 상호작용을 쉽게 하기 위함
 * 모듈단위로 뷰 바인딩 활성화 하면 모듈에 존재하는 XML 레이아웃 파일로 바인딩 클래스 생성
 * 각 뷰가 가지고 있는 ID 로 참조 (findViewById 대체)
 * Null safety, Type safety
 * Faster compilation, Ease of use
 */
class ViewBindingDemoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityViewBindingDemoBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		// 1. binding 클래스의 inflate 메서드 호출
		binding = ActivityViewBindingDemoBinding.inflate(layoutInflater)
		// 2. 화면에 뷰를 만들기 위해 setContentView 에 바인딩 클래스의 root view 를 셋팅
		setContentView(binding.root)
	}
}