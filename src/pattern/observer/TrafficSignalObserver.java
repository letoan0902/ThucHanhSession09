package pattern.observer;

/**
 * Interface Observer (Observer Pattern) - Đối tượng nhận tín hiệu.
 * Vehicle sẽ implement interface này để lắng nghe thay đổi từ đèn giao thông.
 *
 */
public interface TrafficSignalObserver {

    /**
     * Được gọi khi đèn giao thông thay đổi trạng thái.
     * @param signalState trạng thái mới: "GREEN", "YELLOW", "RED"
     */
    void onSignalChanged(String signalState);
}
