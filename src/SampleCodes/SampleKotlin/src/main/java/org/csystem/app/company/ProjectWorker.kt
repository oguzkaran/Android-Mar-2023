package org.csystem.app.company

open class ProjectWorker(name: String = "", citizenId: String = "", address: String = "",
                         feePerHour: Double = 0.0, hourPerDay: Int = 0, val extraFee: Double = 0.0) : Worker(name, citizenId, address, feePerHour, hourPerDay) {
    //...
}