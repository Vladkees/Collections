package org.example.collections
fun main(){
//    val worker = EqualsTestClass(1, 23, "Biba")
//    val worker2 = EqualsTestClass(1, 23, "Boba")
//    val workersSet = setOf(worker,worker2)
//    for(employee in workersSet){
//       println(employee.printInfo())
//        println(employee.hashCode())
//    }
//    println(worker.hashCode())
//    println(worker2.hashCode())
//    println(worker==worker2)
    val numbers = MyHashSet<Item>()
    val item = Item(10)
    numbers.add(item)
    println(numbers.contains(item))
    numbers.elements.forEach ( ::println )
    item.value = 5
    println(numbers.contains(item))
    numbers.elements.forEach ( ::println )
}
