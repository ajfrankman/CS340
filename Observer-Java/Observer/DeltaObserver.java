public class DeltaObserver implements ObserverInterface {
    Flight previousFlight;
    public void Update(Flight newFlight) {
        if (previousFlight == null) {
            previousFlight = newFlight;
            return;
        }
        if (newFlight == null) {
            return;
        }
        double deltaLongitude = newFlight.longitude - previousFlight.longitude;
        double deltaLatitude = newFlight.latitude - previousFlight.latitude;
        double deltaVelocity = newFlight.velocity - previousFlight.velocity;
        double deltaAltitude = newFlight.geo_altitude - previousFlight.geo_altitude;
        previousFlight = newFlight;
        String strb = "Delta Values: " +
                "Longitude: " +
                String.valueOf(deltaLongitude) +
                ", " +
                "Latitude: " +
                String.valueOf(deltaLatitude) +
                ", " +
                "Velocity: " +
                String.valueOf(deltaVelocity) +
                ", " +
                "Altitude: " +
                String.valueOf(deltaAltitude);
        System.out.println(strb);
    }
}
