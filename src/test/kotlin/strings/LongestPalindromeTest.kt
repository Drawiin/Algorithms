package strings

import com.drawiin.dynamic.LongestPalindrome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestPalindromeTest {
    private val longestPalindrome get() = LongestPalindrome()

    @Test
    fun `should return a valid palindrome for input babad`() {
        assert(longestPalindrome.longestPalindrome("babad") == "bab" ||
                longestPalindrome.longestPalindrome("babad") == "aba") {
            "Expected 'bab' or 'aba', got: ${longestPalindrome.longestPalindrome("babad")}"
        }
    }

    @Test
    fun `should return bb for input cbbd`() {
        assertEquals("bb", longestPalindrome.longestPalindrome("cbbd"))
    }

    @Test
    fun `should return single character for input a`() {
        assertEquals("a", longestPalindrome.longestPalindrome("a"))
    }

    @Test
    fun `should return entire string if it is a palindrome`() {
        assertEquals("racecar", longestPalindrome.longestPalindrome("racecar"))
    }

    @Test
    fun `should return any single character for input with no repeating characters`() {
        assert(longestPalindrome.longestPalindrome("abc").length == 1) {
            "Expected a single character, got: ${longestPalindrome.longestPalindrome("abc")}"
        }
    }

    @Test
    fun `should return entire input when it is all the same character`() {
        assertEquals("a".repeat(10), longestPalindrome.longestPalindrome("a".repeat(10)))
    }
}