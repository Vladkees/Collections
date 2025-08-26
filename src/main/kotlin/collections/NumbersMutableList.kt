package org.example.collections

interface NumbersMutableList {

    val size:Int
    fun add(number:Int)
    fun add(number: Int, index: Int)
    operator fun get(index:Int):Int
    fun removeAt(index: Int)
    fun remove(number:Int)
    fun clear()
    fun contains(number: Int):Boolean
    operator fun plus(number: Int)
    operator fun minus(number: Int)
}