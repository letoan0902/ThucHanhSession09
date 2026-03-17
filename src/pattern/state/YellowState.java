package pattern.state;

/**
 * Trạng thái ĐÈN VÀNG - Cảnh báo sắp chuyển đỏ, xe nên giảm tốc.
 * Chuyển sang RedState sau khi hết thời gian.
 *
 */
public class YellowState implements TrafficLightState {

    // TODO: Định nghĩa thời gian đèn vàng (VD: 3000ms)

    @Override
    public void handle() {
        // TODO: In ra log "Đèn VÀNG - Chuẩn bị dừng"
    }

    @Override
    public TrafficLightState nextState() {
        // TODO: return new RedState();
        return null;
    }

    @Override
    public String getStateName() {
        return "YELLOW";
    }

    @Override
    public long getDuration() {
        // TODO: return thời gian đèn vàng
        return 0;
    }
}
