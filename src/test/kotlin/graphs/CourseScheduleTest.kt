package graphs

import com.drawiin.graphs.CourseSchedule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CourseScheduleTest {
    private val courseSchedule: CourseSchedule get() = CourseSchedule()

    @Test
    fun `test with no prerequisites`() {
        assertTrue(courseSchedule.canFinish(2, emptyList()))
    }

    @Test
    fun `test with valid course order`() {
        val prerequisites = listOf(Pair(1, 0))
        assertTrue(courseSchedule.canFinish(2, prerequisites))
    }

    @Test
    fun `test with circular dependency`() {
        val prerequisites = listOf(Pair(1, 0), Pair(0, 1))
        assertFalse(courseSchedule.canFinish(2, prerequisites))
    }

    @Test
    fun `test with multiple courses and valid prerequisites`() {
        val prerequisites = listOf(Pair(1, 0), Pair(2, 1), Pair(3, 2))
        assertTrue(courseSchedule.canFinish(4, prerequisites))
    }

    @Test
    fun `test with multiple courses and a cycle`() {
        val prerequisites = listOf(Pair(1, 0), Pair(2, 1), Pair(3, 2), Pair(1, 3))
        assertFalse(courseSchedule.canFinish(4, prerequisites))
    }
}