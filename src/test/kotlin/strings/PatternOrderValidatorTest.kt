package strings

import com.drawiin.strings.PatternOrderValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PatternOrderValidatorTest {
    private val validator = PatternOrderValidator()

    @Test
    fun `test valid pattern abcd`() {
        val result = validator.isValidPattern("axubbbxcwwd", "abcd")
        assertEquals(true, result)
    }

    @Test
    fun `test invalid pattern abcd`() {
        val result = validator.isValidPattern("axubbxcxbxd", "abcd")
        assertEquals(false, result)
    }

    @Test
    fun `test valid pattern er`() {
        val result = validator.isValidPattern("engineers rock", "er")
        assertEquals(true, result)
    }

    @Test
    fun `test invalid pattern egr`() {
        val result = validator.isValidPattern("engineers rock", "egr")
        assertEquals(false, result)
    }

    @Test
    fun `test invalid pattern gsr`() {
        val result = validator.isValidPattern("engineers rock", "gsr")
        assertEquals(false, result)
    }

    @Test
    fun `test valid pattern pmg`() {
        val result = validator.isValidPattern("programming", "pmg")
        assertEquals(false, result)
    }

    @Test
    fun `test valid pattern hlo`() {
        val result = validator.isValidPattern("hello world", "hlo")
        assertEquals(false, result)
    }

    @Test
    fun `test invalid pattern lho`() {
        val result = validator.isValidPattern("hello world", "lho")
        assertEquals(false, result)
    }

    @Test
    fun `test empty string with pattern`() {
        val result = validator.isValidPattern("", "abc")
        assertEquals(true, result)
    }

    @Test
    fun `test non-empty string with empty pattern`() {
        val result = validator.isValidPattern("abcdef", "")
        assertEquals(true, result)
    }

    @Test
    fun `test invalid pattern character g`() {
        val result = validator.isValidPattern("abcdef", "g")
        assertEquals(true, result)
    }
}