package kr.co.rkwkgo.androiddemo

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.math.*

/**
 * https://school.programmers.co.kr
 * Level 0
 */
class CodingTestLevel1{

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