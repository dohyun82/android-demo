package kr.co.rkwkgo.androiddemo.kotlin

fun main() {
	// 변수 선언
	// val 변경되지 않는 변수, 재할당 불가
	val name: String = "도현"
//	name = "테스트" ,에러 - 변경 불가
	// var : 변경 가능한 변수
	var count: Int = 10
	count = 15

	// 유형 추론
	// 할당 값을 기반으로 유형 추론, 컴파일 시간에 유형 결정되고 변하지 않음
	val languageName = "kotlin"
	val upperCaseName = languageName.uppercase() // String 으로 추론
//	upperCaseName.inc() ,에러 - String 유형에서 지원하지 않는 함수 호출

	// Null 안전
//	val notNullValue: String = null ,에러 - 기본적으로 null 불가
	val nullableValue: String? = null // 널 허용, NPE 고려

	// 조건부
	if(count >10){
		//
	}else if(count>15){
		//
	}else{
		//
	}
	// 조건식, 3항 연산자 불가
	val answerString = if(count>10){
		"test"
	}else if(count>15){
		"test2"
	}else{
		"test3"
	}
	// when 표현식
	val whenDemo = when {
		count>10 -> "test1"
		count>15 -> "test2"
		else -> "test3"
	}
	// 스마트 변환
	// 조건부 조건을 통과하면 유형 검사, null 검사 불필요

	// 함수
	// 하나 이상의 표현식을 함수로 그룹화
	fun generateAnswerString(): String{
		return if (count == 42){
			"테스트1"
		}else{
			"테스트2"
		}
	}
	val answerString2 = generateAnswerString()

	// 함수 선언 단순화
	// 익명 함수
	val stringLengthFunc: (String) -> Int = {
		it.length
	}
	val stringLength = stringLengthFunc("Android")

	// 고차 함수
	// 다른 함수를 인수로 취하는 함수
	// 자바의 콜백 인터페이스
	fun stringMapper(str: String, mapper: (String) -> Int): Int{
		return mapper(str)
	}
	stringMapper("Android") {
		it.length
	}

	// 클래스
	class DoorLock
	class Wheel
	// 속성
	class Car(val wheels: List<Wheel>){
		private val doorLock: DoorLock = DoorLock()
		var testVar: Int = 15
			private set
	}
	val car = Car(listOf())
//	car.testVar = 10
	val test = car.testVar
	val wheels = car.wheels

}