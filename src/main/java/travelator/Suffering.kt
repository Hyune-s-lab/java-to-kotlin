package travelator

object Suffering {
    @JvmStatic
    fun sufferScoreFor(route: List<Journey>): Int {
        return sufferScore(
            route.longestJourneys(3),
            Routes.getDepartsFrom(route)
        )
    }

    @JvmStatic
    fun List<Journey>.longestJourneys(limit: Int): List<Journey> =
        sortedByDescending { it.duration }.take(limit)

    fun routesToShowFor(itineraryId: String?): List<List<Journey>> {
        return bearable(Other.routesFor(itineraryId))
    }

    private fun bearable(routes: List<List<Journey>>): List<List<Journey>> = routes.filter { sufferScoreFor(it) <= 10 }

    private fun sufferScore(
        longestJourneys: List<Journey>,
        start: Location
    ): Int {
        return Other.SOME_COMPLICATED_RESULT()
    }
}
