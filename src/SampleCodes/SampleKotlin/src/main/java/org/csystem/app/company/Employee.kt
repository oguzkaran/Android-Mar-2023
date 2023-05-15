package org.csystem.app.company

abstract class Employee(var name: String = "", var citizenId: String = "", var address: String = ""/*...*/) {
    abstract fun calculateInsurancePayment() : Double
    //...
}