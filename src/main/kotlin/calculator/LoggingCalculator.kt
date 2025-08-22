package org.example.calculator

class LoggingCalculator:Calculator {

        override fun sum(a: Int, b: Int): Int {
            val result = a+b
            println("operation: sum $a + $b, result: $result")
            return result
        }
        override fun difference(a:Int, b:Int):Int{
            val result = a-b
            println("operation: diff $a - $b, result: $result")
            return result
        }
        override fun multiplication(a:Int, b:Int):Int{
            val result = a*b
            println("operation: mult $a * $b, result: $result")
            return result
        }
        override fun divide(a: Int, b: Int):Double{
            val result = a.toDouble()/b
            println("operation: divide $a / $b, result: $result")
            return result
        }

    }