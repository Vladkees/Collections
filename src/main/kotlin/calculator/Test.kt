package org.example.calculator

fun main(){
    val calculator = SimpleCalculator()
    val result1 = calculator.sum(10, 5)
    println(result1)
    val result2 = calculator.sum(100, 50)
    println(result2)
}