package entity;

//Lớp trung gian đại diện cho các phương tiện ƯU TIÊN(xe cứu thương, xe cứu hỏa...).Xe ưu tiên có thể vượt đèn đỏ và được nhường đường.
public abstract class PriorityVehicle extends Vehicle {

    public PriorityVehicle(String id, String type, int speed, int priority, String direction) {
        super(id, type, speed, priority, direction);
    }

    //Xe ưu tiên CÓ quyền ưu tiên
    @Override
    public boolean isPriority() {
        return true;
    }

    //Xe ưu tiên vẫn di chuyển ngay cả khi đèn đỏ
    @Override
    public void moveTowardIntersection() {
        System.out.println( this + " is rushing toward intersection (priority)!");
    }

    //Xe ưu tiên gần như KHÔNG dừng (trừ khi có xử lý đặc biệt)
    @Override
    public void stop() {
        System.out.println( this + " slows down but keeps moving (priority override).");
    }
}