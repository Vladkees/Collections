package org.example.collections

import kotlin.math.abs

class MyHashSet<T> : MyMutableSet<T> {

     var elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)
    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
       if(size >= elements.size * LOAD_INDEX ){
           increaseIfNeeded()
       }
        return add(element, elements).also {
            if(it){
                size++
            }
        }
    }

    private fun getElementPosition (element: T, arraySize:Int):Int{
        return abs(element.hashCode() % arraySize)
    }

    private fun add(element: T, array: Array<Node<T>?>):Boolean{
        val newElement = Node(item = element)
        val position = getElementPosition(element, array.size)
        var existedElement = array[position]
        if(existedElement == null){
            array[position] = newElement
            return true
        }else{
            while(true){
                if(existedElement?.item == element){
                    return false
                }else{
                    if (existedElement?.next == null){
                        existedElement?.next = newElement

                        return true
                    }else{
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }

    private fun increaseIfNeeded(){
        val newArray = arrayOfNulls<Node<T>>(elements.size*2)
        for(node in elements){
          var currentNode = node
            while(currentNode!=null){
                add(currentNode.item, newArray)
                currentNode = currentNode.next
            }
        }
        elements = newArray
    }

    override fun remove(element: T) {
        val position = getElementPosition(element, elements.size)
        var selectedElement = elements[position]
        while (selectedElement!=null){
        if(selectedElement.item == element) {
            val before = selectedElement.prev
            val after = selectedElement.next
            if (before == null){
                elements[position] = after
            }else{
                before.next = after
            }
            if(after != null){
                after.prev = before
            }
            return
        }else{
            selectedElement = selectedElement.next
        }
    }}


    override fun clear() {
        elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
       val position = getElementPosition(element, elements.size)
       var currentNode = elements[position]
        while (currentNode != null){
        if(currentNode.item == element){
            return true
        } else{
            currentNode = currentNode.next
        }}
        return false
    }

   data class Node<T>(
       var prev:Node<T>? = null,
        val item:T,
        var next:Node<T>? = null
    )

    companion object{
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_INDEX = 0.75
    }

}