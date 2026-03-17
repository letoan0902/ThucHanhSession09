package pattern.state;

/**
 * Trạng thái ĐÈN ĐỎ - Phương tiện phải dừng lại (trừ xe ưu tiên).
 * Chuyển sang GreenState sau khi hết thời gian.
 *
 */
public class RedState implements TrafficLightState {

    // TODO: Định nghĩa thời gian đèn đỏ (VD: 10000ms)

    @Override
    public void handle() {
        // TODO: In ra log "Đèn ĐỎ - Dừng lại"
    }

    @Override
    public TrafficLightState nextState() {
        // TODO: return new GreenState();
        return null;
    }

    @Override
    public String getStateName() {
        return "RED";
    }

    @Override
    public long getDuration() {
        // TODO: return thời gian đèn đỏ
        return 0;
    }
}
