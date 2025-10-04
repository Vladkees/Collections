package org.example.collections

interface MyMutableSet<T>:MyMutableCollection<T>, MySet<T> {

    override val size:Int
    override   fun add(element:T):Boolean
    override   fun remove(element:T)
    override   fun clear()
    override   fun contains(element: T):Boolean
   }