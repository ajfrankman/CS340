public class FlightMonitor {
	
	public static void main(String[] args) {
		FlightFeed feed = new FlightFeed();

		FlightStateObserver stateObserver = new FlightStateObserver();
		DeltaObserver deltaObserver = new DeltaObserver();

		feed.Attach(stateObserver);
		feed.Attach(deltaObserver);
		feed.start();
		feed.Detach(stateObserver);
		feed.Detach(deltaObserver);
	}
	
}