package org.example.collections

interface MyMutableList<T> {

    val size:Int
    fun add(element:T)
    fun add(element: T, index: Int)
    operator fun get(index:Int):T
    fun removeAt(index: Int)
    fun remove(element:T)
    fun clear()
    fun contains(element: T):Boolean
    operator fun plus(element: T)
    operator fun minus(element: T)
}