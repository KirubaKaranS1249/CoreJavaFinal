package electricity;

public class BillCalculator {
    private static final double RATE_PER_UNIT = 0.10; // Sample rate per unit

    public static double calculateBill(int units) {
        return units * RATE_PER_UNIT;
    }
}
