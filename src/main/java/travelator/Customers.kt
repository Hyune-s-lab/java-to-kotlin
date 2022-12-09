package travelator

import java.util.*

interface Customers {
    @Throws(DuplicateException::class)
    fun add(name: String, email: String): Result<Customer, DuplicateException>
    fun find(id: String): Optional<Customer>
}
