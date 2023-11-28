package kr.co.rkwkgo.androiddemo

import org.junit.Assert
import org.junit.Test

/**
 * https://school.programmers.co.kr
 * Level 1
 */
class CodingTestLevel1{

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