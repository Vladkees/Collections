package org.example.collections

class NumbersArrayList : NumbersMutableList {
    private var numbers = arrayOfNulls<Int>(10)
    override var size: Int = 0
        private set

    override fun add(number: Int) {
         growIfNeeded()
        numbers[size] = number
        size++

    }

    override fun clear() {
        numbers = arrayOfNulls(10)
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

    override fun minus(number: Int) {
        remove(number)
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun get(index: Int): Int {
        return numbers[index]!!
    }

    override fun removeAt(index: Int) {
        for (i in index until size - 1) {
            numbers[i] = numbers[i + 1]
        }
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

            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
        }
    }
    override fun add(number: Int, index: Int) {
        growIfNeeded()
        for (i in size downTo index + 1) {
            numbers[i] = numbers[i - 1]
        }
        numbers[index] = number
        size++
    }

}