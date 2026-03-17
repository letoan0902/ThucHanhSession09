package engine;

import entity.Vehicle;
import pattern.factory.VehicleFactory;
import util.TrafficLogger;
import util.TrafficStatistics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Bộ điều phối mô phỏng - Điều khiển toàn bộ luồng chạy của hệ thống.
 * Khởi tạo đèn, ngã tư, sinh xe, và chạy mô phỏng trong khoảng thời gian nhất định.
 *
 *  
 */
public class SimulationEngine {

    private static final int SIMULATION_DURATION_SECONDS = 60;  // Thời gian mô phỏng
    private static final int VEHICLE_SPAWN_INTERVAL_MS = 2000;  // Mỗi 2 giây sinh 1 xe

    private final TrafficLight trafficLight;
    private final Intersection intersection;
    private final ExecutorService vehicleExecutor;  // Thread pool quản lý các xe

    // TODO: Constructor - khởi tạo trafficLight, intersection, ExecutorService

    public SimulationEngine() {
        this.trafficLight = new TrafficLight();
        this.intersection = new Intersection();
        this.vehicleExecutor = Executors.newCachedThreadPool();
    }

    /**
     * Bắt đầu mô phỏng.
     * 1. Khởi chạy thread đèn giao thông (Daemon Thread)
     * 2. Vòng lặp sinh xe mới → submit vào ExecutorService
     * 3. Sau khi hết thời gian → shutdown và in thống kê
     */
    public void startSimulation() {
        // TODO: Tạo daemon thread cho TrafficLight
        // TODO: Vòng lặp sinh xe:
        //   Vehicle v = VehicleFactory.createRandomVehicle(id, direction);
        //   trafficLight.registerObserver(v);
        //   vehicleExecutor.submit(v);
        // TODO: Sau SIMULATION_DURATION_SECONDS → gọi stopSimulation()
    }

    /**
     * Dừng mô phỏng.
     * Shutdown ExecutorService và in báo cáo thống kê.
     */
    public void stopSimulation() {
        // TODO: vehicleExecutor.shutdown();
        // TODO: In thống kê cuối cùng (tổng xe, số lần kẹt xe...)
    }

    // Getters cho testing
    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public Intersection getIntersection() {
        return intersection;
    }
}
