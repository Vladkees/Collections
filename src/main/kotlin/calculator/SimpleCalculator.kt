package org.example.calculator

class SimpleCalculator:Calculator {
    override fun sum(a: Int, b: Int): Int {
        return a+b
    }
    override fun difference(a:Int, b:Int):Int{
        return a-b
    }
    override fun multiplication(a:Int, b:Int):Int{
            return a*b
    }
    override fun divide(a: Int, b: Int):Double{
        return a.toDouble()/b.toDouble()
    }

}