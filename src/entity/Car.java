package entity;

//Ô tô - phương tiện thường, tốc độ trung bình.
public class Car extends StandardVehicle {

    public Car(String id, String direction) {
        super(id, "Car", 5, 0, direction);
    }

    //Di chuyển với tốc độ trung bình
    @Override
    public void moveTowardIntersection() {
        System.out.println(this + " is moving steadily toward intersection...");
    }

    //Dừng xe khi gặp đèn đỏ hoặc bị chặn
    @Override
    public void stop() {
        System.out.println( this + " is stopping at RED light.");
    }
}