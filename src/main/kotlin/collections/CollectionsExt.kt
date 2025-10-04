package org.example.collections

fun<T> myListOf(vararg elements:T):MyList<T>{
    return ImmutableList(*elements)
}

private class ImmutableList<T>(vararg elements: T):MyList<T>{
    private val array = elements
    override val size: Int
        get()=array.size

    override fun iterator(): Iterator<T> {
       return array.iterator()
    }

    override fun get(index: Int): T {
        return array[index]
    }

    override fun contains(element: T): Boolean {
        return array.contains(element)
    }
}