import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
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
        
        // UC4: Maintain Ordered Bogie IDs (LinkedList)
        System.out.println("\n--- UC4: Maintain Ordered Train Consist ---");
        LinkedList<String> consist = new LinkedList<>();
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");
        System.out.println("Initial Ordered Consist: " + consist);
        
        // Insert Pantry Car at position 2
        consist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at 2: " + consist);
        
        // Remove the first and last bogie
        consist.removeFirst();
        consist.removeLast();
        
        // Display the final ordered train consist
        System.out.println("Final Ordered Train Consist: " + consist);
        
        // UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
        System.out.println("\n--- UC5: Preserve Insertion Order ---");
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        
        // Attempt to attach duplicate bogie
        formation.add("Sleeper");
        
        // Display final formation order, duplicate should be ignored
        System.out.println("Final Train Formation: " + formation);
    }
}
