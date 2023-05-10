package org.csystem.app.company

open class Worker(name: String = "", citizenId: String = "", address: String = "",
             var feePerHour: Double = 0.0, var hourPerDay: Int = 0) : Employee(name, citizenId, address) {
    //...
}