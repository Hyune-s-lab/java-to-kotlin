package travelator

import travelator.handlers.RegistrationData

class CustomerRegistration(
    private val customers: Customers,
    private val exclusionList: ExclusionList
) : IRegisterCustomers {
    @Throws(ExcludedException::class, DuplicateException::class)
    override fun register(data: RegistrationData): Customer {
        return when {
            exclusionList.exclude(data) -> throw ExcludedException()
            else -> customers.addToo(data.name, data.email).orThrow()
        }
    }
}
