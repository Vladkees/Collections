package org.example.collections

interface MyMap<K,V> {

    operator fun get(key: K): V?
    fun containsKey(key: K): Boolean
    fun containsValue(value: V): Boolean
    val keys: MySet <K>
    val values: MyCollection <V>
}