package pattern.state;

/**
 * Interface đại diện cho một trạng thái của đèn giao thông (State Pattern).
 * Mỗi trạng thái (Xanh, Vàng, Đỏ) sẽ implement interface này.
 *
 */
public interface TrafficLightState {

    /**
     * Xử lý hành vi của trạng thái hiện tại.
     * VD: Đèn xanh → cho xe đi, Đèn đỏ → dừng xe.
     */
    void handle();

    /**
     * Chuyển sang trạng thái tiếp theo.
     * GREEN → YELLOW → RED → GREEN
     * @return trạng thái tiếp theo
     */
    TrafficLightState nextState();

    /**
     * Lấy tên trạng thái hiện tại.
     * @return "GREEN", "YELLOW", hoặc "RED"
     */
    String getStateName();

    /**
     * Thời gian (ms) tồn tại của trạng thái này trước khi chuyển.
     * VD: GREEN = 10000ms, YELLOW = 3000ms, RED = 10000ms
     * @return thời gian tính bằng milliseconds
     */
    long getDuration();
}
