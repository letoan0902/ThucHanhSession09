package engine;

import pattern.state.TrafficLightState;
import pattern.state.GreenState;
import pattern.observer.TrafficSignalSubject;
import pattern.observer.TrafficSignalObserver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrafficLight implements Runnable, TrafficSignalSubject {

    private TrafficLightState currentState;
    private final List<TrafficSignalObserver> observers = new CopyOnWriteArrayList<>();

    public TrafficLight() {
        this.currentState = new GreenState(); // bắt đầu GREEN
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    public void changeState() {
        currentState = currentState.nextState();
        System.out.println("🚦 Traffic Light changed to: " + getCurrentStateName());

        notifyObservers(); // báo cho xe
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                currentState.handle(); // in trạng thái

                Thread.sleep(currentState.getDuration()); // đợi theo state

                changeState(); // chuyển trạng thái
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Observer Pattern

    @Override
    public void registerObserver(TrafficSignalObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TrafficSignalObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (TrafficSignalObserver observer : observers) {
            observer.onSignalChanged(getCurrentStateName());
        }
    }
}