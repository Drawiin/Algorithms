package com.drawiin.strings

/**
 * 1. Problem Statement (Simple):
 * You get:
 *   - A pattern: a string of unique characters that shows the order they must appear (left to right).
 *   - An input string: can have any characters.
 * Goal:
 *   - Ignore any character that is NOT in the pattern.
 *   - Look only at the characters that are in the pattern and check if they appear without breaking
 *     the required order. If at some point we see a character that should come earlier (in the pattern)
 *     after one that should come later, we fail.
 * Return:
 *   - true if the order is never broken.
 *   - false otherwise.
 *
 * Examples:
 *   pattern = "abc", string = "zzabxc"      -> true  (a then b then c)
 *   pattern = "abc", string = "acb"         -> false (c appears before b)
 *   pattern = "bca", string = "bbbcccaaa"   -> true  (all b's, then c's, then a's: matches b < c < a)
 *   pattern = "bca", string = "bcab"        -> false (an extra b appears after an a)
 *
 * 2. Walkthrough
 * 2.1 Naive / Brute Force (Plain Words):
 *   Think of every pair of characters in the string where the first one is to the left of the second.
 *   For each such pair:
 *     - If both characters are in the pattern, check their order.
 *     - If the left one is supposed to come AFTER the right one (according to the pattern), return false.
 *   If we finish all comparisons with no problem, return true.
 *   Why it is slow: we compare a huge number of pairs we do not really need.
 *
 * 2.2 How We Arrive at the Better Way:
 *   We do not need every pair. We only care about the sequence of pattern letters as they show up.
 *   If that sequence ever "goes backwards" (a later letter from the pattern appears before an earlier one),
 *   we can stop. So:
 *     - Pull out only the pattern characters (in the order they appear).
 *     - Walk through them once, comparing each character with the next one.
 *     - If we never move backwards in pattern order, we are good.
 *   One pass is enough because any "bad" pair would show up as a bad neighbor at some point.
 *
 * 3. Optimal Solution (Step by Step):
 *   Step 1: Give each pattern character a simple number: 0,1,2,... based on its place.
 *   Step 2: Build a filtered list of only the characters from the input that are in the pattern.
 *   Step 3: Go through that filtered list from left to right.
 *   Step 4: For each current character, look at the next one:
 *           - If the next one has a smaller number (meaning it should have appeared earlier), return false.
 *   Step 5: If we finish the loop, return true.
 *
 * 4. Pseudocode (Plain):
 *   make map: patternChar -> its position
 *   filtered = empty list
 *   for each char in input:
 *       if char in map:
 *           add to filtered
 *   for each position i in filtered except last:
 *       if map[ filtered[i] ] > map[ filtered[i+1] ]:
 *           return false
 *   return true
 *
 * Edge Cases (Simple):
 *   - Empty pattern: always true (no rules to break).
 *   - One-letter pattern: always true.
 *   - Repeated chars in string: fine if they do not create a backward jump.
 *   - Characters not in pattern: always ignore.
 *
 * Interview Hint:
 *   Start by saying: "I would first check every pair (slow), then realize I only need to scan once
 *   over the filtered pattern characters."
 */
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
