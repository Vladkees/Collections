package org.example.collections

class NumbersArrayList(initialCapacity:Int = INITIAL_CAPACITY) : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(initialCapacity)
    override var size: Int = 0
        private set

    override fun add(number: Int) {
         growIfNeeded()
        numbers[size] = number
        size++

    }

    override fun clear() {
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int):Boolean {
        for (i in 0 until size){
            if (numbers[i] == number){
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


    override fun minus(number: Int) {
        remove(number)
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return numbers[index]!!
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        System.arraycopy(numbers, index+1, numbers, index, size - index - 1)
        numbers[size] = null
        size--
    }

    override fun remove(number: Int) {
        for (i in 0 until size) {
            if (numbers[i] == number) {
                removeAt(i)
            }
        }

    }
    private fun growIfNeeded(){
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, size)
            numbers = newArray
        }
    }
    override fun add(number: Int, index: Int) {
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(numbers, index, numbers, index+1, size - index )
        numbers[index] = number
        size++
    }
    companion object{
        private const val INITIAL_CAPACITY = 10
    }
}