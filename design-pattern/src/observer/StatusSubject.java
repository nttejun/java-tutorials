package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class StatusSubject {
    private List<StatusObserver> observers = new ArrayList<StatusObserver>();

    public void add(StatusObserver observer) {
        observers.add(observer);
    }

    public void remove(StatusObserver observer) {
        observers.remove(observer);
    }

    public void notifyStatus(Status status) {
        for (StatusObserver observer : observers) {
            observer.onAbnormalStatus(status);
        }
    }
}
