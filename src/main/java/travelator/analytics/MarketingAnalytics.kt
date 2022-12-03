package travelator.analytics

import kotlin.streams.asSequence

class MarketingAnalytics(
    private val eventStore: EventStore
) {
    fun averageNumberOfEventsPerCompletedBooking(timeRange: String): Double {
        return eventStore
            .queryAsSequence("type=CompletedBooking&timerange=$timeRange")
            .allEventInSameInteractions()
            .groupBy(Event::interactionId)
            .values
            .averageBy { it.size }
    }

    private fun Sequence<MutableMap<String, Any>>.allEventInSameInteractions() =
        flatMap { event ->
            eventStore.queryAsSequence("interactionId=${event.interactionId}")
        }

    private fun <T> Collection<T>.averageBy(selector: (T) -> Int) =
        sumOf(selector) / size.toDouble()
}

fun EventStore.queryAsSequence(query: String) =
    this.queryAsStream(query).asSequence()

typealias Event = Map<String, Any?>

val Event.interactionId: String?
    get() = this["interactionId"] as? String
