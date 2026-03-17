package entity;

//Xe máy - phương tiện thường, tốc độ nhanh, kích thước nhỏ.
public class Motorbike extends StandardVehicle {

    public Motorbike(String id, String direction) {
        super(id, "Motorbike", 8, 0, direction);
    }

    //Di chuyển nhanh về phía ngã tư
    @Override
    public void moveTowardIntersection() {
        System.out.println( this + " is بسرعة moving quickly toward intersection...");
    }

    //Dừng xe (phanh nhanh hơn xe khác)
    @Override
    public void stop() {
        System.out.println( this + " quickly stops at RED light.");
    }
}