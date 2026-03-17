package entity;

/**
 * Lớp trung gian đại diện cho các phương tiện ƯU TIÊN (xe cứu thương, xe cứu hỏa...).
 * Xe ưu tiên có thể vượt đèn đỏ và được nhường đường.
 *
 
 */
public abstract class PriorityVehicle extends Vehicle {

    // TODO: Constructor gọi super()

    /**
     * Xe ưu tiên CÓ quyền ưu tiên.
     */
    @Override
    public boolean isPriority() {
        return true;
    }

    // TODO: Implement các phương thức abstract từ Vehicle nếu có logic chung cho xe ưu tiên
}
