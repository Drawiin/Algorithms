package com.drawiin.sets

class CarCapacity(
    private val useSortedMapSolution: Boolean = true
) {
    /**
     * Determines if the car can perform all the trips without exceeding capacity.
     *
     * @param trips List of trips, each trip is represented as [passengers, pickupKm, dropOffKm].
     * @param capacity The maximum capacity of the car.
     * @return True if the car can perform all trips, false otherwise.
     */
    fun canPerformTrips(trips: List<List<Int>>, capacity: Int): Boolean {
        return if (useSortedMapSolution) sortedMapSolution(trips, capacity) else regularMapSolution(trips, capacity)
    }

    // Thi is the solution using a sorted map to keep track of the occupation of the car the complexity is O(n*log(n))
    private fun sortedMapSolution(
        trips: List<List<Int>>,
        capacity: Int
    ): Boolean {
        var currentOccupation = 0
        val sortedTrips = sortedMapOf<Int, Int>()
        for (trip in trips) {
            val passengers = trip[0]
            val pickupKm = trip[1]
            val dropOffKm = trip[2]

            sortedTrips[pickupKm] = sortedTrips.getOrElse(pickupKm) { 0 } + passengers
            sortedTrips[dropOffKm] = sortedTrips.getOrElse(dropOffKm) { 0 } - passengers
        }
        println(sortedTrips)

        for ((_, passengers) in sortedTrips) {
            currentOccupation += passengers
            if (currentOccupation > capacity) return false
        }
        // Implement the algorithm here
        return true
    }

    // This solution we assume the max size of the map is 1000 and the values are always discrete this solution is O(n) the space complexity is O(1)
    // We could also use a list of size 1000 to keep track of the occupation of the car
    private fun regularMapSolution(
        trips: List<List<Int>>,
        capacity: Int
    ): Boolean {
        var currentOccupation = 0
        val sortedTrips = mutableMapOf<Int, Int>()
        // 1 - We iterate over the trips and keep track of the occupation of the car this will give us some sorte of histogram of the occupation of the car
        // eg. {1: 2, 2: 1, 5: -2} this means that at km 1 we have 2 passengers, at km 2 we have 1 passenger and at km 5 we have 2 passengers
        for (trip in trips) {
            val passengers = trip[0]
            val pickupKm = trip[1]
            val dropOffKm = trip[2]

            sortedTrips[pickupKm] = sortedTrips.getOrElse(pickupKm) { 0 } + passengers
            sortedTrips[dropOffKm] = sortedTrips.getOrElse(dropOffKm) { 0 } - passengers
        }
        println(sortedTrips)

        // Now we iterate over the trips and keep track of the occupation of the car
        // We need to do this is order to check if the car can handle the occupation at any point
        for (point in 0..1000) {
            currentOccupation += sortedTrips.getOrElse(point) { 0 }
            if (currentOccupation > capacity) return false
        }
        // Implement the algorithm here
        return true
    }
}
