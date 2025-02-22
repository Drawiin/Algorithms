package com.drawiin.kelements

class TopKElementsFrequency {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyArray = Array(nums.size + 1) { mutableListOf<Int>() }
        val frequencyMap = mutableMapOf<Int, Int>()
        /**
         * Time complexity: O(n)
         * Space complexity: O(n)
         * Turn the number in to a frequency map
         */
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        for((number, frequency) in frequencyMap) {
           frequencyArray[frequency].apply { add(number) }
        }


        val solution = frequencyArray.filter { it.isNotEmpty() }.flatten().takeLast(k)

        return solution.toIntArray()
    }
}