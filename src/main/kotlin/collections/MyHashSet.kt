package org.example.collections

import kotlin.math.abs

class MyHashSet<T> : MyMutableSet<T> {


    private val myMap = MyHashMap<T, Any>()
    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
      return myMap.put(element, PRESENT) == null
    }

    private fun getElementPosition (element: T, arraySize:Int):Int{
        return abs(element.hashCode() % arraySize)
    }

    override fun remove(element: T) {
        myMap.remove(element)
    }


    override fun clear() {
        myMap.clear()
    }

    override fun contains(element: T): Boolean {
      return myMap.containsKey(element)
    }

    override fun iterator(): MutableIterator<T> {
       return myMap.iterator()
    }

    companion object{
        private val PRESENT = Any()
    }

}