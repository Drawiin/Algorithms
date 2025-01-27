package sets

import com.drawiin.sets.CarCapacity
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CarCapacityTest {

    private val carCapacity = CarCapacity(useSortedMapSolution = false)

    @Test
    fun testSingleTripWithinCapacity() {
        val trips = listOf(listOf(1, 2, 5))
        val capacity = 2
        assertTrue(carCapacity.canPerformTrips(trips, capacity), "The car should handle a single trip within capacity.")
    }

    @Test
    fun testSingleTripExceedsCapacity() {
        val trips = listOf(listOf(3, 2, 5))
        val capacity = 2
        assertFalse(carCapacity.canPerformTrips(trips, capacity), "The car should fail if a single trip exceeds capacity.")
    }

    @Test
    fun testMultipleTripsWithinCapacity() {
        val trips = listOf(listOf(2, 1, 5), listOf(1, 2, 6))
        val capacity = 3
        assertTrue(carCapacity.canPerformTrips(trips, capacity), "The car should handle multiple trips within capacity.")
    }

    @Test
    fun testOverlappingTripsExceedsCapacity() {
        val trips = listOf(listOf(2, 1, 5), listOf(2, 4, 6))
        val capacity = 3
        assertFalse(carCapacity.canPerformTrips(trips, capacity), "The car should fail if overlapping trips exceed capacity.")
    }

    @Test
    fun testNonOverlappingTripsWithinCapacity() {
        val trips = listOf(listOf(2, 1, 5), listOf(2, 6, 8))
        val capacity = 3
        assertTrue(carCapacity.canPerformTrips(trips, capacity), "The car should handle non-overlapping trips within capacity.")
    }

    @Test
    fun testEdgeCaseZeroCapacity() {
        val trips = listOf(listOf(1, 0, 1))
        val capacity = 0
        assertFalse(carCapacity.canPerformTrips(trips, capacity), "The car should fail if capacity is zero.")
    }
}


