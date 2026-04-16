import java.util.ArrayList;
import java.util.List;

public class TrainAppTest {

    public static void main(String[] args) {
        System.out.println("=== Running TrainApp Tests ===");
        try {
            testFilter_HighCapacity();
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

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    // UC8 Test Case
    private static void testFilter_HighCapacity() {
        System.out.println("\nTesting UC8: testFilter_HighCapacity");
        List<TrainApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.Bogie("Sleeper", 72));
        bogies.add(new TrainApp.Bogie("AC Chair", 78));
        bogies.add(new TrainApp.Bogie("First Class", 24));
        bogies.add(new TrainApp.Bogie("General", 60)); // Boundary case

        List<TrainApp.Bogie> filtered = TrainApp.filterHighCapacityBogies(bogies);

        assertEquals(2, filtered.size(), "Should find 2 high-capacity bogies");
        assertTrue(filtered.stream().allMatch(b -> b.getCapacity() > 60), "All filtered bogies must have capacity > 60");
        System.out.println("Passed: UC8 testFilter_HighCapacity");
    }
}
