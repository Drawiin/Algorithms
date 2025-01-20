package hashmaps

import com.drawiin.hashmaps.LongestConsecutive
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestConsecutiveTest {
    private val longestConsecutive get() = LongestConsecutive()

    @Test
    fun `should return 4 for input 100,4,200,1,3,2`() {
        assertEquals(4, longestConsecutive.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }

    @Test
    fun `should return 9 for input 0,3,7,2,5,8,4,6,0,1`() {
        assertEquals(9, longestConsecutive.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    }

    @Test
    fun `should return 0 for empty input`() {
        assertEquals(0, longestConsecutive.longestConsecutive(intArrayOf()))
    }

    @Test
    fun `should return 1 for single element input`() {
        assertEquals(1, longestConsecutive.longestConsecutive(intArrayOf(42)))
    }

    @Test
    fun `should return length of array for all consecutive elements`() {
        assertEquals(5, longestConsecutive.longestConsecutive(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `should return 3 for input with duplicate elements`() {
        assertEquals(3, longestConsecutive.longestConsecutive(intArrayOf(1, 2, 2, 3)))
    }

    @Test
    fun `should return 2 for input with gaps between elements`() {
        assertEquals(2, longestConsecutive.longestConsecutive(intArrayOf(10, 30, 20, 21)))
    }
}