package travelator.analytics

import kotlin.streams.asSequence

class MarketingAnalytics(
    private val eventStore: EventStore
) {
    fun averageNumberOfEventsPerCompletedBooking(timeRange: String): Double {
        return eventStore.queryAsSequence("type=CompletedBooking&timerange=$timeRange")
            .allEventInSameInteractions()
            .groupBy { event ->
                event["interactionId"] as String
            }.values
            .averageBy { it.size }
    }

    private fun Sequence<MutableMap<String, Any>>.allEventInSameInteractions() =
        flatMap { event ->
            val interactionId = event["interactionId"] as String
            eventStore
                .queryAsSequence("interactionId=$interactionId")
        }

    private fun <T> Collection<T>.averageBy(selector: (T) -> Int) =
        sumOf(selector) / size.toDouble()
}

fun EventStore.queryAsSequence(query: String) =
    this.queryAsStream(query).asSequence()
