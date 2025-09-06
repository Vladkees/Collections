package org.example.collections

class NumbersLinkedList : NumbersMutableList {

    private var first: Node? = null
    private var last: Node? = null
    override var size: Int = 0
        private set
    override fun add(number: Int) {
        if(size == 0){
            val node = Node(number)
            first = node
            last = node
            size++
            return
        }
        val newElement = Node(number)
        last?.next = newElement
        last = newElement
        size++
    }

    override fun add(number: Int, index: Int) {
        checkIndexForAdding(index)
        if(index == size){
            add(number)
            return
        }
        if(index == 0){
            val node = Node(index, first)
            first = node
            size++
            return
        }
        val before = getNode(index-1)
        val after = before.next
        val newNode = Node(number, after)
        before.next = newNode
        size++
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return getNode(index).item
    }

    private fun getNode(index:Int):Node{
        checkIndex(index)
        if(index == 0)return first!!
        if(index == size-1) return last!!

        var node = first
        repeat(index){
            node = node?.next
        }
        return node!!
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        if(first == last){
           clear()
            return
        }
        if (index == 0)
        {
            first = first?.next
            size--
            return
        }
        val before = getNode(index -1)
        val after = before.next?.next
        before.next = after

        if(after==null){
            last = before
        }
        size--
    }

    override fun remove(number: Int) {
        if(first?.item == number){
            removeAt(0)
            return
        }
        var before = first
        repeat(size){
            val node = before?.next
            if(node?.item == number){
                val after = node.next
                before?.next = after
                if(after == null){
                    last = before
                }
                size--
                return
            }else{
                before = before?.next
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


    override fun contains(number: Int): Boolean {
       var node = first
        repeat(size){
            if(node?.item == number){
                return true
            }else node = node?.next
        }
        return false
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun minus(number: Int) {
        remove(number)
    }

    class Node(val item:Int, var next: Node? = null)

}