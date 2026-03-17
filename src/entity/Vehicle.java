package entity;

import pattern.observer.TrafficSignalObserver;

//Lớp cha trừu tượng đại diện cho tất cả phương tiện giao thông. Mỗi Vehicle chạy trên một thread riêng (Runnable)

public abstract class Vehicle implements Runnable, TrafficSignalObserver {
    private String id;
    private String type;        // "Car", "Motorbike", ...
    private int speed;          // Tốc độ di chuyển
    private int priority;       // 0 = thường, 1 = ưu tiên
    private String direction;   // NORTH, SOUTH, EAST, WEST

    //Biến trạng thái nội bộ
    protected volatile boolean isRunning = true;   // thread còn chạy
    protected volatile String currentSignal = "RED"; // trạng thái đèn hiện tại

    //CONSTRUCTOR
    public Vehicle(String id, String type, int speed, int priority, String direction) {
        this.id = id;
        this.type = type;
        this.speed = speed;
        this.priority = priority;
        this.direction = direction;
    }

    //GETTER
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPriority() {
        return priority;
    }

    public String getDirection() {
        return direction;
    }

    //SETTER
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    //ABSTRACT METHODS

    //Di chuyển về phía ngã tư
    public abstract void moveTowardIntersection();

    //dừng lại
    public abstract void stop();

     //Kiểm tra có phải xe ưu tiên không
    public abstract boolean isPriority();

    //THREAD LOGIC
    @Override
    public void run() {
        try {
            while (isRunning) {

                // 1. Di chuyển về phía ngã tư
                moveTowardIntersection();

                // 2. Kiểm tra tín hiệu đèn
                if ("RED".equals(currentSignal) && !isPriority()) {
                    stop(); // xe thường phải dừng
                } else {
                    // Đèn xanh hoặc xe ưu tiên → đi tiếp
                    System.out.println(this + " is moving through intersection");
                }

                // 3. Giả lập thời gian di chuyển
                Thread.sleep(1000 / speed);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(this + " interrupted.");
        }
    }

    //OBSERVER
     //Nhận tín hiệu từ TrafficLight
    @Override
    public void onSignalChanged(String signalState) {
        System.out.println(this + " received signal: " + signalState);
        this.currentSignal = signalState;

        // Nếu đèn đỏ và không phải xe ưu tiên → dừng
        if ("RED".equals(signalState) && !isPriority()) {
            stop();
        }
    }

    //TO STRING
    @Override
    public String toString() {
        return type + " #" + id + " [" + direction + "]";
    }
}