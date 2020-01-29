package com.codingdojo.phonenumbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

fun solution(phone_book: Array<String>): Boolean {
    tailrec fun step(head: String, tail: List<String>): Boolean = when {
        tail.isEmpty() -> true
        tail.hasPrefix(head) -> false
        else -> step(car(tail), cdr(tail))
    }
    phone_book.sort()

    return step(car(phone_book.toList()), cdr(phone_book.toList()))
}

fun <T> car(list: List<T>) = list.first()
fun <T> cdr(list: List<T>) = list.drop(1)
fun <T: String> Collection<T>.hasPrefix(prefix: T) = any { it.startsWith(prefix) }

class SolutionTest {

    @Test
    fun `Find cases where one phone number is prefixed to another`() {
        assertThat(solution(arrayOf("119", "97674223", "1195524421"))).isEqualTo(false)
        assertThat(solution(arrayOf("123", "456", "789"))).isEqualTo(true)
        assertThat(solution(arrayOf("12", "123", "1235","567","88"))).isEqualTo(false)
    }
}
