import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        // UC3: Track Unique Bogie IDs
        System.out.println("\n--- UC3: Track Unique Bogie IDs ---");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        // Intentional duplicate
        bogieIds.add("BG101");
        
        System.out.println("Unique Bogie IDs: " + bogieIds);
    }
}
