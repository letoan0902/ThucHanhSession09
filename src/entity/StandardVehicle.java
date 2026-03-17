package entity;

/**
 * Lớp trung gian đại diện cho các phương tiện THƯỜNG (không ưu tiên).
 * Các xe thường phải tuân thủ đèn giao thông.
 *
 */
public abstract class StandardVehicle extends Vehicle {

    // TODO: Constructor gọi super()

    /**
     * Xe thường KHÔNG có quyền ưu tiên.
     */
    @Override
    public boolean isPriority() {
        return false;
    }

    // TODO: Implement các phương thức abstract từ Vehicle nếu có logic chung cho xe thường
}
