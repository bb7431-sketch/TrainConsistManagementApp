import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        // UC1: Initialize an empty List using ArrayList
        List<String> bogies = new ArrayList<>();
        System.out.println("Initial bogie count: " + bogies.size());
        
        // UC2: Add Passenger Bogies
        System.out.println("\n--- UC2: Add Passenger Bogies ---");
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
        
        System.out.println("Passenger bogies added: " + bogies);
        
        // Remove one bogie
        bogies.remove("AC Chair");
        System.out.println("Removed AC Chair: " + bogies);
        
        // Check existence
        boolean containsSleeper = bogies.contains("Sleeper");
        System.out.println("Contains Sleeper: " + containsSleeper);
        
        // Print final list state
        System.out.println("Final passenger bogies: " + bogies);
    }
}
