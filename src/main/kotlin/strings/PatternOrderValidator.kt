package com.drawiin.strings

class PatternOrderValidator {
    /**
     * Checks if the characters in the input string follow the same order as defined by the pattern.
     * @param string The input string to check.
     * @param pattern The pattern defining the required character order.
     * @return True if the string follows the pattern order, false otherwise.
     */
    fun isValidPattern(string: String, pattern: String): Boolean {
        val sequenceMap  = mutableMapOf<Char, Int>()
        pattern.forEachIndexed { index, char ->
            sequenceMap[char] = index
        }
        println("sequenceMap: $sequenceMap")
        val filteredString = string.filter { sequenceMap.containsKey(it) }

        println("filteredString: $filteredString")
        filteredString.forEachIndexed { index, currentChar ->
            // If the next is null this means we are at the end of the string
            val nextChar = filteredString.getOrNull(index + 1) ?: return@forEachIndexed

            val currentSequencePosition = sequenceMap[currentChar]!!
            val nextSequencePosition = sequenceMap[nextChar]!!

            // If the current sequence position is greater than the next sequence position, the order is invalid
            if (currentSequencePosition > nextSequencePosition) {
                println("Returning false because $currentChar is in position $currentSequencePosition and $nextChar is in position $nextSequencePosition")
                return false
            }
        }

        return true
    }
}