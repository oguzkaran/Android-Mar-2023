package org.csystem.app.company

class HumanResources {
    //...
    fun payInsurance(employee: Employee)
    {
        println("Name:${employee.name}, CitizenId:${employee.citizenId}, Address:${employee.address}")
        println("Insurance Payment:${employee.calculateInsurancePayment()}")
    }
}

