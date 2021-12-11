import java.util.*;
public class Subject {

    List<ObserverInterface> allObservers = new ArrayList<>();

    public void Notify(Flight newFlight) {
        for (int i = 0; i < allObservers.size(); i++) {
            allObservers.get(i).Update(newFlight);
        }
    }

    public void Attach(ObserverInterface fo) {
        allObservers.add(fo);
    }

    public void Detach(ObserverInterface fo) {
        allObservers.remove(fo);
    }
}
