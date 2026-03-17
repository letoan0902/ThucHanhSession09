package engine;

import entity.Vehicle;
import pattern.factory.VehicleFactory;
import util.TrafficLogger;
import util.TrafficStatistics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {

    private static final int SIMULATION_DURATION_SECONDS = 60;
    private static final int VEHICLE_SPAWN_INTERVAL_MS = 2000;

    private final TrafficLight trafficLight;
    private final Intersection intersection;
    private final ExecutorService vehicleExecutor;

    private volatile boolean running = true;

    public SimulationEngine() {
        this.trafficLight = new TrafficLight();
        this.intersection = new Intersection();
        this.vehicleExecutor = Executors.newCachedThreadPool();
    }

    public void startSimulation() {

        TrafficLogger.log("🚦 Simulation started...");

        // 🔹 1. chạy TrafficLight (daemon thread)
        Thread lightThread = new Thread(trafficLight);
        lightThread.setDaemon(true);
        lightThread.start();

        // 🔹 2. sinh xe liên tục
        new Thread(() -> {
            int id = 1;

            while (running) {
                try {
                    Vehicle v = VehicleFactory.createRandomVehicle(id++, trafficLight, intersection);
                    // đăng ký observer
                    trafficLight.registerObserver(v);
                    vehicleExecutor.submit(v);
                    Thread.sleep(VEHICLE_SPAWN_INTERVAL_MS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //hẹn giờ stop simulation
        new Thread(() -> {
            try {
                Thread.sleep(SIMULATION_DURATION_SECONDS * 1000L);
                stopSimulation();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void stopSimulation() {

        running = false;

        TrafficLogger.log("Stopping simulation...");

        vehicleExecutor.shutdown();

        try {
            if (!vehicleExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                vehicleExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            vehicleExecutor.shutdownNow();
        }

        // 🔹 in thống kê
        TrafficLogger.log("Simulation finished!");
        TrafficStatistics.printReport();
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public Intersection getIntersection() {
        return intersection;
    }
}