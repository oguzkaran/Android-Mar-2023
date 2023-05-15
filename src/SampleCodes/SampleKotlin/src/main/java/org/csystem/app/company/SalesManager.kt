package org.csystem.app.company

open class SalesManager(name: String = "", citizenId: String = "", address: String = "",
                        department: String = "", salary: Double = 0.0, val extra: Double = 0.0) : Manager(name, citizenId, address, department, salary) {
    //...
    override fun calculateInsurancePayment() = super.calculateInsurancePayment() + extra
}