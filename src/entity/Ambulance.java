package entity;

//Xe cứu thương - phương tiện ƯU TIÊN, được vượt đèn đỏ và nhường đường.
public class Ambulance extends PriorityVehicle {

    public Ambulance(String id, String direction) {
        super(id, "Ambulance", 10, 1, direction);
    }

    //Di chuyển nhanh, thể hiện tính khẩn cấp
    @Override
    public void moveTowardIntersection() {
        System.out.println( this + " is rushing quickly to the intersection!");
    }

    //Xe cứu thương hầu như không dừng, chỉ giảm tốc nếu cần
    @Override
    public void stop() {
        System.out.println(this + " slows down but keeps moving (priority override).");
    }
}