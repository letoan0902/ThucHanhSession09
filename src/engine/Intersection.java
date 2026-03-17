package engine;

import entity.Vehicle;
import exception.CollisionException;
import exception.TrafficJamException;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ngã tư - Critical Section, vùng không gian giao nhau.
 * Quản lý việc xe vào/ra ngã tư bằng Semaphore hoặc ReentrantLock.
 * Chỉ cho phép N xe đi qua cùng lúc, tránh Race Condition.
 *
 * 
 */
public class Intersection {

    private static final int MAX_VEHICLES_IN_INTERSECTION = 2;  // Tối đa 2 xe trong ngã tư
    private static final int MAX_QUEUE_CAPACITY = 20;           // Ngưỡng kẹt xe

    private final Semaphore semaphore = new Semaphore(MAX_VEHICLES_IN_INTERSECTION, true);
    private final ReentrantLock lock = new ReentrantLock(true);  // Fair lock
    private final ConcurrentLinkedQueue<Vehicle> waitingQueue = new ConcurrentLinkedQueue<>();

    // TODO: Biến đếm số xe đã đi qua, số lần kẹt xe...

    /**
     * Xe yêu cầu vào ngã tư.
     * - Nếu là xe ưu tiên → cho vào ngay (acquire semaphore)
     * - Nếu là xe thường → kiểm tra đèn xanh mới cho vào
     * - Nếu hàng đợi quá dài → throw TrafficJamException
     *
     * @param vehicle xe muốn vào
     * @throws TrafficJamException khi hàng đợi vượt quá công suất
     * @throws CollisionException khi xử lý lock không tốt
     */
    public void enterIntersection(Vehicle vehicle) throws TrafficJamException, CollisionException {
        // TODO: Implement logic vào ngã tư
        // TODO: Sử dụng semaphore.acquire() để giới hạn số xe
        // TODO: Kiểm tra waitingQueue.size() > MAX_QUEUE_CAPACITY → throw TrafficJamException
    }

    /**
     * Xe rời khỏi ngã tư - giải phóng tài nguyên.
     * @param vehicle xe ra khỏi ngã tư
     */
    public void exitIntersection(Vehicle vehicle) {
        // TODO: semaphore.release()
        // TODO: Cập nhật thống kê
    }

    /**
     * Thêm xe vào hàng đợi chờ đèn đỏ.
     * @param vehicle xe đang chờ
     */
    public void addToWaitingQueue(Vehicle vehicle) {
        // TODO: waitingQueue.add(vehicle)
    }

    /**
     * Lấy số xe đang chờ trong hàng đợi.
     * @return số xe đang đợi
     */
    public int getWaitingCount() {
        return waitingQueue.size();
    }

    /**
     * Lấy tổng số xe đã đi qua ngã tư thành công.
     * @return tổng số xe
     */
    public int getTotalPassed() {
        // TODO: return biến đếm
        return 0;
    }
}
