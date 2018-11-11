package io.github.fatimazza.footballclub.utils

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

class UtilsKtTest {

    @Test
    fun testFormatToSimpleString() {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        val date = dateFormat.parse("02/28/2018")
        // assertEqual(expected value, actual value) checks equality of two values
        assertEquals("Wed 28 Feb 2018", formatToSimpleString(date))
    }
}