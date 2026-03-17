package pattern.state;

/**
 * Trạng thái ĐÈN XANH - Cho phép phương tiện di chuyển.
 * Chuyển sang YellowState sau khi hết thời gian.
 *
 */
public class GreenState implements TrafficLightState {

    // TODO: Định nghĩa thời gian đèn xanh (VD: 10000ms)

    @Override
    public void handle() {
        // TODO: In ra log "Đèn XANH - Xe được phép đi"
    }

    @Override
    public TrafficLightState nextState() {
        // TODO: return new YellowState();
        return null;
    }

    @Override
    public String getStateName() {
        return "GREEN";
    }

    @Override
    public long getDuration() {
        // TODO: return thời gian đèn xanh
        return 0;
    }
}
