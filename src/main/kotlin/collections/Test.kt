package org.example.collections

fun main() {
    val numbers = MyHashSet<Int>()
    repeat(265)
    {
        numbers.add(it)
    }
    numbers.elements.forEach(::println)
}