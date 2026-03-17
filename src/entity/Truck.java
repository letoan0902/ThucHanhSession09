package entity;


 //Xe tải phương tiện thường, tốc độ chậm, kích thước lớn.
public class Truck extends StandardVehicle {

    //Constructor:type = "Truck" speed = thấp (ví dụ: 2) priority = 0 (xe thường)
    public Truck(String id, String direction) {
        super(id, "Truck", 2, 0, direction);
    }

    //Di chuyển về phía ngã tư với tốc độ chậm
    @Override
    public void moveTowardIntersection() {
        System.out.println( this + " is slowly moving toward intersection...");
    }

     // Dừng xe (khi đèn đỏ hoặc bị chặn)
    @Override
    public void stop() {
        System.out.println(this + " is stopping due to RED light or obstacle.");
    }

     //Xe tải KHÔNG phải xe ưu tiên
    @Override
    public boolean isPriority() {
        return false;
    }
}