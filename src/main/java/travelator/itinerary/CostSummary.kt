package travelator.itinerary

import travelator.money.CurrencyConversion
import travelator.money.Money
import travelator.money.Money.Companion.of
import java.util.*

class CostSummary(userCurrency: Currency) {
    private val _lines: MutableList<CurrencyConversion> = ArrayList()
    var total: Money = of(0, userCurrency)
        private set

    fun addLine(line: CurrencyConversion) {
        _lines.add(line)
        total = total.add(line.toMoney)
    }

    val lines: List<CurrencyConversion>
        get() = _lines.toList()
}
