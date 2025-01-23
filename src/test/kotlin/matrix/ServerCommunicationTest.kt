package matrix

import com.drawiin.matrix.ServerCommunication
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ServerCommunicationTest {
    private val solution = ServerCommunication()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        val expected = 0
        assertEquals(expected, solution.countServers(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )
        val expected = 3
        assertEquals(expected, solution.countServers(grid))
    }

    @Test
    fun testExample3() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 1)
        )
        val expected = 4
        assertEquals(expected, solution.countServers(grid))
    }

    @Test
    fun testEdgeCase1() {
        val grid = arrayOf(
            intArrayOf(1)
        )
        val expected = 0
        assertEquals(expected, solution.countServers(grid))
    }

    @Test
    fun testEdgeCase2() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        val expected = 8
        assertEquals(expected, solution.countServers(grid))
    }
}