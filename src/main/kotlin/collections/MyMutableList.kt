package org.example.collections

interface MyMutableList<T>:MyMutableCollection<T>, MyList<T> {

    override val size:Int
    override fun add(element:T):Boolean
    fun add(element: T, index: Int)
    override operator fun get(index:Int):T
    fun removeAt(index: Int)
    override fun remove(element:T)
    override fun clear()
    override fun contains(element: T):Boolean
    operator fun plus(element: T)
    operator fun minus(element: T)
}