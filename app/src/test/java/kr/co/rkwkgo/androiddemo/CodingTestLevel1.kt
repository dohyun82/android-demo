package kr.co.rkwkgo.androiddemo

import org.junit.Assert
import org.junit.Test
import kotlin.math.sqrt

/**
 * https://school.programmers.co.kr
 * Level 1
 */
class CodingTestLevel1{

	/**
	 * 체육복
	 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
	 */
	@Test
	fun gymSuit(){
		val n = 5
		val lost = intArrayOf(4,2)
		val reserve = intArrayOf(3, 5)
		val result = gymSuit(n, lost, reserve)
		Assert.assertEquals(5, result)
	}

	private fun gymSuit(n: Int, lost: IntArray, reserve: IntArray): Int {
		val lostList = lost.sorted().toMutableList()
		val reserveList = reserve.sorted().toMutableList().filter {
			val result = lostList.contains(it)
			if(result){
				lostList.remove(it)
			}
			!result
		}.toMutableList()
		val count = lostList.count {
			when{
				reserveList.contains(it-1) -> {
					reserveList.remove(it-1)
					true
				}
				reserveList.contains(it) -> {
					reserveList.remove(it)
					true
				}
				reserveList.contains(it+1) -> {
					reserveList.remove(it+1)
					true
				}
				else -> false
			}
		}
		return n - lostList.size + count
	}

	/**
	 * 햄버거 만들기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
	 */
	@Test
	fun makingHamburgers(){
		val ingredient = intArrayOf(1, 2, 3, 1, 1, 2, 3, 1)
		val result = makingHamburgers(ingredient)
		Assert.assertEquals(2, result)
	}

	private fun makingHamburgers(ingredient: IntArray): Int {
		var count = 0
		val sb = StringBuffer(ingredient.joinToString(""))
		while(true){
			var isMatching = false
			val idx = sb.indexOf("1231")
			if(idx!=-1){
				sb.delete(idx, idx+4)
				count++
				isMatching = true
			}
			if(!isMatching){
				break
			}
		}
		return count
	}

	/**
	 * 둘만의 암호
	 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
	 */
	@Test
	fun ourPassword(){
		val s = "zzzz"
		val skip = "abcd"
		val index = 1
		val result = ourPassword(s, skip, index)
		Assert.assertEquals("eeee", result)
	}

	private fun ourPassword(s: String, skip: String, index: Int): String {
		// 1. s 를 반복문 으로 돌림
		// 2. char 값인 item 의 code 를 index 만큼 더하기
		// 3. index 만큼 더할때 skip 에 속하는 문자 갯수 만큼 code 를 추가로 더하기
		// 4. code 는 최소 'a' 97 최대 'z' 122
		return s.map {
			getSkipIndex(it, skip, index)
		}.joinToString("")
	}

	private fun getSkipIndex(c: Char, skip: String, index: Int): Char{
		var addIndex = 0
		(c+1 ..  c + index).forEach {
			var tempChar = it
			if(tempChar.code>'z'.code){
				tempChar -= 26
			}
			if(skip.contains(tempChar)){
				addIndex++
			}
		}
		return if(addIndex == 0){
			var result = c.code + index
			if(result>'z'.code){
				result -= 26
			}
			result.toChar()
		}else{
			var result = c.code + index
			if(result>'z'.code){
				result -= 26
			}
			getSkipIndex(result.toChar(), skip, addIndex)
		}
	}


	/**
	 * 대충 만든 자판
	 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
	 */
	@Test
	fun roughlyMadeKeyboard(){
		val keymap = arrayOf("ABACD", "BCEFD")
		val targets = arrayOf("ABCD","AABB")
		val result = roughlyMadeKeyboard(keymap, targets)
		Assert.assertArrayEquals(intArrayOf(9,4), result)
	}

	private fun roughlyMadeKeyboard(keymap: Array<String>, targets: Array<String>): IntArray {
		val resultList = mutableListOf<Int>()
		// 1. targets 배열 길이 만큼 반복
		for(target in targets){
			var count = 0
			// 2. target 의 인자 수 만큼 반복
			for(idx in target.indices){
				var resultIdx = 101
				// 3. keymap 에서 target 의 인자로 최소 인덱스 구하기
				for(key in keymap){
					val tempIdx = key.indexOf(target[idx])
					if(tempIdx != -1 && resultIdx>tempIdx){
						resultIdx = tempIdx
					}
				}
				if(resultIdx == 101){
					count = 0
					break
				}else{
					count += (resultIdx + 1)
				}
			}
			if(count==0){
				resultList.add(-1)
			}else{
				resultList.add(count)
			}
		}
		return resultList.toIntArray()
	}

	/**
	 * 문자열 나누기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
	 */
	@Test
	fun splitString(){
		val s = "aaabbaccccabba"
		val result = splitString(s)
		Assert.assertEquals(3, result)
	}

	private fun splitString(s: String): Int {
		// 1. s 의 첫 문자 분리
		// 2. s 를 반복문에 돌림
		// 3. s 의 첫문자와 같은 갯수와 다른 갯수가 같아지면 잘라내기
		// 4. 잘라진 갯수 세서 리턴

		var count = 0
		var temp = s
		while(temp.isNotEmpty()){
			temp = splitString2(temp)
			count++
		}
		return count
	}

	private fun splitString2(temp: String): String{
		val char = temp.first()
		var cnt1 = 0
		var cnt2 = 0
		var result = ""
		for(idx in temp.indices) {
			if(temp[idx] == char){
				cnt1++
			}else{
				cnt2++
			}
			if(cnt1 == cnt2){
				result = temp.substring(idx+1, temp.lastIndex+1)
				break
			}
		}
		return result
	}

	/**
	 * 숫자 짝궁
	 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
	 */
	@Test
	fun numberPair(){
		val x = "100"
		val y = "123450"
		val result = numberPair2(x, y)
		Assert.assertEquals("10", result)
	}

	private fun numberPair2(x: String, y: String): String {
		val ySb = StringBuffer(y)
		val resultList = x.filter { c ->
			val idx = ySb.indexOf(c)
			if(idx != -1){
				ySb.delete(idx, idx+1)
				true
			}else{
				false
			}
		}.map { it.digitToInt() }
		return if(resultList.isEmpty()){
			"-1"
		}else{
			if(resultList.count{
					it == 0
				} == resultList.size){
				"0"
			}else{
				resultList.sortedDescending().joinToString("")
			}
		}
	}

	private fun numberPair(x: String, y: String): String {
		val xList = x.map {
			it.digitToInt()
		}
		val yList = y.map {
			it.digitToInt()
		}.toMutableList()
		val resultList = mutableListOf<Int>()
		xList.forEach {
			val idx = yList.indexOf(it)
			if(idx != -1){
				yList.removeAt(idx)
				resultList.add(it)
			}
		}
		return if(resultList.size==0){
			"-1"
		}else{
			if(resultList.count{
				it == 0
			} == resultList.size){
				"0"
			}else{
				resultList.sortedDescending().joinToString("")
			}
		}
	}

	/**
	 * 로또의 최고 순위와 최저 순위
	 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
	 */
	@Test
	fun highestAndLowestLottoRankings(){
		val lottos = intArrayOf(44, 1, 0, 0, 31, 25)
		val win_nums = intArrayOf(31, 10, 45, 1, 6, 19)
		val result = highestAndLowestLottoRankings(lottos, win_nums)
		Assert.assertArrayEquals(intArrayOf(3,5), result)
	}

	private fun highestAndLowestLottoRankings(lottos: IntArray, win_nums: IntArray): IntArray {
		val remainCount = lottos.count {
			it == 0
		}
		val matchingCount = lottos.count {
			win_nums.contains(it)
		}
		return intArrayOf(getLottoNumber(matchingCount + remainCount), getLottoNumber(matchingCount))
	}

	private fun getLottoNumber(matchingCount: Int): Int{
		return when(matchingCount){
			6 -> 1
			5 -> 2
			4 -> 3
			3 -> 4
			2 -> 5
			else -> 6
		}
	}

	/**
	 * 옹알이
	 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
	 */
	@Test
	fun babbling(){
		val babbling = arrayOf("ayamayaa")
		val result = babbling(babbling)
		Assert.assertEquals(0, result)
	}

	private fun babbling(babbling: Array<String>): Int {
		// 1. babbling 배열을 반복
		// 2. 미리 정의 된 네 가지 조합으로 매칭되는 경우 카운트
		// 3. 같은 글자가 연속된 경우는 카운트 안함
		// 4. 카운트 갯수 반환
		val array = arrayOf("aya", "ye", "woo", "ma")
		return babbling.count {
			var str = it
			array.forEach { it2 ->
				str = str.replace(it2, "*")
				str = str.replace("**", "-")
				str = str.replace("*", "+")
			}
			str = str.replace("+", "")
			str.isEmpty()
		}
	}

	/**
	 * 실패율
	 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
	 */
	@Test
	fun failureRate(){
		val N = 5
		val stages = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
		val result = failureRate(N, stages)
		Assert.assertArrayEquals(intArrayOf(3,4,2,1,5), result)
	}

	private fun failureRate(N: Int, stages: IntArray): IntArray {
		// 1. stages 를 MutableList 로 형변환
		val list = stages.toMutableList()
		// 2. N 만큼 반복해서 stage 별 실패율 구하기
		val result = (1..N).mapIndexed { index, i ->
			val originCount = list.size
			list.removeIf { it2 ->
				it2 == i
			}
			(index+1 to (originCount - list.size) / originCount.toFloat())
		}
		return result.sortedBy {
			-it.second
		}.map {
			it.first
		}.toIntArray()
	}

	/**
	 * 덧칠하기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
	 */
	@Test
	fun applyMorePaint(){
		val n = 5
		val m = 2
		val section = intArrayOf(1,4,5)
		val result = applyMorePaint(n, m, section)
		Assert.assertEquals(2, result)
	}

	private fun applyMorePaint(n: Int, m: Int, section: IntArray): Int {
		var result = 0
		var max = 0
		for(i in section[0] .. section[section.lastIndex]){
			if(i > max){
				val count = section.count {
					it == i
				}
				if(count>0){
					result++
					max = i + m -1
				}
			}
		}
		return result
	}

	/**
	 * 기사단원의 무기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
	 */
	@Test
	fun weaponOfTemplar(){
		val number = 5
		val limit = 3
		val power = 2
		val result = weaponOfTemplar(number, limit, power)
		Assert.assertEquals(10, result)
	}

	private fun weaponOfTemplar(number: Int, limit: Int, power: Int): Int {
		return (1 .. number).sumOf {
			var count = 0
			for(i in 1 .. sqrt(it.toDouble()).toInt()){
				if(it % i == 0){
					count++
					if(it / i != i){
						count++
					}
				}
			}
			if (count <= limit) {
				count
			} else {
				power
			}
		}
	}

	/**
	 * 소수 만들기
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12977
	 */
	@Test
	fun makePrimeNumbers(){
		val nums = intArrayOf(1, 2, 4, 5, 8)
		val result = makePrimeNumbers(nums)
		Assert.assertEquals(5, result)
	}

	private fun makePrimeNumbers(nums: IntArray): Int {
		val numList = nums.sorted()
		val list = mutableListOf<Int>()
		for(i in (0 until numList.size-2)){
			for(j in (1 until numList.size-1)){
				for(k in (2 until numList.size)){
					val sum = numList[i] + numList[j] + numList[k]
					if(numList[i]!=numList[j] && numList[j]!=numList[k] && numList[k]!=numList[i]){
						if(numList[i]<numList[j] && numList[j]<numList[k]){
							if(isPrime2(sum)){
								list.add(sum)
							}
						}
					}
				}
			}
		}
		return list.count()
	}

	/**
	 * 소수인지 판별하기
	 */
	private fun isPrime(num: Int): Boolean{
		for(i in 2 until num){
			if(num%i == 0){
				return false
			}
		}
		return true
	}
	private fun isPrime2(num: Int): Boolean{
		if(num <= 1) return false
		return (2..sqrt(num.toDouble()).toInt()).none{
			num % it == 0
		}
	}

	/**
	 * 모의고사
	 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
	 */
	@Test
	fun mockExam(){
		val answers = intArrayOf(1,3,2,4,2)
		val result = mockExam(answers)
		Assert.assertArrayEquals(intArrayOf(1,2,3), result)
	}

	private fun mockExam(answers: IntArray): IntArray {
		val temp1 = intArrayOf(1,2,3,4,5)
		val temp2 = intArrayOf(2,1,2,3,2,4,2,5)
		val temp3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)

		var count1 = 0
		var count2 = 0
		var count3 = 0
		answers.forEachIndexed { index, i ->
			if(temp1[index%temp1.size] == i){
				count1++
			}
			if(temp2[index%temp2.size] == i){
				count2++
			}
			if(temp3[index%temp3.size] == i){
				count3++
			}
		}
		val max = mutableListOf(count1, count2, count3).maxOf { it }
		val result = mutableListOf<Int>()
		if(max==count1){
			result.add(1)
		}
		if(max==count2){
			result.add(2)
		}
		if(max==count3){
			result.add(3)
		}
		return result.toIntArray()
	}

	/**
	 * 과일 장수
	 * https://school.programmers.co.kr/learn/courses/30/lessons/135808
	 */
	@Test
	fun fruiterer(){
		val k = 3
		val m = 4
		val score = intArrayOf(1, 2, 3, 1, 2, 3, 1)
		val result = fruiterer(k, m, score)
		Assert.assertEquals(8, result)
	}

	private fun fruiterer(k: Int, m: Int, score: IntArray): Int {
		var sum = 0
		score.sortedDescending().forEachIndexed { index, i ->
			if((index+1)%m==0){
				sum += i * m
			}
		}
		return sum
	}

	/**
	 * 명예의 전당
	 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
	 */
	@Test
	fun hallOfFame1(){
		val k = 3
		val source = intArrayOf(10, 100, 20, 150, 1, 100, 200)
		val result = hallOfFame1(k, source)
		Assert.assertArrayEquals(intArrayOf(10, 10, 10, 20, 20, 100, 100), result)
	}

	fun hallOfFame1(k: Int, score: IntArray): IntArray {
		val list = mutableListOf<Int>()
		val result = mutableListOf<Int>()
		score.forEach {
			list.add(it)
			list.sortDescending()
			if(list.size>k){
				list.removeLast()
			}
			result.add(list.last())
		}
		return result.toIntArray()
	}

	/**
	 * 카드 뭉치
	 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
	 */
	@Test
	fun packOfCards(){
		val cards1 = arrayOf("i", "water", "drink")
		val cards2 = arrayOf("want", "to")
		val goal = arrayOf("i", "want", "to", "drink", "water")
		val result = packOfCards(cards1, cards2, goal)
		Assert.assertEquals("No", result)
	}

	private fun packOfCards(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
		var cards1Idx = 0
		var cards2Idx = 0
		goal.forEach {
			when{
				cards1.size > cards1Idx && it == cards1[cards1Idx] -> {
					cards1Idx++
				}
				cards2.size > cards2Idx && it == cards2[cards2Idx] -> {
					cards2Idx++
				}
				else -> {
					return "No"
				}
			}
		}
		return "Yes"
	}

	/**
	 * 푸드 파이트 대회
	 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
	 */
	@Test
	fun foodFightCompetition(){
		val food = intArrayOf(1, 3, 4, 6)
		val result = foodFightCompetition(food)
		println(result)
		Assert.assertEquals("1223330333221", result)
	}

	private fun foodFightCompetition(food: IntArray): String {
		var temp = ""
		food.forEachIndexed { index, i ->
			if(index>0){
				repeat(i/2){
					temp += index
				}
			}
		}
		return temp + "0" + temp.reversed()
	}


	/**
	 * 크기가 작은 부분문자열
	 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
	 */
	@Test
	fun smallSubString(){
		val t = "10203"
		val p = "15"
		val result = smallSubString(t, p)
		println(result)
		Assert.assertEquals(3, result)
	}

	private fun smallSubString(t: String, p: String): Int {
		val len = p.length
		val pLong = p.toLong()
		var count = 0
		val repeat = t.length - (len-1)
		(0 until repeat).forEach{
			val temp = t.substring(it until it+len).toLong()
			if(pLong>=temp){
				count++
			}
		}
		return count
	}

	/**
	 * 가장 가까운 같은 글자
	 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
	 */
	@Test
	fun closetSameLetter(){
		val s = "banana"
		val result = closetSameLetter(s)
		for(i in result){
			println(i)
		}
		val expect = intArrayOf(-1, -1, -1, 2, 2, 2)
		Assert.assertArrayEquals(expect, result)
	}

	private fun closetSameLetter(s: String): IntArray {
		val map = mutableMapOf<String, Int>()
		return s.mapIndexed { index, c ->
			val firstIdx  = s.indexOf(c)
			if(firstIdx == index){
				map["$c"] = firstIdx
				-1
			}else{
				val result = index - (map["$c"] ?: 0)
				map["$c"] = index
				result
			}
		}.toIntArray()
	}

}