package kr.co.rkwkgo.androiddemo

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.math.*

/**
 * https://school.programmers.co.kr
 * Level 0
 */
class CodingTestLevel0{

	/**
	 * 이어 붙인 수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181928
	 */
	@Test
	private fun concatenatedNumber(){
		val num_list = intArrayOf(3, 4, 5, 2, 1)
		val result = concatenatedNumber(num_list)
		Assert.assertEquals(393, result)
	}

	private fun concatenatedNumber(num_list: IntArray): Int {
		var odd = ""
		var even = ""
		num_list.forEach {
			if(it%2==0){
				even = "$even$it"
			}else{
				odd = "$odd$it"
			}
		}
		return odd.toInt() + even.toInt()
	}

	/**
	 * 원소들의 곱과 합
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181929
	 */
	@Test
	fun multiplicationSumOfElements(){
		val num_list = intArrayOf(5, 7, 8, 3)
		val result = multiplicationSumOfElements(num_list)
		Assert.assertEquals(0, result)
	}

	private fun multiplicationSumOfElements(num_list: IntArray): Int {
		var multiplication = 1
		num_list.forEach {
			multiplication *= it
		}
		var sum = num_list.sum()
		sum *= sum
		return if(multiplication<sum){
			1
		}else{
			0
		}
	}

	/**
	 * 특정한 문자를 대문자로 바꾸기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181873
	 */
	@Test
	fun changeSpecificLettersToUppercase(){
		val my_string = "programmers"
		val alp = "p"
		val result = changeSpecificLettersToUppercase(my_string, alp)
		Assert.assertEquals("Programmers", result)
	}

	fun changeSpecificLettersToUppercase(my_string: String, alp: String): String {
		return my_string.map {
			if(it.toString() == alp){
				 it.uppercase()
			}else{
				it
			}
		}.joinToString("")
	}

	/**
	 * 주사위 게임 2
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181930
	 */
	@Test
	fun diceGame2(){
		val a = 2
		val b = 6
		val c = 1
		val result = diceGame2(a, b, c)
		Assert.assertEquals(9, result)
	}

	private fun diceGame2(a: Int, b: Int, c: Int): Int {
		// 1. 세 숫자 비교
		// 2. 모두 다르면 a + b + c
		// 3. 두 숫자만 같으면 (a + b + c) * (a*a + b*b + c*c)
		// 4. 세 숫자가 같으면 (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c)
		return if(a==b && b==c){
			(a + b + c) * (a.toDouble().pow(2) + b.toDouble().pow(2) + c.toDouble().pow(2)).toInt() * (a.toDouble().pow(3) + b.toDouble().pow(3) + c.toDouble().pow(3)).toInt()
		}else{
			if(a==b || b==c || a==c){
				(a + b + c) * (a.toDouble().pow(2) + b.toDouble().pow(2) + c.toDouble().pow(2)).toInt()
			}else{
				(a + b + c)
			}
		}
	}

	/**
	 * 소문자로 바꾸기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181876
	 */
	@Test
	fun lowercase(){
		val myString = "aBcDeFg"
		val result = lowercase(myString)
		Assert.assertEquals("abcdefg", result)
	}

	fun lowercase(myString: String): String {
		return myString.lowercase()
	}

	/**
	 * 정수를 나선형으로 배치하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181832
	 */
	@Test
	fun arrangeIntegersInSpiral(){
		val n = 4
		val result = arrangeIntegersInSpiral(n)
		Assert.assertArrayEquals(
			arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(12, 13, 14, 5), intArrayOf(11, 16, 15, 6), intArrayOf(10, 9, 8, 7)), result
		)
	}

	private fun arrangeIntegersInSpiral(n: Int): Array<IntArray> {
		val resultArray = Array(n){ IntArray(n) }
		val direction = 1
		(1 ..  (n*n)).forEach {

		}
		return resultArray
	}


	/**
	 * 무작위로 k개의 수 뽑기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181858
	 */
	@Test
	fun randomDrawKNumber(){
		val arr = intArrayOf(0, 1, 1, 2, 2, 3)
		val k = 3
		val result = randomDrawKNumber(arr, k)
		Assert.assertArrayEquals(intArrayOf(0,1,2), result)
	}

	private fun randomDrawKNumber(arr: IntArray, k: Int): IntArray {
		val list = mutableListOf<Int>()
		for(value in arr){
			if(!list.contains(value)){
				list.add(value)
			}
			if(list.size>=k){
				break
			}
		}
		val listSize = list.size
		if(listSize<k){
			val array = Array(k-listSize){-1}
			list.addAll(array)
		}
		return list.toIntArray()
	}

	/**
	 * 문자열로 변환
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181845
	 */
	@Test
	fun convertString(){
		val n = 123
		val result = convertString(n)
		Assert.assertEquals("123", result)
	}

	private fun convertString(n: Int): String {
		return n.toString()
	}


	/**
	 * n 번째 원소까지
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181889
	 */
	@Test
	fun untilNthElement(){
		val num_list = intArrayOf(2, 1, 6)
		val n = 1
		val result = untilNthElement(num_list, n)
		Assert.assertArrayEquals(intArrayOf(2), result)
	}

	private fun untilNthElement(num_list: IntArray, n: Int): IntArray {
		return num_list.sliceArray(0 until n)
	}

	/**
	 * 길이에 따른 연산
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181879
	 */
	@Test
	fun operationsBasedOnLength(){
		val num_list = intArrayOf(3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1)
		val result = operationsBasedOnLength(num_list)
		Assert.assertEquals(51, result)
	}

	private fun operationsBasedOnLength(num_list: IntArray): Int {
		var result = 1
		if(num_list.size>10){
			result = num_list.sum()
		}else{
			result = num_list.fold(1){ a,b ->
				a*b
			}
		}
		return result
	}

	/**
	 * n 번째 원소부터
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181892
	 */
	@Test
	fun fromNthElements(){
		val num_list = intArrayOf(2, 1, 6)
		val n = 3
		val result = fromNthElements(num_list, n)
		Assert.assertArrayEquals(intArrayOf(6), result)
	}

	private fun fromNthElements(num_list: IntArray, n: Int): IntArray {
		return num_list.sliceArray(n-1 until num_list.size)
	}

	/**
	 * 글자 이어 붙여 문자열 만들기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181915
	 */
	@Test
	fun createStringByConcatenatingLetters(){
		val my_string = "cvsgiorszzzmrpaqpe"
		val index_list = intArrayOf(16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7)
		val result = createStringByConcatenatingLetters(my_string, index_list)
		Assert.assertEquals("programmers", result)
	}

	private fun createStringByConcatenatingLetters(my_string: String, index_list: IntArray): String {
		return index_list.map {
			my_string[it]
		}.joinToString("")
	}

	/**
	 * 첫 번째로 나오는 음수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181896
	 */
	@Test
	fun firstNegativeNumber(){
		val num_list = intArrayOf(12, 4, 15, 46, 38, -2, 15)
		val result = firstNegativeNumber(num_list)
		Assert.assertEquals(5, result)
	}

	private fun firstNegativeNumber(num_list: IntArray): Int {
		return num_list.indexOfFirst {
			it<0
		}
	}

	/**
	 * 문자열 뒤의 n 글자
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181910
	 */
	@Test
	fun lettersAfterString(){
		val my_string = "ProgrammerS123"
		val n = 11
		val result = lettersAfterString(my_string, n)
		Assert.assertEquals("grammerS123", result)
	}

	private fun lettersAfterString(my_string: String, n: Int): String {
		return my_string.takeLast(n)
	}

	/**
	 * 조건에 맞게 수열 변환하기 3
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181835
	 */
	@Test
	fun convertingSequenceAccordingToConditions(){
		val arr = intArrayOf(1, 2, 3, 100, 99, 98)
		val k = 3
		val result = convertingSequenceAccordingToConditions(arr, k)
		Assert.assertArrayEquals(intArrayOf(3, 6, 9, 300, 297, 294), result)
	}

	private fun convertingSequenceAccordingToConditions(arr: IntArray, k: Int): IntArray {
		return arr.map {
			if(k%2==0){
				it + k
			}else{
				it * k
			}
		}.toIntArray()
	}

	/**
	 * 전국 대회 선발 고사
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181851
	 */
	@Test
	fun nationalCompetitionSelectionTest(){
		val rank = intArrayOf(3, 7, 2, 5, 4, 6, 1)
		val attendance = booleanArrayOf(false, true, true, true, true, false, false)
		val result = nationalCompetitionSelectionTest(rank, attendance)
		Assert.assertEquals(20403, result)
	}

	private fun nationalCompetitionSelectionTest(rank: IntArray, attendance: BooleanArray): Int {
		// 1. rank.size 만큰 반복
		// 2. rank[idx] == idx+1 && attendance[idx] == true 라면 list 에 add
		val list = mutableListOf<Int>()
		run temp2@{
			rank.forEachIndexed { idx, i ->
				run temp@{
					rank.forEachIndexed { idx2, it ->
						if(it == idx+1){
							if(attendance[idx2]){
								list.add(idx2)
								if(list.size>2){
									return@temp2
								}else{
									return@temp
								}
							}
						}
					}
				}
			}
		}
		return list[0] * 10000 + list[1] * 100 + list[2]
	}

	/**
	 * 배열 만들기 2
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181921
	 */
	@Test
	fun makeArray2(){
		val l = 5
		val r = 555
		val result = makeArray2(l, r)
		Assert.assertArrayEquals(intArrayOf(5,50,55,500,505,550,555), result)
	}

	private fun makeArray2(l: Int, r: Int): IntArray {
		var result = (l .. r).filter {
			"$it".replace("0","").replace("5","").isEmpty()
		}.toIntArray()
		if(result.isEmpty()){
			result = intArrayOf(-1)
		}
		return result
	}

	/**
	 * 배열 조각하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181893
	 */
	@Test
	fun sculptingArray(){
		val arr = intArrayOf(0, 1, 2, 3, 4, 5)
		val query = intArrayOf(4, 1, 2)
		val result = sculptingArray(arr, query)
		Assert.assertArrayEquals(intArrayOf(1,2,3), result)
	}

	private fun sculptingArray(arr: IntArray, query: IntArray): IntArray {
		var list = arr.toMutableList()
		query.forEachIndexed { index, i ->
			list = if(index%2==0){
				list.take(i + 1).toMutableList()
			}else{
				list.takeLast(list.size - i).toMutableList()
			}
	}
		return list.toIntArray()
	}

	/**
	 * 정수 부분
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181850
	 */
	@Test
	fun integerPart(){
		val flo = 1.42
		val result = integerPart(flo)
		Assert.assertEquals(1, result)
	}

	private fun integerPart(flo: Double): Int {
		return flo.toInt()
	}

	@Test
	fun sequenceIntervalQueries2(){
		val arr = intArrayOf(0, 1, 2, 4, 3)
		val queries = arrayOf(intArrayOf(0, 4, 2), intArrayOf(0, 3, 2), intArrayOf(0, 2, 2))
		val result = sequenceIntervalQueries2(arr, queries)
		Assert.assertArrayEquals(intArrayOf(3, 4, -1), result)
	}

	private fun sequenceIntervalQueries2(arr: IntArray, queries: Array<IntArray>): IntArray {
		val list = mutableListOf<Int>()
		queries.forEach {
			var temp = (it[0]..it[1]).map { it2 ->
				arr[it2]
			}.sorted().firstOrNull {it3 ->
				it3>it[2]
			}
			if(temp == null){
				temp = -1
			}
			list.add(temp)
		}
		return list.toIntArray()
	}


	/**
	 * 마지막 두 원소
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181927
	 */
	@Test
	fun lastTwoElements(){
		val num_list = intArrayOf(2, 1, 6)
		val result = lastTwoElements(num_list)
		Assert.assertArrayEquals(intArrayOf(2, 1, 6, 5), result)
	}

	private fun lastTwoElements(num_list: IntArray): IntArray {
		val tempList = num_list.toMutableList()
		val one = num_list[num_list.size-1]
		val two = num_list[num_list.size-2]
		if(one>two){
			tempList.add(one - two)
		}else{
			tempList.add(one * 2)
		}
		return tempList.toIntArray()
	}

	/**
	 * 정수 찾기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181840
	 */
	@Test
	fun findInteger(){
		val num_list = intArrayOf(1, 2, 3, 4, 5)
		val n = 3
		val result = findInteger(num_list, n)
		Assert.assertEquals(1, result)
	}

	private fun findInteger(num_list: IntArray, n: Int): Int {
		val num = num_list.find {
			it == n
		}
		return if(num == null) 0 else 1
	}

	/**
	 * 카운트 업
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181920
	 */
	@Test
	fun countUp(){
		val start_num = 3
		val end_num = 10
		val result = countUp(start_num, end_num)
		Assert.assertArrayEquals(intArrayOf(3, 4, 5, 6, 7, 8, 9, 10), result)
	}

	private fun countUp(start_num: Int, end_num: Int): IntArray {
		val list = mutableListOf<Int>()
		(start_num .. end_num).forEach {
			list.add(it)
		}
		return list.toIntArray()
	}

	/**
	 * 문자열을 정수로 변환하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181848
	 */
	@Test
	fun convertStringToInteger(){
		val n_str = "10"
		val result = convertStringToInteger(n_str)
		Assert.assertEquals(10, result)
	}

	private fun convertStringToInteger(n_str: String): Int {
		return n_str.toInt()
	}

	/**
	 * 등차수열의 특정한 항만 더하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181931
	 */
	@Test
	fun TestAddingSpecificTermsArithmeticSequence(){
		val a = 7
		val d = 1
		val included = booleanArrayOf(false, false, false, true, false, false, false)
		val result = addingSpecificTermsArithmeticSequence(a, d, included)
		Assert.assertEquals(10, result)
	}

	private fun addingSpecificTermsArithmeticSequence(a: Int, d: Int, included: BooleanArray): Int {
		return included.indices.filter {
			included[it]
		}.sumOf {
			a + d * it
		}
	}

	/**
	 * 코드 처리하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181932
	 */
	@Test
	fun TestHandlingCode(){
		val code = "abc1abc1abc"
		val result = handlingCode(code)
		Assert.assertEquals("acbac", result)
	}

	private fun handlingCode(code: String): String {
		val sb = StringBuffer()
		var mode = false
		code.forEachIndexed { index, c ->
			if(mode){
				if(c!='1'){
					if(index%2!=0){
						sb.append(c)
					}
				}else{
					mode = !mode
				}
			}else{
				if(c!='1'){
					if(index%2==0){
						sb.append(c)
					}
				}else{
					mode = !mode
				}
			}
		}
		var ret = sb.toString()
		if(ret == ""){
			ret = "EMPTY"
		}
		return ret
	}

	/**
	 * flag에 따라 다른 값 반환하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181933
	 */
	@Test
	fun TestFlagResultValue(){
		val a = -4
		val b = 7
		val flag = true
		val result = flagResultValue(a, b, flag)
		Assert.assertEquals( 3, result)
	}

	private fun flagResultValue(a: Int, b: Int, flag: Boolean): Int {
		return if(flag){
			a + b
		}else{
			a - b
		}
	}

	/**
	 * 조건 문자열
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181934
	 */
	@Test
	fun TestConditionString(){
		val ineq = "<"
		val eq = "="
		val n = 20
		val m = 50
		val result = conditionString(ineq, eq, n, m)
		Assert.assertEquals(1, result)
	}

	private fun conditionString(ineq: String, eq: String, n: Int, m: Int): Int {
		return when{
			ineq == ">" && eq == "=" -> {
				if(n>=m) 1 else 0
			}
			ineq == "<" && eq == "=" -> {
				if(n<=m) 1 else 0
			}
			ineq == ">" && eq == "!" -> {
				if(n>m) 1 else 0
			}
			ineq == "<" && eq == "!" -> {
				if(n<m) 1 else 0
			}
			else -> 0
		}
	}

	@Test
	fun TestOddOrEven(){
		val n = 10
		val result = oddOrEven(n)
		Assert.assertEquals(220, result)
	}

	private fun oddOrEven(n: Int): Int {
		return if(n%2 !=0){
			// n 이 홀수라면, n 이하의 홀수의 합
			(1..n step 2).sum()
		}else{
			// n 이 짝수라면, n 이하의 짝수의 제곱의 합
			(2..n step 2).sumOf {
				it * it
			}
		}
	}

	@Test
	fun TestCommonMultiple(){
		val number = 60
		val n = 2
		val m = 3
		val result = commmonMultiple(number, n, m)
		Assert.assertEquals(1, result)
	}

	private fun commmonMultiple(number: Int, n: Int, m: Int): Int {
		return if(number%n==0 && number%m==0) 1 else 0
	}

	/**
	 * n의 배수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181937
	 */
	@Test
	fun TestMultipleN(){
		val num = 98
		val n = 2
		val result = multipleN(num, n)
		Assert.assertEquals(1, result)
	}

	private fun multipleN(num: Int, n: Int): Int {
		return if(num%n==0) 1 else 0
	}

	/**
	 * 두 수의 연산값 비교하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181938
	 */
	@Test
	fun TestCompareTwoNumbers(){
		val a = 2
		val b = 91
		val result = compareTwoNumbers(a, b)
		Assert.assertEquals(364, result)
	}

	private fun compareTwoNumbers(a: Int, b: Int): Int {
		return max("$a$b".toInt(), 2 * a * b)
	}

	/**
	 * 더 크게 합치기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181939
	 */
	@Test
	fun TestCombineBigger(){
		val a = 9
		val b = 91
		val result = combineBigger(a, b)
		Assert.assertEquals(991, result)
	}


	private fun combineBigger(a: Int, b: Int): Int {
		return max("$a$b".toInt(),"$b$a".toInt())
	}


	/**
	 * 문자열 곱하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181940
	 */
	@Test
	fun TestStringMultiplication(){
		val my_string = "string"
		val k = 3
		val result = stringMultiplication(my_string, k)
		Assert.assertEquals("stringstringstring", result)
	}

	private fun stringMultiplication(my_string: String, k: Int): String {

		return my_string.repeat(k)

//		val sb = StringBuilder()
//		repeat(k){
//			sb.append(my_string)
//		}
//		return sb.toString()
	}

	/**
	 * 문자 리스트를 문자열로 변환하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181941
	 */
	@Test
	fun testConvertingListOfCharactersToString(){
		val arr = arrayOf("a","b","c")
		val result = convertingListOfCharactersToString(arr)
		Assert.assertEquals("abc", result)
	}

	private fun convertingListOfCharactersToString(arr: Array<String>): String{
		return arr.joinToString("")
	}

	/**
	 * 문자열 섞기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181942
	 */
	@Test
	fun shuffleStrings(){
		val str1 = "aaaaa"
		val str2 = "bbbbb"
		val result = shuffleStrings(str1, str2)
		Assert.assertEquals("ababababab", result)
	}

	private fun shuffleStrings(str1: String, str2: String): String{

		return str1.zip(str2).joinToString(""){ (a, b) ->
			"$a$b"
		}

//		return str1.mapIndexed{ i, c ->
//			"$c${str2[i]}"
//		}.joinToString("")
	}

	/**
	 * 문자열 겹쳐쓰기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181943
	 */
	@Test
	fun overwritingStrings(){
		val my_string = "He11oWor1d"
		val overwrite_string = "lloWorl"
		val s = 2
		val result = overwritingStrings(my_string, overwrite_string, s)
		Assert.assertEquals("HelloWorld", result)
	}

	private fun overwritingStrings(my_string: String, overwrite_string: String, s: Int): String {

		return my_string.replaceRange(s, s + overwrite_string.length, overwrite_string)

//		return if(my_string.length>overwrite_string.length){
//			my_string.substring(0 until s) + overwrite_string + my_string.substring(s+overwrite_string.length)
//		}else{
//			my_string.substring(0 until s) + overwrite_string
//	    }
	}

	/**
	 * 대소문자 바꿔서 출력하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181949
	 */
	@Test
	fun printWithCaseChanged(){
		val s1 = "aBcDeFg"
		val result = printWithCaseChanged(s1)
		Assert.assertEquals("AbCdEfG", result)
	}

	private fun printWithCaseChanged(s1: String): String{
		val result = s1.map {
			if(it.isUpperCase()){
				it.lowercase()
			}else{
				it.uppercase()
			}
		}.joinToString("")
		print(result)
		return result
	}

	/**
	 * 문자열 반복해서 출력하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181950
	 */
	@Test
	fun printingStringRepeatedly(){
		val str = "string"
		val count = 5
		printingStringRepeatedly(str, count)
	}

	private fun printingStringRepeatedly(str: String, count: Int){
		for(i in 0 until count){
			print(str)
		}

		repeat(count){
			print(str)
		}

	}

	/**
	 * a뫄 b 출력하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/181951
	 */
	@Test
	fun printAWithB(){
		val a = 4
		val b = 5
		val result = printAWithB(a, b)
		Assert.assertEquals("""
			a = 4
			b = 5
		""".trimIndent(), result)
	}

	private fun printAWithB(a: Int, b: Int){
		println("""
			a = $a
			b = $b
		""".trimIndent())
	}


	/**
	 * 추억 점수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
	 */
	@Test
	fun memoryScore(){
		val name = arrayOf("may", "kein", "kain", "radi")
		val yearning = intArrayOf(5, 10, 1, 3)
		val photo = arrayOf(arrayOf("may", "kein", "kain", "radi"), arrayOf("may", "kein", "brin", "deny"), arrayOf("kon", "kain", "may", "coni"))
		val result = memoryScore(name, yearning, photo)
		println(result.toList())
//		Assert.assertEquals(result, arrayOf(19, 15, 6))
	}

	private fun memoryScore(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray{
		return photo.map { pic ->
			pic.sumOf {
				val idx = name.indexOf(it)
				if(idx!=-1){
					yearning[idx]
				}else{
					0
				}
			}
		}.toIntArray()
	}

	/**
	 * 두 수의 합
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120802
	 */
	@Test
	fun sumOfTwoNumbers(){
		val num1 = 2
		val num2 = 3
		val result = sumOfTwoNumbers(num1, num2)
		println(result)
		Assert.assertEquals(result, 5)
	}

	private fun sumOfTwoNumbers(num1: Int, num2: Int): Int {
		return num1 + num2
	}

	/**
	 * 두수의 차
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120803
	 */
	@Test
	fun differenceOfTwoNumber(){
		val num1 = 2
		val num2 = 3
		val result = differenceOfTwoNumber(num1, num2)
		println(result)
		Assert.assertEquals(result, -1)
	}

	private fun differenceOfTwoNumber(num1: Int, num2: Int): Int {
		return num1-num2
	}

	/**
	 * 두 수의 곱
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120804
	 */
	@Test
	fun multiplicationOfTwoNumber(){
		val num1 = 3
		val num2 = 4
		val result = multiplicationOfTwoNumber(num1, num2)
		println(result)
		Assert.assertEquals(result, 12)
	}

	private fun multiplicationOfTwoNumber(num1: Int, num2: Int): Int {
		return num1*num2
	}

	/**
	 * 몫 구하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120805
	 */
	@Test
	fun findTheShare(){
		val num1 = 10
		val num2 = 5
		val result = findTheShare(num1, num2)
		println(result)
		Assert.assertEquals(result, 2)
	}

	private fun findTheShare(num1: Int, num2: Int): Int {
		return num1/num2
	}

	/**
	 * 두 수의 나눗셈
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120806
	 */
	@Test
	fun divisionOfTwoNumbers(){
		val num1 = 3
		val num2 = 2
		val result = divisionOfTwoNumbers(num1, num2)
		println(result)
		Assert.assertEquals(result, 1500)
	}

	private fun divisionOfTwoNumbers(num1: Int, num2: Int): Int {
		return num1 * 1000 / num2
	}

	/**
	 * 숫자 비교하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120807
	 */
	@Test
	fun compareNumber(){
		val num1 = 2
		val num2 = 3
		val result = compareNumber(num1, num2)
		println(result)
		Assert.assertEquals(result, -1)
	}

	private fun compareNumber(num1: Int, num2: Int): Int {
		return if (num1 == num2) 1 else -1
	}

	/**
	 * 분수의 덧셈
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120808
	 */
	@Test
	fun additionOfFractions(){
		val numer1 = 1
		val denom1 = 2
		val numer2 = 3
		val denom2 = 4
		val result = additionOfFractions(numer1, denom1, numer2, denom2)
		println(result.toList())
		Assert.assertEquals(result.contentEquals(intArrayOf(5,4)), true)
	}

	private fun additionOfFractions(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
		val lcm = lcm(denom1, denom2)
		val denom3 = numer1 * (lcm / denom1) + numer2 * (lcm / denom2)
		val gcd = gcd(denom3, lcm)
		return intArrayOf(denom3 / gcd, lcm/gcd)
	}

	private tailrec fun gcd(num1: Int, num2: Int) : Int = if (num2 == 0) num1 else gcd(num2, num1 % num2)

	private fun lcm(num1: Int, num2: Int): Int = num1 * num2 / gcd(num1, num2)

	/**
	 * 배열 두배 만들기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120809
	 */
	@Test
	fun makeArrayDouble(){
		val numbers = intArrayOf(1, 2, 3, 4, 5)
		val result = makeArrayDouble(numbers)
		println(result.toList())
		Assert.assertEquals(intArrayOf(2, 4, 6, 8, 10).contentEquals(result), true)
	}

	private fun makeArrayDouble(numbers: IntArray): IntArray {
		return numbers.map { it*2 }.toIntArray()
	}

	/**
	 * 나머지 구하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120810
	 */
	@Test
	fun findTheRest(){
		val num1 = 3
		val num2 = 2
		val result = findTheRest(num1, num2)
		println(result)
		Assert.assertEquals(result, 1)
	}

	private fun findTheRest(num1: Int, num2: Int): Int {
		return num1%num2
	}

	/**
	 * 중앙값 구하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120811
	 */
	@Test
	fun getMiddleNumber(){
		val array = intArrayOf(1, 2, 7, 10, 11)
		val result = getMiddleNumber(array)
		println(result)
		Assert.assertEquals(result, 7)
	}

	private fun getMiddleNumber(array: IntArray): Int {
		return array.sorted()[array.size/2]
	}

	/**
	 * 최빈값 구하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120812
	 */
	@Test
	fun findingTheMode(){
		val array = intArrayOf(1, 1, 2, 2)
		val result = findingTheMode(array)
		println(result)
		Assert.assertEquals(-1, result)
	}

	private fun findingTheMode(array: IntArray): Int {
		return array.toList().groupingBy { it }.eachCount().maxByOrNull { it.value }?.key ?: -1
	}



	/**
	 * 나이 출력
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120820
	 */
	@Test
	fun ageOutput(){
		val age = 40
		val result = ageOutput(age)
		println(result)
		Assert.assertEquals(result, 1983)
	}

	private fun ageOutput(age: Int): Int {
		return 2022 - age + 1
	}

	/**
	 * 각도기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120829
	 */
	@Test
	fun protractor(){
		val angle = 70
		val result = protractor(angle)
		println(result)
		Assert.assertEquals(result, 1)
	}

	private fun protractor(angle: Int): Int {
		return when(angle){
			in 1 until  90 -> 1
			90 -> 2
			in 91 until 180 -> 3
			180 -> 4
			else -> 0
		}
	}

	/**
	 * 배열의 평균값
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120817
	 */
	@Test
	fun averageOfArray(){
		val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		val result = averageOfArray(numbers)
		println(result)
		Assert.assertEquals(result, 5.5, 0.1)
	}

	private fun averageOfArray(numbers: IntArray): Double {
		return numbers.average()
	}

	/**
	 * 짝수의 합
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120831
	 */
	@Test
	fun sumOfEvenNumbers(){
		val n = 10
		val result = sumOfEvenNumbers(n)
		println(result)
		Assert.assertEquals(result, 30)
	}

	private fun sumOfEvenNumbers(n: Int): Int {
		return (1..n).filter { it%2==0 }.sum()
	}

	/**
	 * 양꼬치
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120830
	 */
	@Test
	fun lambSkewers(){
		val n = 10
		val k = 3
		val result = lambSkewers(n, k)
		println(result)
		Assert.assertEquals(result, 124000)
	}

	private fun lambSkewers(n: Int, k: Int): Int {
		return (n * 12000 + (k - n/10 ) * 2000)
	}

	/**
	 * 배열 뒤집기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120821
	 */
	@Test
	fun flipArray(){
		val num_list = intArrayOf(1, 2, 3, 4, 5)
		val result = flipArray(num_list)
		println(result.toList())
		Assert.assertEquals(result.contentEquals(intArrayOf(5, 4, 3, 2, 1)), true)
	}

	private fun flipArray(num_list: IntArray): IntArray {
		return num_list.reversedArray()
	}

	/**
	 * 중복된 숫자 개수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120583
	 */
	@Test
	fun numberOfDuplicateCount(){
		val array = intArrayOf(1, 1, 2, 3, 4, 5)
		val n = 1
		val result = numberOfDuplicateCount(array, n)
		println(result)
		Assert.assertEquals(result, 2)
	}

	private fun numberOfDuplicateCount(array: IntArray, n: Int): Int {
		return array.count { it == n }
	}

	/**
	 * 머쓱이보다 키 큰 사람
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120585
	 */
	@Test
	fun personTallerThanOtherPerson(){
		val array = intArrayOf(149, 180, 192, 170)
		val height = 167
		val result = personTallerThanOtherPerson(array, height)
		println(result)
		Assert.assertEquals(result, 3)
	}

	private fun personTallerThanOtherPerson(array: IntArray, n: Int): Int {
		return array.count{ it > n }
	}

	/**
	 * 배열 원소의 길이
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120854
	 */
	@Test
	fun lengthOfArray(){
		val strlist = arrayOf("We", "are", "the", "world!")
		val result = lengthOfArray(strlist)
		println(result.toList())
		Assert.assertEquals(intArrayOf(2, 3, 3, 6).contentEquals(result), true)
	}

	private fun lengthOfArray(strlist: Array<String>): IntArray {
		return strlist.map { it.length }.toIntArray()
	}

	/**
	 * 짝수 홀수 개수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120824
	 */
	@Test
	fun evenOddNumber(){
		val num_list = intArrayOf(1, 2, 3, 4, 5)
		val result = evenOddNumber(num_list)
		println(result.toList())
		Assert.assertEquals(intArrayOf(2, 3).contentEquals(result), true)
	}

	private fun evenOddNumber(num_list: IntArray): IntArray {
		return intArrayOf(num_list.count{it%2==0}, num_list.count{it%2!=0})
	}

	/**
	 * 배열 자르기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120833
	 */
	@Test
	fun cutArray(){
		val numbers = intArrayOf(1, 2, 3, 4, 5)
		val num1 = 1
		val num2 = 3
		val result = cutArray(numbers, num1, num2)
		println(result.toList())
		Assert.assertEquals(intArrayOf(2, 3, 4).contentEquals(result), true)
	}

	private fun cutArray(numbers: IntArray, num1: Int, num2: Int): IntArray {
		return numbers.sliceArray(num1 .. num2)
	}

	/**
	 * 편지
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120898
	 */
	@Test
	fun letter(){
		val message = "happy birthday!"
		val result = letter(message)
		println(result)
		Assert.assertEquals(result, 30)
	}

	private fun letter(message: String): Int {
		return message.length * 2
	}

	/**
	 * 점의 위치 구하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120841
	 */
	@Test
	fun findLocationOfDot(){
		val dot = intArrayOf(2,4)
		val result = findLocationOfDot(dot)
		println(result)
		Assert.assertEquals(result, 1)
	}

	private fun findLocationOfDot(dot: IntArray): Int {
		return when{
			dot[0]>0 && dot[1]>0 -> 1
			dot[0]<0 && dot[1]>0 -> 2
			dot[0]<0 && dot[1]<0 -> 3
			else -> 4
 		}
	}

	/**
	 * 특정 문자 제거하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120826
	 */
	@Test
	fun removeSpecificCharacters(){
		val my_string = "abcdef"
		val letter = "f"
		val result = removeSpecificCharacters(my_string, letter)
		println(result)
		Assert.assertEquals(result, "abcde")
	}

	private fun removeSpecificCharacters(my_string: String, letter: String): String {
		return my_string.replace(letter, "")
	}

	/**
	 * 아이스 아메리카노
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120819
	 */
	@Test
	fun iceAmericano(){
		val money = 5500
		val result = iceAmericano(money)
		println(result)
		Assert.assertEquals(result.contentEquals(intArrayOf(1,0)), true)
	}

	private fun iceAmericano(money: Int): IntArray {
		return intArrayOf(money/5500, money%5500)
	}

	/**
	 * 피자 나워 먹기(1)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120814
	 */
	@Test
	fun eatPizza1(){
		val n = 7
		val result = eatPizza1(n)
		println(result)
		Assert.assertEquals(result, 1)
	}

	private fun eatPizza1(n: Int): Int {
		return ceil(n/7.0).toInt()
	}

	/**
	 * 피자 나워 먹기(3)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120816
	 */
	@Test
	fun eatPizza3(){
		val slice = 7
		val n = 10
		val result = eatPizza3(slice, n)
		println(result)
		Assert.assertEquals(result, 2)
	}

	private fun eatPizza3(slice: Int, n: Int): Int {
		return ceil(n/slice.toDouble()).toInt()
	}

	/**
	 * 삼각형의 완성조건 (1)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120889
	 */
	@Test
	fun completingTriangle(){
		val sides = intArrayOf(1,2,3)
		val result = completingTriangle(sides)
		println(result)
		Assert.assertEquals(result, 2)
	}

	private fun completingTriangle(sides: IntArray): Int {
		return sides.sorted().let { (a, b, c) ->
			if(a+b>c) 1 else 2
		}
	}

	/**
	 * 최댓값 만들기 (1)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120847
	 */
	@Test
	fun makeMaxNumber(){
		val numbers = intArrayOf(1, 2, 3, 4, 5)
		val result = makeMaxNumber(numbers)
		println(result)
		Assert.assertEquals(result, 20)
	}

	private fun makeMaxNumber(numbers: IntArray) = numbers.sorted().takeLast(2).reduce { acc, i -> acc * i }

	/**
	 * 문자 반복 출력하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120825
	 */
	@Test
	fun repeatingCharacters(){
		val my_string = "hello"
		val n = 3
		val result = repeatingCharacters(my_string, n)
		println(result)
		Assert.assertEquals(result, "hhheeellllllooo")
	}

	private fun repeatingCharacters(my_string: String, n: Int) = my_string.map { it.toString().repeat(n) }.joinToString("")

	/**
	 * 짝수는 싫어요
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120813
	 */
	@Test
	fun iDoNotLikeEvenNumber(){
		val n = 10
		val result = iDoNotLikeEvenNumber(n)
		println(result.toList())
		Assert.assertEquals(result.contentEquals(intArrayOf(1, 3, 5, 7, 9)), true)
	}

	private fun iDoNotLikeEvenNumber(n: Int): IntArray {
		return (0..n).filter { it%2!=0 }.toIntArray()
	}

	/**
	 * 배열의 유사도
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120903
	 */
	@Test
	fun arraySimilarity(){
		val s1 = arrayOf("a", "b", "c")
		val s2 = arrayOf("com", "b", "d", "p", "c")
		val result = arraySimilarity(s1, s2)
		println(result)
		Assert.assertEquals(result, 2)
	}

	private fun arraySimilarity(s1: Array<String>, s2: Array<String>): Int {
		return s1.count(s2::contains)
	}

	/**
	 * 옷가게 할인 받기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120818
	 */
	@Test
	fun discountClothingStore(){
		val price = 150000
		val result = discountClothingStore(price)
		println(result)
		Assert.assertEquals(result, 142500)
	}

	private fun discountClothingStore(price: Int): Int {
		return when(price){
			in 0 until 100_000 -> price
			in 100_000 until 300_000 -> floor(price * 0.95).toInt()
			in 300_000 until 500_000 -> floor(price * 0.9).toInt()
			else -> floor( price * 0.8).toInt()
		}
	}

	/**
	 * 순서쌍의 개수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120836
	 */
	@Test
	fun numberOfOrderedPairs(){
		val n = 20
		val result = numberOfOrderedPairs(n)
		println(result)
		Assert.assertEquals(result, 6)
	}

	private fun numberOfOrderedPairs(n: Int): Int {
		return (1..n).count{
			n%it==0
		}
	}

	/**
	 * 문자열안에 문자열
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120908
	 */
	@Test
	fun stringInString(){
		val str1 = "ab6CDE443fgh22iJKlmn1o"
		val str2 = "6CD"
		val result = stringInString(str1, str2)
		println(result)
		Assert.assertEquals(result, 1)
	}

	private fun stringInString(str1: String, str2: String): Int {
		return if(str2 in str1) 1 else 2
	}

	/**
	 * 자릿수 더하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120906
	 */
	@Test
	fun addDigits(){
		val n = 1234
		val result = addDigits(n)
		println(result)
		Assert.assertEquals(result, 10)
	}

	private fun addDigits(n: Int): Int {
		return "$n".toList().sumOf { it.digitToInt() }
	}

	/**
	 * 제곱수 판별하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120909
	 */
	@Test
	fun determineSquares(){
		val n = 144
		val result = determineSquares(n)
		println(result)
		Assert.assertEquals(result, 1)
	}

	private fun determineSquares(n: Int): Int {
		return if(sqrt(n.toDouble())%1 == 0.0) 1 else 2
	}


	/**
	 * 개미 군단
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120837
	 */
	@Test
	fun antArmy(){
		val hp = 23
		val result = antArmy(hp)
		println(result)
		Assert.assertEquals(result, 5)
	}

	private fun antArmy(hp: Int): Int {
		return hp/5 + hp%5/3 + hp%5%3
	}

	/**
	 * 숨어있는 숫자의 덧셈(1)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120851
	 */
	@Test
	fun hiddenPlusOfNumber(){
		val my_string = "aAb1B2cC34oOp"
		val result = hiddenPlusOfNumber(my_string)
		println(result)
		Assert.assertEquals(result, 10)
	}

	private fun hiddenPlusOfNumber(my_string: String): Int {
		return my_string.filter(Char::isDigit).sumOf(Char::digitToInt)
	}

	/**
	 * 모음 제거
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120849
	 */
	@Test
	fun removeVowel(){
		val my_string = "bus"
		val result = removeVowel(my_string)
		println(result)
		Assert.assertEquals(result, "bs")
	}

	private fun removeVowel(my_string: String): String {
		return my_string.replace("[aeiou]".toRegex(), "")
	}

	/**
	 * n의 배수 고르기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120905
	 */
	@Test
	fun multipleOfN(){
		val n = 3
		val numlist = intArrayOf(4, 5, 6, 7, 8, 9, 10, 11, 12)
		val result = multipleOfN(n, numlist)
		println(result)
		Assert.assertEquals(true, result.contentEquals(intArrayOf(6, 9, 12)))
	}

	private fun multipleOfN(n: Int, numlist: IntArray): IntArray {
		return numlist.filter {
			it%n==0
		}.toIntArray()
	}

	/**
	 * 세균 증식
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120910
	 */
	@Test
	fun bacterialGrowth(){
		val n = 7
		val t = 15
		val result = bacterialGrowth(n, t)
		println(result)
		Assert.assertEquals(229_376, result)
	}

	private fun bacterialGrowth(n: Int, t: Int): Int {
//		return n shl t
		return n * 2.0.pow(t).toInt()
	}

	/**
	 * 가위 바위 보
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120839
	 */
	@Test
	fun rockPaperScissors(){
		val rsp = "2"
		val result = rockPaperScissors(rsp)
		println(result)
		Assert.assertEquals("0", result)
	}

	private fun rockPaperScissors(rsp: String): String {
		return rsp.map {
			when(it){
				'2' -> '0'
				'0' -> '5'
				'5' -> '2'
				else -> '0'
			}
		}.joinToString("")
	}

	/**
	 * 주사위의 개수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120845
	 */
	@Test
	fun numberOfDice(){
		val box = intArrayOf(1,1,1)
		val n = 1
		val result = numberOfDice(box, n)
		println(result)
		Assert.assertEquals(1, result)
	}

	private fun numberOfDice(box: IntArray, n: Int): Int {
		return (box[0]/n) * (box[1]/n) * (box[2]/n)
	}

	/**
	 * 대문자와 소문자
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120893
	 */
	@Test
	fun uppercaseAndLowercase(){
		val my_string = "cccCCC"
		val result = uppercaseAndLowercase(my_string)
		println(result)
		Assert.assertEquals("CCCccc", result)
	}

	private fun uppercaseAndLowercase(my_string: String): String {
		return my_string.map{ if(it.isUpperCase()) it.lowercase() else it.uppercase() }.joinToString("")
	}

	/**
	 * 암호 해독
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120892
	 */
	@Test
	fun decryption(){
		val cipher = "dfjardstddetckdaccccdegk"
		val code = 4
		val result = decryption(cipher, code)
		println(result)
		Assert.assertEquals("attack", result)
	}

	private fun decryption(cipher: String, code: Int): String {
		return cipher.filterIndexed { index, c ->
			(index+1)%code==0
		}
	}

	/**
	 * 가장 큰 수 찾기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120899
	 */
	@Test
	fun findMaxNumber(){
		val array = intArrayOf(9, 10, 11, 8)
		val result = findMaxNumber(array)
		println(result.toList())
		Assert.assertEquals(true, result.contentEquals(intArrayOf(11,2)))
	}

	private fun findMaxNumber(array: IntArray): IntArray {
		return array.maxOf{ it }.let {
			intArrayOf(it, array.indexOf(it))
		}
	}

	/**
	 * 문자열 정렬하기 (1)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120850
	 */
	@Test
	fun sortString(){
		val my_string = "hi12392"
		val result = sortString(my_string)
		println(result.toList())
		Assert.assertEquals(true, result.contentEquals(intArrayOf(1, 2, 2, 3, 9)))
	}

	private fun sortString(my_string: String): IntArray {
		return my_string.filter(Char::isDigit).map(Char::digitToInt).sorted().toIntArray()
	}

	/**
	 * 배열 회전시키기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120844
	 */
	@Test
	fun rotateArray(){
		val numbers = intArrayOf(1, 2, 3)
		val direction = "right"
		val result = rotateArray(numbers, direction)
		println(result.toList())
		Assert.assertEquals(true, result.contentEquals(intArrayOf(3, 1, 2)))
	}

	private fun rotateArray(numbers: IntArray, direction: String): IntArray {
		val numberList = numbers.toMutableList()
		if(direction == "right"){
			numberList.add(0, numberList.last())
			numberList.removeAt(numberList.lastIndex)
		}else{
			numberList.add(numbers.first())
			numberList.removeAt(0)
		}
		return numberList.toIntArray()
	}

	/**
	 * 최댓값 만들기 (2)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120862
	 */
	@Test
	fun makeMax2(){
		val numbers = intArrayOf(1, 2, -3, 4, -5)
		val result = makeMax2(numbers)
		println(result)
		Assert.assertEquals(15, result)
	}

	private fun makeMax2(numbers: IntArray): Int {
		return numbers.sorted().let {
			max(it.first() * it[1], it.last() * it[it.lastIndex-1])
		}
	}

	/**
	 * 약수 구하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120897
	 */
	@Test
	fun factors(){
		val n = 24
		val result = factors(n)
		println(result.toList())
		Assert.assertEquals(true, result.contentEquals(intArrayOf(1, 2, 3, 4, 6, 8, 12, 24)))
	}

	private fun factors(n: Int): IntArray {
		return (1..n).filter {
			n%it==0
		}.toIntArray()
	}

	/**
	 * 피자 나눠 먹기 (2)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120815
	 */
	@Test
	fun eatPizza2(){
		val n = 4
		val result = eatPizza2(n)
		println(result)
		Assert.assertEquals(2, result)
	}

	private fun eatPizza2(n: Int): Int {
		var count = 1
		while(count*6%n!=0){
			count++
		}
		return count
	}

	/**
	 * 외계행성의 나이
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120834
	 */
	@Test
	fun ageOfExoplanets(){
		val age = 23
		val result = ageOfExoplanets(age)
		println(result)
		Assert.assertEquals("cd", result)
	}

	private fun ageOfExoplanets(age: Int): String {
		return age.toString().toCharArray().joinToString("") {
			(it + 49).toString()
		}
	}

	/**
	 * 인덱스 바꾸기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/120895
	 */
	@Test
	fun changeIndex(){
		val my_string = "hello"
		val num1 = 1
		val num2 = 2
		val result = changeIndex(my_string, num1, num2)
		println(result)
		Assert.assertEquals("hlelo", result)
	}

	private fun changeIndex(my_string: String, num1: Int, num2: Int): String {
		return my_string.toList().let {
			Collections.swap(it, num1, num2)
			it.joinToString("")
		}
	}

}