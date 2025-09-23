package org.example.collections

data class Item(var value:Int) {
    override fun equals(other: Any?): Boolean {
        if(other!is Item) return false
        return value == other.value
    }
    override fun hashCode(): Int {
        return value
    }

}