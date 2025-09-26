package org.example.collections

fun main() {
    val numbers = MyHashSet<Int>()
    repeat(100)
    {
        numbers.add(it)
    }
//    numbers.numbers.forEach(::println)
    for(number in numbers){
        println(number)
    }
}