package org.example.collections

class MyLinkedList<T> : MyMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    override var size: Int = 0
        private set
    override fun add(element: T):Boolean {
        val prevLast = last
        last = Node(item = element, prev = prevLast)
        if(prevLast == null){
            first = last
        }else{
            prevLast.next = last
        }
            size++
        return true
    }

    override fun add(element: T, index: Int) {
        checkIndexForAdding(index)
        if(index == size){
            add(element)
            return
        }
        if(index == 0){
            val node = Node(null, element, first)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index-1)
        val after = before.next
        val newNode = Node(before, element, after)
        before.next = newNode
        after?.prev = newNode
        size++
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return getNode(index).item
    }

    private fun getNode(index:Int):Node<T>{
        checkIndex(index)
        if(index == 0)return first!!
        if(index == size-1) return last!!

        if (index < size/2)
        {

            var node = first
            repeat(index){
                node = node?.next
            }
            return node!!
        }else{
            var node = last
            repeat(size - 1 - index){
                node = node?.prev
            }
            return node!!
        }

    }

    private fun unlink(node: Node<T>){
        val before = node.prev
        val after = node.next
        before?.next = after
        after?.prev = before
        if(after == null){
            last = before
        }
        if(before == null){
            first = after
        }
        size--
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
    }

    override fun remove(element: T) {
       var node = first
        repeat(size){
            if(node?.item == element){
            node?.let { unlink(it) }
                return
                }
            else{
                node = node?.next
            }
        }
    }

    override fun clear() {
        first = null
        last = null
        size = 0
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


    override fun contains(element: T): Boolean {
       var node = first
        repeat(size){
            if(node?.item == element){
                return true
            }else node = node?.next
        }
        return false
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T>{
            var current = first
            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): T {
                return current?.item!!.also {
                    current = current!!.next
                }

            }
        }


    }

   class Node<T>(var prev: Node<T>? = null, val item:T, var next: Node<T>? = null )

}