package org.csystem.app.company

open class Manager(name: String = "", citizenId: String = "", address: String = "",
                   var department: String = "", var salary: Double = 0.0) : Employee(name, citizenId, address) {
    //...
}