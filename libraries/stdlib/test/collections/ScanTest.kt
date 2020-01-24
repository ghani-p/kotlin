/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package test.collections

import kotlin.test.Test
import kotlin.test.assertEquals

class ScanTest {
    @Test
    fun scan() {
        val expected = listOf("", "0", "01", "012", "0123")

        assertEquals(expected, listOf(0, 1, 2, 3).scan("") { acc, e -> acc + e })               // Iterable
        assertEquals(expected, sequenceOf(0, 1, 2, 3).scan("") { acc, e -> acc + e }.toList())  // Sequence
        assertEquals(expected, "0123".scan("") { acc, e -> acc + e })                           // CharSequence
        assertEquals(expected, arrayOf(0, 1, 2, 3).scan("") { acc, e -> acc + e })              // Array<T>

        // Primitive Arrays
        assertEquals(expected, byteArrayOf(0, 1, 2, 3).scan("") { acc, e -> acc + e })
        assertEquals(expected, charArrayOf('0', '1', '2', '3').scan("") { acc, e -> acc + e })
        assertEquals(expected, shortArrayOf(0, 1, 2, 3).scan("") { acc, e -> acc + e })
        assertEquals(expected, intArrayOf(0, 1, 2, 3).scan("") { acc, e -> acc + e })
        assertEquals(expected, longArrayOf(0, 1, 2, 3).scan("") { acc, e -> acc + e })
        assertEquals(expected, floatArrayOf(0.0f, 1.0f, 2.0f, 3.0f).scan("") { acc, e -> acc + e.toInt() })
        assertEquals(expected, doubleArrayOf(0.0, 1.0, 2.0, 3.0).scan("") { acc, e -> acc + e.toInt() })

        // Unsigned Arrays
        assertEquals(expected, ubyteArrayOf(0u, 1u, 2u, 3u).scan("") { acc, e -> acc + e })
        assertEquals(expected, ushortArrayOf(0u, 1u, 2u, 3u).scan("") { acc, e -> acc + e })
        assertEquals(expected, uintArrayOf(0u, 1u, 2u, 3u).scan("") { acc, e -> acc + e })
        assertEquals(expected, ulongArrayOf(0u, 1u, 2u, 3u).scan("") { acc, e -> acc + e })
    }

    @Test
    fun scanIndexed() {
        val expectedList = listOf("", "[0: 0]", "[0: 0][1: 1]", "[0: 0][1: 1][2: 2]", "[0: 0][1: 1][2: 2][3: 3]")

        assertEquals(expectedList, listOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })           // Iterable
        assertEquals(expectedList, sequenceOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" }.toList())   // Sequence
        assertEquals(expectedList, "0123".scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })                       // CharSequence
        assertEquals(expectedList, arrayOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })          // Array<T>

        // Primitive Arrays
        assertEquals(expectedList, byteArrayOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, charArrayOf('0', '1', '2', '3').scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, shortArrayOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, intArrayOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, longArrayOf(0, 1, 2, 3).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, floatArrayOf(0.0f, 1.0f, 2.0f, 3.0f).scanIndexed("") { index, acc, e -> "$acc[$index: ${e.toInt()}]" })
        assertEquals(expectedList, doubleArrayOf(0.0, 1.0, 2.0, 3.0).scanIndexed("") { index, acc, e -> "$acc[$index: ${e.toInt()}]" })

        // Unsigned Arrays
        assertEquals(expectedList, ubyteArrayOf(0u, 1u, 2u, 3u).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, ushortArrayOf(0u, 1u, 2u, 3u).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, uintArrayOf(0u, 1u, 2u, 3u).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
        assertEquals(expectedList, ulongArrayOf(0u, 1u, 2u, 3u).scanIndexed("") { index, acc, e -> "$acc[$index: $e]" })
    }
}

