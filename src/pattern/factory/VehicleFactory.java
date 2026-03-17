package pattern.factory;

import entity.*;

/**
 * Factory Method Pattern - Tạo phương tiện ngẫu nhiên.
 * Gom logic tạo xe vào một nơi duy nhất, dễ mở rộng khi thêm loại xe mới.
 *
 */
public class VehicleFactory {

    /**
     * Tạo ngẫu nhiên một phương tiện với xác suất:
     * - 40% Motorbike
     * - 30% Car
     * - 20% Truck
     * - 10% Ambulance
     *
     * @param id ID duy nhất cho phương tiện
     * @param direction Hướng di chuyển: "NORTH", "SOUTH", "EAST", "WEST"
     * @return một Vehicle ngẫu nhiên
     */
    public static Vehicle createRandomVehicle(String id, String direction) {
        // TODO: Dùng Random để sinh xe theo xác suất
        // TODO: VD:
        //   int rand = new Random().nextInt(100);
        //   if (rand < 40) return new Motorbike(...);
        //   else if (rand < 70) return new Car(...);
        //   else if (rand < 90) return new Truck(...);
        //   else return new Ambulance(...);
        return null;
    }
}
