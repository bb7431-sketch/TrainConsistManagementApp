import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrainAppTest {

    public static void main(String[] args) {
        System.out.println("=== Running TrainApp Tests ===");
        try {
            testGrouping_ByType();
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

    // UC9 Test Case
    private static void testGrouping_ByType() {
        System.out.println("\nTesting UC9: testGrouping_ByType");
        List<TrainApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainApp.Bogie("Sleeper", 72));
        bogies.add(new TrainApp.Bogie("AC Chair", 78));
        bogies.add(new TrainApp.Bogie("Sleeper", 72));

        Map<String, List<TrainApp.Bogie>> grouped = TrainApp.groupBogiesByType(bogies);

        assertEquals(2, grouped.size(), "Should have 2 groups");
        assertEquals(2, grouped.get("Sleeper").size(), "Sleeper group should have 2 bogies");
        assertEquals(1, grouped.get("AC Chair").size(), "AC Chair group should have 1 bogie");
        System.out.println("Passed: UC9 testGrouping_ByType");
    }
}
