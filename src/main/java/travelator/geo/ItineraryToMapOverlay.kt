package travelator.geo

import travelator.itinerary.*

val ItineraryItem.mapOverlay: MapOverlay
    get() = when (this) {
        is Accommodation -> mapOverlay
        is Attraction -> mapOverlay
        is Journey -> mapOverlay
        is RestaurantBooking -> mapOverlay
    }

val Accommodation.mapOverlay
    get() = PointOverlay(
        id = id,
        position = location.position,
        text = location.userReadableName,
        icon = StandardIcons.HOTEL
    )

val Attraction.mapOverlay
    get() =
        PointOverlay(
            position = location.position,
            text = description,
            icon = StandardIcons.ATTRACTION,
            id = id
        )

val Journey.mapOverlay
    get() = OverlayGroup(
        id = id,
        elements = listOf(
            PathOverlay(path, travelMethod.userReadableName),
            PointOverlay(departsFrom.position, departsFrom.userReadableName, StandardIcons.START),
            PointOverlay(arrivesAt.position, arrivesAt.userReadableName, StandardIcons.END)
        )
    )

val RestaurantBooking.mapOverlay
    get() = PointOverlay(
        id = id,
        position = location.position,
        text = location.userReadableName,
        icon = StandardIcons.RESTAURANT
    )
