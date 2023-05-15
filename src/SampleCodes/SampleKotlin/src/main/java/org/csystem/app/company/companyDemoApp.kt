package org.csystem.app.company

private fun getWorker() = Worker("Ali", "12345678912", "Geyikli", 400.0, 7)
private fun getManager() = Manager("Veli", "12345678914", "Silivri", "Pazarlama", 50000.0)
private fun getSalesManager() = SalesManager("Fatma", "12345678916", "Mecidiyeköy", "Pazarlama", 50000.0, 10000.0)
private fun getProjectWorker() = ProjectWorker("Selami", "12345678918", "Şişli", 400.0, 7, 13000.89)

fun main() = runApplication()

fun runApplication()
{
    val hr = HumanResources()
    val worker = getWorker()
    val manager = getManager()
    val salesManager = getSalesManager()
    val projectWorker = getProjectWorker()

    hr.payInsurance(worker)
    hr.payInsurance(manager)
    hr.payInsurance(projectWorker)
    hr.payInsurance(salesManager)
}