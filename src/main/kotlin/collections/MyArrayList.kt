package org.example.collections

class MyArrayList<T>(initialCapacity:Int = INITIAL_CAPACITY) : MyMutableList<T> {

     var numbers = arrayOfNulls<Any>(initialCapacity)
    override var size: Int = 0
        private set

    override fun add(element: T):Boolean {
         growIfNeeded()
        numbers[size] = element
        size++
        return true
    }

    override fun clear() {
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T):Boolean {
        for (i in 0 until size){
            if (numbers[i] == element){
                return true
            }
        }
        return false
    }

    private fun checkIndex(index: Int){
        if(index < 0 || index >= size){
            throw IndexOutOfBoundsException("index: $index size: $size")
        }
    }
    private fun checkIndexForAdding(index: Int){
        if(index < 0 || index > size){
            throw IndexOutOfBoundsException("index: $index size: $size")
        }
    }


    override fun minus(element: T) {
        remove(element)
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return numbers[index] as T
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        System.arraycopy(numbers, index+1, numbers, index, size - index - 1)
        numbers[size] = null
        size--
    }

    override fun remove(element: T) {
        for (i in 0 until size) {
            if (numbers[i] == element) {
                removeAt(i)
            }
        }

    }
    private fun growIfNeeded(){
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Any>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, size)
            numbers = newArray
        }
    }
    override fun add(element: T, index: Int) {
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(numbers, index, numbers, index+1, size - index )
        numbers[index] = element
        size++
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T>{

            private var nextIndex = 0

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                return numbers[nextIndex++] as T
            }

        }
    }

    companion object{
        private const val INITIAL_CAPACITY = 10
    }
}