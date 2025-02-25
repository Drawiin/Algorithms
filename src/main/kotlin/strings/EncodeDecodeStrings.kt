package com.drawiin.strings

private const val SEPARATOR = '#'

class EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    fun encode(strings: List<String>): String {
        val encoded = StringBuilder()
        strings.forEach { str ->
            encoded.append("${str.length}$SEPARATOR$str")
        }
        println("Encoded string: $encoded")
        return encoded.toString()
    }

    // Decodes a single string to a list of strings.
    fun decode(encoded: String): List<String> {
        val decoded = mutableListOf<String>()
        var charIndex = 0
        while (charIndex < encoded.length) {
            // We always start at the beginning of a new encoded string(word length + delimiter + world)
            var delimiterIndex = charIndex
            // Find the delimiter
            while (encoded[delimiterIndex] != SEPARATOR) {
                delimiterIndex++
            }
            // Once we find the delimiter we know that all the previous chars refer to this particular world length
            val length = encoded.substring(charIndex, delimiterIndex).toInt()

            // Remember were in the delimiter, so we need to move to the next char(a.k.a the start of the word)
            val wordBeginIndex = delimiterIndex + 1

            // Now since the char index is at the start of the word, we can just add the length to it to get the end of the word
            decoded.add(encoded.substring(wordBeginIndex, wordBeginIndex + length))

            // Now that we get the world, we need to move the char index to the next word
            // We do this by adding the length of the word to the char index
            // This way we skip this world and go to the next encoded world or the end of the string
            charIndex = wordBeginIndex + length
        }
        return decoded
    }
}