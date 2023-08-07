package kr.co.rkwkgo.androiddemo

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.math.*

/**
 * https://school.programmers.co.kr
 * Level 0
 */
class CodingTestLevel0 {

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