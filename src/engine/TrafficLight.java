package engine;

import pattern.state.TrafficLightState;
import pattern.state.GreenState;
import pattern.observer.TrafficSignalSubject;
import pattern.observer.TrafficSignalObserver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Đèn giao thông - Chạy trên Daemon Thread, tự động chuyển trạng thái.
 * Sử dụng State Pattern để quản lý trạng thái.
 * Sử dụng Observer Pattern để thông báo cho các xe khi đèn thay đổi.
 *
 *  
 */
public class TrafficLight implements Runnable, TrafficSignalSubject {

    private TrafficLightState currentState;
    private final List<TrafficSignalObserver> observers = new CopyOnWriteArrayList<>();

    // TODO: Constructor - khởi tạo trạng thái ban đầu (GreenState)

    /**
     * Lấy trạng thái hiện tại của đèn.
     * @return tên trạng thái: "GREEN", "YELLOW", "RED"
     */
    public String getCurrentStateName() {
        // TODO: return currentState.getStateName();
        return null;
    }

    /**
     * Chuyển sang trạng thái tiếp theo (GREEN → YELLOW → RED → GREEN).
     * Sau khi chuyển, thông báo cho tất cả observers.
     */
    public void changeState() {
        // TODO: currentState = currentState.nextState();
        // TODO: notifyObservers();
    }

    /**
     * Logic chạy của thread đèn giao thông.
     * Vòng lặp: handle trạng thái hiện tại → sleep đúng duration → chuyển trạng thái.
     */
    @Override
    public void run() {
        // TODO: while (!Thread.currentThread().isInterrupted()) {
        //   currentState.handle();
        //   Thread.sleep(currentState.getDuration());
        //   changeState();
        // }
    }

    // ==================== Observer Pattern Methods ====================

    @Override
    public void registerObserver(TrafficSignalObserver observer) {
        // TODO: observers.add(observer);
    }

    @Override
    public void removeObserver(TrafficSignalObserver observer) {
        // TODO: observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // TODO: Duyệt qua tất cả observers và gọi onSignalChanged()
    }
}
