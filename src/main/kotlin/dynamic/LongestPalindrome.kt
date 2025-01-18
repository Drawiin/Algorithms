package com.drawiin.dynamic

class LongestPalindrome {
    fun longestPalindrome(string: String): String {
        var longestPalindrome = ""
        var longestSize = 0

        // We loop through the string to check the palindrome
        string.forEachIndexed { currentCharIndex, _ ->
            var startCharIndex = currentCharIndex
            var endCharIndex = currentCharIndex

            while (startCharIndex >= 0 && endCharIndex < string.length) {
                val startChar = string[startCharIndex]
                val endChar = string[endCharIndex]
                println("comparing: $startChar and $endChar")
                if (startChar == endChar) {
                    val currentPalindromeSize = endCharIndex - startCharIndex + 1
                    println("currentPalindromeSize: $currentPalindromeSize")
                    if (currentPalindromeSize > longestSize) {
                        longestSize = currentPalindromeSize
                        longestPalindrome = string.substring(startCharIndex, endCharIndex + 1)
                        println("longestPalindrome: $longestPalindrome")
                    }
                }
                startCharIndex--
                endCharIndex++
            }


            var startCharEvenIndex = currentCharIndex
            var endCharEvenIndex = currentCharIndex + 1

            while (startCharEvenIndex >= 0 && endCharEvenIndex < string.length) {
                val startChar = string[startCharEvenIndex]
                val endChar = string[endCharEvenIndex]
                println("comparing: $startChar and $endChar")
                if (startChar == endChar) {
                    val currentPalindromeSize = endCharEvenIndex - startCharEvenIndex + 1
                    println("currentPalindromeSize: $currentPalindromeSize")
                    if (currentPalindromeSize > longestSize) {
                        longestSize = currentPalindromeSize
                        longestPalindrome = string.substring(startCharEvenIndex, endCharEvenIndex + 1)
                        println("longestPalindrome: $longestPalindrome")
                    }
                }
                startCharEvenIndex--
                endCharEvenIndex++
            }
        }


        return longestPalindrome
    }
}