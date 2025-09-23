package org.example.collections

class EqualsTestClass(var workerId:Int, var workerAge:Int, var workerName:String) {
    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        if(other!is EqualsTestClass) return false
        return workerId == other.workerId && workerAge == other.workerAge && workerName == other.workerName
    }
     fun printInfo():String{
       return "$workerId  $workerAge,  $workerName"
    }
    override fun hashCode(): Int {
        var result = workerId
        result = 31 * result + workerName.hashCode()
        result = 31 * result + workerAge
        return result
    }
}