package travelator.itinerary;

public class ItineraryItems {
    public static void example(ItineraryItem item) {
        if (item instanceof Journey) {
            var journey = (Journey) item;
        } else if (item instanceof Accommodation) {
            var accommodation = (Accommodation) item;
        } else if (item instanceof RestaurantBooking) {
            var restaurant = (RestaurantBooking) item;
        } else {
            throw new IllegalStateException("should never happen");
        }
    }
}
