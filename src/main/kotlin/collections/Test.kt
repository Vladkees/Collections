package org.example.collections

fun main() {
//    val immutable = listOf(1,2,3,5)
//    (immutable as MutableList<Int>).add(100)
//    immutable.forEach(::println)
    val numbers = myListOf(1,2,3,4,5)
    (numbers as MyMutableList<Int>).add(100)
    numbers.forEach(::println)
}