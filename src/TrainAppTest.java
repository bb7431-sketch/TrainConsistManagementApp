import java.util.ArrayList;
import java.util.List;

public class TrainAppTest {

    public static void main(String[] args) {
        System.out.println("=== Running TrainApp Tests ===");
        try {
            testCalculateTotalSeats();
            System.out.println("\nAll tests passed successfully!");
        } catch (Throwable e) {
            System.out.println("\nTest failed!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " | Expected: " + expected + ", Actual: " + actual);
        }
    }

    // UC10 Test Case
    private static void testCalculateTotalSeats() {
        System.out.println("\nTesting UC10: testCalculateTotalSeats");
        List<TrainApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.Bogie("Sleeper", 72));
        bogies.add(new TrainApp.Bogie("AC Chair", 78));
        bogies.add(new TrainApp.Bogie("First Class", 24));

        int total = TrainApp.calculateTotalSeats(bogies);

        assertEquals(174, total, "Total seats should be 174");
        System.out.println("Passed: UC10 testCalculateTotalSeats");
    }
}
