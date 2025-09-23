package collections

import org.example.collections.Item
import org.example.collections.MyHashSet
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MyHashSetTest {
 val numbersList = MyHashSet<Item>()
@Test
 fun add()   {}

@Test
 fun `If after removing element with number 1 the index 1 returns null then test is successful`() {

  repeat(15){
   numbersList.add(Item(it))
  }
 numbersList.remove(Item(1))
 assertEquals(false, numbersList.contains(Item(1)))
 }

@Test
 fun `if after clearing the array size is 0 then test is successful`() {


 repeat(20){
  numbersList.add(Item(it))
 }
  numbersList.clear()
  assertEquals(0, numbersList.size)
 }@Test
 fun `if after clearing the array  doesn't contain the element with index 1 then test is successful`() {

  repeat(20){
   numbersList.add(Item(it))
  }
  numbersList.clear()
  assertEquals(false, numbersList.contains(Item(1)))
 }

@Test
 fun `if array contains 15 then test is successful`() {

    repeat(20){
     numbersList.add(Item(it))
    }
  assertEquals(true, numbersList.contains(Item(15)))
 }@Test
 fun `if array doesn't contain 21 then test is successful`() {

    repeat(20){
     numbersList.add(Item(it))
    }
  assertEquals(false, numbersList.contains(Item(21)) )
 }

}

