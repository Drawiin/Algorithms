package kelements

import com.drawiin.kelements.TopKElementsFrequency
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TopKElementsFrequencyTest {
    private val solution = TopKElementsFrequency()

    @Test
    fun `should return 1,2 for input 1,1,1,2,2,3 with k=2`() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val k = 2
        val result = solution.topKFrequent(nums, k)
        assertArrayEquals(intArrayOf(1, 2), result.sortedArray())
    }

    @Test
    fun `should return 1 for input 1 with k=1`() {
        val nums = intArrayOf(1)
        val k = 1
        val result = solution.topKFrequent(nums, k)
        assertArrayEquals(intArrayOf(1), result)
    }

    @Test
    fun `should return 1,2,3 for input 1,1,2,2,3,3 with k=3`() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 3)
        val k = 3
        val result = solution.topKFrequent(nums, k)
        println(result.toList())
        assertArrayEquals(intArrayOf(1, 2, 3), result.sortedArray())
    }

    @Test
    fun `should return 2,1 for input 1,1,2,2,2 with k=2`() {
        val nums = intArrayOf(1, 1, 2, 2, 2)
        val k = 2
        val result = solution.topKFrequent(nums, k)
        assertArrayEquals(intArrayOf(1, 2), result.sortedArray())
    }

    @Test
    fun `should return 0 for input 0,0,0,0 with k=1`() {
        val nums = intArrayOf(0, 0, 0, 0)
        val k = 1
        val result = solution.topKFrequent(nums, k)
        assertArrayEquals(intArrayOf(0), result)
    }

    @Test
    fun `should return -1,2 for input -1,-1,2,2,2 with k=2`() {
        val nums = intArrayOf(-1, -1, 2, 2, 2)
        val k = 2
        val result = solution.topKFrequent(nums, k)
        assertArrayEquals(intArrayOf(-1, 2), result.sortedArray())
    }

    @Test
    fun `should handle large input size within constraints`() {
        val nums = IntArray(100000) { it % 100 } // Large array with 100 unique elements
        val k = 10
        val result = solution.topKFrequent(nums, k)
        println(result.toList())
        assertEquals(k, result.size)
    }
}