package pattern.observer;

/**
 * Interface Subject (Observer Pattern) - Đối tượng phát tín hiệu.
 * TrafficLight sẽ implement interface này để thông báo cho các xe.
 *
 */
public interface TrafficSignalSubject {

    /**
     * Đăng ký một observer (xe) để nhận tín hiệu.
     * @param observer phương tiện muốn theo dõi đèn
     */
    void registerObserver(TrafficSignalObserver observer);

    /**
     * Hủy đăng ký observer.
     * @param observer phương tiện muốn ngừng theo dõi
     */
    void removeObserver(TrafficSignalObserver observer);

    /**
     * Thông báo cho tất cả observer khi đèn thay đổi trạng thái.
     */
    void notifyObservers();
}
