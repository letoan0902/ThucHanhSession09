package engine;

import entity.PriorityVehicle;
import entity.Vehicle;
import exception.CollisionException;
import exception.TrafficJamException;
import util.TrafficLogger;
import util.TrafficStatistics;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

    private static final int MAX_VEHICLES_IN_INTERSECTION = 2;
    private static final int MAX_QUEUE_CAPACITY = 20;

    private final Semaphore semaphore = new Semaphore(MAX_VEHICLES_IN_INTERSECTION, true);
    private final ReentrantLock lock = new ReentrantLock(true);
    private final ConcurrentLinkedQueue<Vehicle> waitingQueue = new ConcurrentLinkedQueue<>();

    private int totalPassed = 0;
    private int trafficJamCount = 0;

    public void enterIntersection(Vehicle vehicle)
            throws TrafficJamException, CollisionException {

        try {
            lock.lock();
            // kiểm tra kẹt xe
            if (waitingQueue.size() > MAX_QUEUE_CAPACITY) {
                trafficJamCount++;
                TrafficLogger.log("Traffic Jam detected!");
                throw new TrafficJamException("Too many vehicles waiting!");
            }

            // xe ưu tiên
            if (!(vehicle instanceof PriorityVehicle)) {
                waitingQueue.add(vehicle);
                TrafficLogger.log(vehicle + " is waiting...");
            }

        } finally {
            lock.unlock();
        }

        try {
            // 🚦 acquire slot trong ngã tư
            semaphore.acquire();

            lock.lock();
            try {
                waitingQueue.remove(vehicle);
            } finally {
                lock.unlock();
            }
            TrafficLogger.log(vehicle + " ENTERED intersection");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CollisionException("Thread interrupted → possible collision!");
        }
    }

    public void exitIntersection(Vehicle vehicle) {
        semaphore.release();
        lock.lock();
        try {
            totalPassed++;
        } finally {
            lock.unlock();
        }

        TrafficLogger.log(vehicle + " EXITED intersection");
    }

    public void addToWaitingQueue(Vehicle vehicle) {
        waitingQueue.add(vehicle);
    }

    public int getWaitingCount() {
        return waitingQueue.size();
    }

    public int getTotalPassed() {
        return totalPassed;
    }

    public int getTrafficJamCount() {
        return trafficJamCount;
    }
}