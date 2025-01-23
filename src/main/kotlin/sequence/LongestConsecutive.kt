package com.drawiin.hashmaps

class LongestConsecutive {
    fun longestConsecutive(numbs: IntArray): Int {
        return hashMapSolution(numbs)
    }

    // Alternative solution using set Its simples and more readable
    fun setSolution(numbs: IntArray): Int {
        var longest = 0
        val set = numbs.toSet()
        for (num in set) {
            // verify if the number is the start of a sequence
            if (!set.contains(num - 1)) {
                var next = num + 1
                // Size start at one because we this sequence has at least one element the current number
                var size = 1
                while (set.contains(next)) {
                    // Each interaction we enter the while we found one more number in the sequence
                    next++
                    size++
                }
                longest = maxOf(longest, size)
            }
        }
        return longest
    }

    private fun hashMapSolution(numbs: IntArray): Int {
        // The map will store for each number the size of the sequence it belongs to
        // Not all numbers will be in the map, only the ones that are the start of a sequence
        // Also not all numbers will have the total size of the sequence, only the start of the sequence
        // because we can get the total size by adding the previous and next numbers
        // and the numbers in the middle of the sequence will be skipped
        val sequenceSizeMap = mutableMapOf<Int, Int>()
        var largestSequenceSize = 0

        numbs.forEach { currentNumber ->
            // if the currentNumber is already in the map, we skip it because we don't need to process it again
            if (sequenceSizeMap.containsKey(currentNumber)) return@forEach

            // get the next and previous numbers in the sequence
            // e.g for 3, we get 2 and 4
            val nextNumberSequenceSize = sequenceSizeMap.getOrDefault(currentNumber + 1, 0)
            val previousNumberSequenceSize = sequenceSizeMap.getOrDefault(currentNumber - 1, 0)
            // the total  is the sum of the previous and next numbers plus the current number sequence size aka 1
            val currentNumberSequenceSize = previousNumberSequenceSize + nextNumberSequenceSize + 1

            // Update the largest sequence size if the current sequence is larger
            if (currentNumberSequenceSize > largestSequenceSize) {
                largestSequenceSize = currentNumberSequenceSize
            }

            // update the map with the current number and the sequence size
            sequenceSizeMap[currentNumber] = currentNumberSequenceSize
            val sequenceStart = currentNumber - previousNumberSequenceSize
            val sequenceEnd = currentNumber + nextNumberSequenceSize
            // update the map with the start and end of the sequence
            if (sequenceSizeMap.containsKey(sequenceStart)) sequenceSizeMap[sequenceStart] = currentNumberSequenceSize
            if (sequenceSizeMap.containsKey(sequenceEnd)) sequenceSizeMap[sequenceEnd] = currentNumberSequenceSize


        }
        return largestSequenceSize
    }
}