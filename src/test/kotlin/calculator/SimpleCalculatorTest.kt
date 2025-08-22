package calculator

import org.example.calculator.Calculator
import org.example.calculator.LoggingCalculator
import org.example.calculator.SimpleCalculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SimpleCalculatorTest{
  @ParameterizedTest
  @MethodSource("calculatorsSource")
  fun `Add 5 to 10 and expect 15`(aboba:Calculator)
  {
   val result = aboba.sum(10,5)
   val expected = 15
   assertEquals(expected, result)
  }
    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `Add 50 to 100 and expect 150`(aboba:Calculator)
    {
        val result = aboba.sum(100,50)
        val expected = 150
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `Test difference`(aboba:Calculator){
        val result = aboba.difference(10,5)
        val exception = 5
        assertEquals(exception, result)
    }
    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `Test multiplication`(aboba:Calculator){
        val result = aboba.multiplication(10,5)
        val exception = 50
        assertEquals(exception, result)
    }
    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `Test division`(aboba:Calculator){
        val result = aboba.divide(10,5)
        val exception = 2.0
        assertEquals(exception, result)
    }
    companion object{
        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalculator(), LoggingCalculator())
    }

 }