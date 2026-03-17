package entity;

import pattern.observer.TrafficSignalObserver;

/**
 * Lớp cha trừu tượng đại diện cho tất cả phương tiện giao thông.
 * Mỗi Vehicle có thể chạy trên một thread riêng (implements Runnable).
 * Đồng thời là Observer để lắng nghe tín hiệu đèn giao thông.
 *
 */
public abstract class Vehicle implements Runnable, TrafficSignalObserver {

    private String id;
    private String type;        // "Car", "Motorbike", "Truck", "Ambulance"
    private int speed;          // Tốc độ di chuyển (đơn vị tùy chọn)
    private int priority;       // Mức ưu tiên (0 = thường, 1 = ưu tiên cao)
    private String direction;   // Hướng di chuyển: "NORTH", "SOUTH", "EAST", "WEST"

    // TODO: Constructor

    // TODO: Getter / Setter

    /**
     * Phương tiện di chuyển về phía ngã tư.
     * Logic: giảm khoảng cách đến ngã tư theo tốc độ.
     */
    public abstract void moveTowardIntersection();

    /**
     * Phương tiện dừng lại (khi gặp đèn đỏ hoặc xe chắn phía trước).
     */
    public abstract void stop();

    /**
     * Kiểm tra xem phương tiện có được ưu tiên hay không (VD: xe cứu thương).
     * @return true nếu là xe ưu tiên
     */
    public abstract boolean isPriority();

    /**
     * Logic chạy của thread - mỗi xe tự di chuyển, kiểm tra đèn, xin vào ngã tư.
     */
    @Override
    public void run() {
        // TODO: Implement thread logic
    }

    /**
     * Nhận tín hiệu từ đèn giao thông (Observer Pattern).
     * @param signalState trạng thái đèn: "GREEN", "YELLOW", "RED"
     */
    @Override
    public void onSignalChanged(String signalState) {
        // TODO: Implement observer logic
    }

    @Override
    public String toString() {
        return type + " #" + id;
    }
}
