package kr.co.rkwkgo.androiddemo

import org.junit.Assert
import org.junit.Test
import kotlin.math.max
import kotlin.math.sqrt

/**
 * https://school.programmers.co.kr
 * Level 1
 */
class CodingTestLevel1{

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
						println("${numList[i]} ${numList[j]} ${numList[k]} = $sum")
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