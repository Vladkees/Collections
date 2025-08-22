package collections

import org.example.collections.NumbersArrayList
import org.example.collections.NumbersMutableList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumbersMutableListTest{
@ParameterizedTest
@MethodSource("mutableListSource")
fun `When add an 1 element then size is 1`(list: NumbersMutableList){
  list.add(0)
 assertEquals(1, list.size)
}@ParameterizedTest
@MethodSource("mutableListSource")
fun `When add 10 elements then size is 10`(list: NumbersMutableList){
  repeat(10){
   list.add(it)
  }
 assertEquals(10, list.size)
}@ParameterizedTest
@MethodSource("mutableListSource")
fun `When add 100 elements then size is 100`(list: NumbersMutableList){
  repeat(100){
   list.add(it)
  }
 assertEquals(100, list.size)
}
 @ParameterizedTest
 @MethodSource("mutableListSource")
 fun `When received element is 5th element the test is successful`(list: NumbersMutableList){
  repeat(10){
   list.add(it)
  }
 assertEquals(5, list.get(5))
}@ParameterizedTest
 @MethodSource("mutableListSource")
 fun `When received element is 50th element the test is successful`(list: NumbersMutableList){
  repeat(100){
   list.add(it)
  }
 assertEquals(50, list.get(50))
}
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreases`(list: NumbersMutableList){
        repeat(100)
        {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(99, list.size)
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun`When removed element is 50 then element at index 50 should be 51`(list: NumbersMutableList){
    repeat(100)
    {
        list.add(it)
    }
        list.removeAt(50)
        assertEquals(51,list.get(50))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun`When removed value is 50 then test successful`(list: NumbersMutableList)
    {
        repeat(100)
        {
        list.add(it)
        }
        list.remove(50)
        assertEquals(51, list.get(50))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When replaced 10 to index 9 then test is successful`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.addForIndex(8,9)
        assertEquals(8,list.get(9))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When replaced 10 to index 9 and size is 101 then test is successful`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.addForIndex(8,9)
        assertEquals(101,list.size)
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When added 10 to index 9 and the last element is 99 then test is successful`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.addForIndex(8,9)
        assertEquals(9,list.get(10))
    }
  companion object{
   @JvmStatic
  fun mutableListSource() = listOf(NumbersArrayList())
  }
 }