package util;

/**
 * Tiện ích ghi log ra Console theo định dạng chuẩn.
 * Định dạng: [Time: XXs] <Nội dung log>
 *
 * ★ NGƯỜI 4 phụ trách implement ★
 */
public class TrafficLogger {

    private static long startTime = System.currentTimeMillis();

    /**
     * Reset thời gian bắt đầu (gọi khi bắt đầu mô phỏng).
     */
    public static void resetTimer() {
        startTime = System.currentTimeMillis();
    }

    /**
     * In log ra console với timestamp.
     * Định dạng: [Time: 12s] Xe cứu thương #01 đang đi qua ngã tư
     *
     * @param message nội dung log
     */
    public static void log(String message) {
        // TODO: Tính thời gian đã trôi qua từ startTime
        // TODO: In ra theo format: [Time: XXs] message
    }

    /**
     * In log cảnh báo (VD: kẹt xe, lỗi).
     * @param message nội dung cảnh báo
     */
    public static void warn(String message) {
        // TODO: In ra theo format: [WARNING - Time: XXs] message
    }
}
