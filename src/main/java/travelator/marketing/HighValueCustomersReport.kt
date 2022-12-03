package travelator.marketing

import java.io.BufferedReader
import java.io.IOException
import java.io.Reader
import java.io.Writer
import java.util.*
import java.util.stream.Collectors

object HighValueCustomersReport {
    @JvmStatic
    @Throws(IOException::class)
    fun generate(reader: Reader?, writer: Writer) {
        val valuableCustomers = BufferedReader(reader).lines()
            .skip(1) // header
            .map { line: String -> customerDataFrom(line) }
            .filter { (_, _, _, score): CustomerData -> score >= 10 }
            .sorted(Comparator.comparing { (_, _, _, score): CustomerData -> score })
            .collect(Collectors.toList())
        writer.append("ID\tName\tSpend\n")
        for (customerData in valuableCustomers) {
            writer.append(lineFor(customerData)).append("\n")
        }
        writer.append(summaryFor(valuableCustomers))
    }

    private fun summaryFor(valuableCustomers: List<CustomerData>): String {
        val total = valuableCustomers.stream()
            .mapToDouble { (_, _, _, _, spend): CustomerData -> spend }
            .sum()
        return "\tTOTAL\t" + total.toMoneyString()
    }

    @JvmStatic
    fun customerDataFrom(line: String): CustomerData {
        val parts = line.split("\t").toTypedArray()
        val spend: Double = if (parts.size == 4) 0.0 else parts[4].toDouble()
        return CustomerData(
            parts[0],
            parts[1],
            parts[2], parts[3].toInt(),
            spend
        )
    }

    private fun lineFor(customer: CustomerData): String {
        return "${customer.id}\t${customer.marketingName}\t${customer.spend.toMoneyString()}"
    }

    private fun Double.toMoneyString(): String = String.format("%#.2f", this)

    private val CustomerData.marketingName: String
        get() = "${familyName.uppercase(Locale.getDefault())}, $givenName"
}
