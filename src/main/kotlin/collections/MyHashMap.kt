package org.example.collections

import kotlin.math.abs

class MyHashMap<K, V> : MyMutableMap<K, V>{

    var elements = arrayOfNulls<Node<K, V>>(INITIAL_CAPACITY)
    private var modCount = 0
     override var size: Int = 0
        private set

    override fun put(key: K, value: V): V? {
        modCount++
         if(size >= elements.size * LOAD_INDEX ){
            increaseIfNeeded()
        }
        return put(key, value, elements).also {
            if(it == null){
                size++
            }
        }
    }

    private fun put (key: K, value: V, array: Array<Node<K,V>?>):V?{
        modCount++
         val newElement = Node(key, value)
        val position = getElementPosition(key, array.size)
        var existedElement = array[position]
        if(existedElement == null){
            array[position] = newElement
            return null
        }else{
            while(true){
                if(existedElement?.key == key){
                    return existedElement?.value.also {
                        existedElement?.value = value
                    }
                }else{
                    if (existedElement?.next == null){
                        existedElement?.next = newElement
                        return null
                    }else{
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }


    private fun getElementPosition (key: K, arraySize:Int):Int{
        return abs(key.hashCode() % arraySize)
    }


    private fun increaseIfNeeded(){
        val newArray = arrayOfNulls<Node<K, V>>(elements.size*2)
        for(node in elements){
            var currentNode = node
            while(currentNode!=null){
                put(currentNode.key, currentNode.value, newArray)
                currentNode = currentNode.next
            }
        }
        elements = newArray
    }

    override fun remove(key: K):V? {
        modCount++
        val position = getElementPosition(key, elements.size)
        val existedElement = elements[position] ?: return null
        if (existedElement.key == key) {
            elements[position] = existedElement.next
            size--
            return existedElement.value
        }
        var before: Node<K, V>? = existedElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.key == key) {
                before.next = removingElement?.next
                size--
                return removingElement?.value
            }else{
                before = before.next
            }
        }
        return null
    }


    override fun clear() {
        modCount++
        elements = arrayOfNulls<Node<K,V>>(INITIAL_CAPACITY)
        size = 0
    }

    override fun get(key: K): V? {
        val position = getElementPosition(key, elements.size)
        var currentNode = elements[position]
        while (currentNode != null){
            if(currentNode.key == key){
                return currentNode.value
            } else{
                currentNode = currentNode.next
            }}
        return null
    }

    override fun containsKey(key: K): Boolean {
        val position = getElementPosition(key, elements.size)
        var currentNode = elements[position]
        while (currentNode != null){
            if(currentNode.key == key){
                return true
            } else{
                currentNode = currentNode.next
            }}
        return false
    }

    override fun containsValue(value: V): Boolean {
        foreach {
            if(it.value == value) return true
        }
        return false
    }

    override val keys: MySet<K>
        get() = MyHashSet<K>().apply {
            foreach {
                add(it.key)
            }
        }

    override val values: MyCollection<V>
        get() = MyArrayList<V>().apply{
            foreach {
                add(it.value)
            }
        }

    private inline fun foreach(operation: (Node<K,V>) -> Unit){
            for(node in elements){
                var currentElement = node
                while (currentElement!=null){
                    operation(currentElement)
                    currentElement = node?.next
                }
            }
    }

     fun iterator(): MutableIterator<K> {
        return object : MutableIterator<K>{
            var bucketIndex = 0
            var nextNode:Node<K, V>? = elements[bucketIndex]
            var nextIndex = 0
            private var currentModCount = modCount
            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): K {
                if(currentModCount != modCount)throw ConcurrentModificationException()
                while (nextNode==null){
                    nextNode = elements[++bucketIndex]
                }
                return nextNode?.key!!.also {
                    nextIndex++
                    nextNode = nextNode?.next
                }
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    data class Node<K, V>(
        val key:K,
        var value:V,
        var next:Node<K, V>? = null
    )



    companion object{
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_INDEX = 0.75
    }
}