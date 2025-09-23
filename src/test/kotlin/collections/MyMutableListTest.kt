package collections

import org.example.collections.Item
import org.example.collections.MyArrayList
import org.example.collections.MyLinkedList
import org.example.collections.MyMutableList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MyMutableListTest{
@ParameterizedTest
@MethodSource("mutableListSource")
fun `When add an 1 element then size is 1`(list: MyMutableList<Item>){
  list.add(Item(0))
      assertEquals(1, list.size)
}@ParameterizedTest
@MethodSource("mutableListSource")
fun `When add 10 elements then size is 10`(list: MyMutableList<Item>){
  repeat(10){
   list.add(Item(it))
  }
 assertEquals(10, list.size)
}@ParameterizedTest
@MethodSource("mutableListSource")
fun `When add 100 elements then size is 100`(list: MyMutableList<Item>){
  repeat(100){
   list.add(Item(it))
  }
 assertEquals(100, list.size)
}
 @ParameterizedTest
 @MethodSource("mutableListSource")
 fun `When received element is 5th element the test is successful`(list: MyMutableList<Item>){
  repeat(10){
   list+Item(it)
  }
 assertEquals(5, list[5])
}@ParameterizedTest
 @MethodSource("mutableListSource")
 fun `When received element is 50th element the test is successful`(list: MyMutableList<Item>){
  repeat(100){
   list.add(Item(it))
  }
 assertEquals(50, list.get(50))
}
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreases`(list: MyMutableList<Item>){
        repeat(100)
        {
            list.add(Item(it))
        }
        list.removeAt(50)
        assertEquals(99, list.size)
    }@ParameterizedTest
    @MethodSource("mutableListSource")
    fun `If array cleared then test is successful`(list: MyMutableList<Item>){
        repeat(100)
        {
            list+Item(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun`When removed element is 50 then element at index 50 should be 51`(list: MyMutableList<Item>){
    repeat(100)
    {
        list.add(Item(it))
    }
        list.removeAt(50)
        assertEquals(51,list.get(50))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun`When removed value is 50 then test successful`(list: MyMutableList<Item>)
    {
        repeat(100)
        {
        list.add(Item(it))
        }
        list-Item(50)
        assertEquals(51, list[50])
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When replaced 10 to index 9 then test is successful`(list: MyMutableList<Item>) {
        repeat(100) {
            list.add(Item(it))
        }
        list.add(Item(8,),9)
        assertEquals(8,list.get(9))
    }@ParameterizedTest
    @MethodSource("mutableListSource")
    fun `If array contains 52 then test is successful`(list: MyMutableList<Item>) {
        repeat(100) {
            list+Item(it)
        }

        assertEquals(true,list.contains(Item(52)))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When replaced 10 to index 9 and size is 101 then test is successful`(list: MyMutableList<Item>) {
        repeat(100) {
            list.add(Item(it))
        }
        list.add(Item(8), 8)
        assertEquals(101,list.size)
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When putted 10 to index 9 and the last element is 100 then test is successful`(list: MyMutableList<Item>) {
        repeat(100) {
            list.add(Item(it))
        }
        list.add(Item(10),9)
        assertEquals(99,list.get(100))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun`When after adding number 6 at position 5 the 11th element is 9 then test successful`(list: MyMutableList<Item>){
        repeat(10){
            list.add(Item(it))
        }
        list.add(Item(6),5)
        assertEquals(9,list.get(10))
    }
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun`when get receive the wrong index then program throw error`(list: MyMutableList<Item>){
        repeat(10){
            list.add(Item(it))
        }
        assertThrows<IndexOutOfBoundsException> { list[10] }
    }
  companion object{
   @JvmStatic
  fun mutableListSource() = listOf(MyArrayList<Item>(), MyLinkedList<Item>())
  }
 }