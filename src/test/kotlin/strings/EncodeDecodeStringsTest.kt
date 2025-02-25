package strings

import com.drawiin.strings.EncodeDecodeStrings
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EncodeDecodeStringsTest {
    private val encodeDecodeStrings = EncodeDecodeStrings()

    @Test
    fun `should encode and decode a list of strings correctly`() {
        val input = listOf("neet12345678910", "code", "love", "you")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle special characters in strings`() {
        val input = listOf("we", "say", ":", "yes")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle empty list`() {
        val input = listOf<String>()
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle list with empty strings`() {
        val input = listOf("", "", "")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle list with special characters`() {
        val input = listOf("#", "@", ":")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle list with numbers characters`() {
        val input = listOf("1", "2", "34567891011121314")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle single string`() {
        val input = listOf("hello")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }

    @Test
    fun `should handle strings with spaces`() {
        val input = listOf("hello world", "kotlin is fun")
        val encoded = encodeDecodeStrings.encode(input)
        val decoded = encodeDecodeStrings.decode(encoded)
        assertEquals(input, decoded)
    }
}