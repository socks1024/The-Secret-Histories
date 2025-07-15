package TheSecretHistories.Utils.DesignPatternsUtils.Event;

import java.util.ArrayList;

public abstract class EventBroadcaster {

    protected ArrayList<EventObserver> observers = new ArrayList<>();

    public void TriggerEvent() {
        observers.forEach(EventObserver::Update);
    }

    public void AddObserver(EventObserver observer) {
        observers.add(observer);
    }

    public void RemoveObserver(EventObserver observer) {
        observers.remove(observer);
    }
}
