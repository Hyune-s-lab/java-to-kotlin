package travelator.marketing

import java.io.IOException
import java.io.Reader
import java.io.Writer
import java.util.*

private val CustomerData.outputLine: String
    get() = "$id\t$marketingName\t${spend.toMoneyString()}"

private fun Double.toMoneyString() = this.formattedAs("%#.2f")
private fun Any?.formattedAs(format: String) = String.format(format, this)

private val CustomerData.marketingName: String
    get() = "${familyName.uppercase(Locale.getDefault())}, $givenName"

private fun List<String>.withoutHeader() = drop(1)
private fun List<String>.toValuableCustomers() = withoutHeader()
    .map { it.toCustomerData() }
    .filter { it.score >= 10 }

private fun List<CustomerData>.summarised(): String {
    return sumOf { it.spend }.let {
        "\tTOTAL\t${it.toMoneyString()}"
    }
}

fun String.toCustomerData() = split("\t").let { parts ->
    CustomerData(
        id = parts[0],
        givenName = parts[1],
        familyName = parts[2],
        score = parts[3].toInt(),
        spend = if (parts.size == 4) 0.0 else parts[4].toDouble()
    )
}

@Throws(IOException::class)
fun generate(reader: Reader, writer: Writer) {
    val valuableCustomers = reader.readLines()
        .toValuableCustomers()
        .sortedBy(CustomerData::score)
    writer.appendLine("ID\tName\tSpend")
    for (customerData in valuableCustomers) {
        writer.appendLine(customerData.outputLine)
    }
    writer.append(valuableCustomers.summarised())
}
