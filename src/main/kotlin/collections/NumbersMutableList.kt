package org.example.collections

interface NumbersMutableList {

    val size:Int
    fun add(number:Int)
    fun get(index:Int):Int
    fun removeAt(index: Int)
    fun remove(number:Int)
    fun addForIndex(number: Int, index: Int)
}