public class FlightStateObserver implements ObserverInterface {

    public void Update(Flight newFlight) {
        if (newFlight == null) {
            return;
        }
        String strb = "icao24: " +
                newFlight.icao24 +
                ", " +
                "call sign: " +
                newFlight.callsign +
                ", " +
                "country of Origin: " +
                newFlight.origin_country +
                ", " +
                "longitude: " +
                newFlight.longitude +
                ", " +
                "latitude: " +
                newFlight.latitude +
                ", " +
                "velocity: " +
                newFlight.velocity +
                ", " +
                "altitude: " +
                newFlight.geo_altitude;
        System.out.println(strb);
    }
}
