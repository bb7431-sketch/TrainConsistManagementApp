import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Comparator;

public class TrainApp {

    // UC7: Bogie class to store name and capacity
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) throws InvalidCapacityException {
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
        
        // UC6: Map Bogie to Capacity (HashMap)
        System.out.println("\n--- UC6: Map Bogie to Capacity ---");
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 78);
        capacityMap.put("First Class", 24);
        
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }
        
        // UC7: Sort Bogies by Capacity (Comparator)
        System.out.println("\n--- UC7: Sort Bogies by Capacity ---");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 78));
        passengerBogies.add(new Bogie("First Class", 24));
        
        System.out.println("Before Sorting:");
        System.out.println(passengerBogies);
        
        // Sort using custom Comparator logic
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        
        System.out.println("After Sorting by Capacity:");
        System.out.println(passengerBogies);
        
        // UC8: Filter Passenger Bogies Using Streams
        System.out.println("\n--- UC8: Filter Passenger Bogies Using Streams ---");
        List<Bogie> filteredBogies = passengerBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(java.util.stream.Collectors.toList());
        
        System.out.println("Filtered High-Capacity Bogies (> 60 seats):");
        System.out.println(filteredBogies);
        
        // Add another Sleeper bogie to demonstrate grouping of multiple bogies in the same category
        passengerBogies.add(new Bogie("Sleeper", 72));
        
        // UC9: Group Bogies by Type (Collectors.groupingBy)
        System.out.println("\n--- UC9: Group Bogies by Type ---");
        Map<String, List<Bogie>> groupedBogies = passengerBogies.stream()
                .collect(java.util.stream.Collectors.groupingBy(b -> b.name));
                
        System.out.println("Bogies Grouped by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // UC10: Count Total Seats in Train (reduce)
        System.out.println("\n--- UC10: Count Total Seats in Train (reduce) ---");
        int totalSeats = passengerBogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Seating Capacity: " + totalSeats);
        
        // UC11: Validate Train ID & Cargo Codes (Regex)
        System.out.println("\n--- UC11: Validate Train ID & Cargo Codes (Regex) ---");
        
        java.util.regex.Pattern trainIdPattern = java.util.regex.Pattern.compile("^TRN-\\d{4}$");
        java.util.regex.Pattern cargoCodePattern = java.util.regex.Pattern.compile("^PET-[A-Z]{2}$");
        
        String[] trainIds = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN"};
        System.out.println("Validating Train IDs:");
        for (String id : trainIds) {
            java.util.regex.Matcher m = trainIdPattern.matcher(id);
            System.out.println("Train ID: " + id + " | Valid: " + m.matches());
        }
        
        String[] cargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET"};
        System.out.println("\nValidating Cargo Codes:");
        for (String code : cargoCodes) {
            java.util.regex.Matcher m = cargoCodePattern.matcher(code);
            System.out.println("Cargo Code: " + code + " | Valid: " + m.matches());
        }
        
        // UC12: Safety Compliance Check for Goods Bogies
        System.out.println("\n--- UC12: Safety Compliance Check for Goods Bogies ---");
        
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Box", "Electronics"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if ("Cylindrical".equals(b.type)) {
                        return "Petroleum".equals(b.cargo);
                    }
                    return true;
                });
        
        System.out.println("Train Formation Safety (Safe check): " + isSafe);
        
        // Add an unsafe cylindrical bogie
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));
        boolean isSafe2 = goodsBogies.stream()
                .allMatch(b -> {
                    if ("Cylindrical".equals(b.type)) {
                        return "Petroleum".equals(b.cargo);
                    }
                    return true;
                });
                
        System.out.println("Train Formation Safety (Unsafe check): " + isSafe2);
        
        // UC13: Performance Comparison (Loops vs Streams)
        System.out.println("\n--- UC13: Performance Comparison (Loops vs Streams) ---");
        
        List<Bogie> largeBogieList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int capacity = (i % 2 == 0) ? 72 : 50; // Mix of capacities
            largeBogieList.add(new Bogie("Bogie" + i, capacity));
        }
        
        // Measure Loop Filtering Performance
        long loopStartTime = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : largeBogieList) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long loopEndTime = System.nanoTime();
        long loopDuration = loopEndTime - loopStartTime;
        
        // Measure Stream Filtering Performance
        long streamStartTime = System.nanoTime();
        List<Bogie> streamFiltered = largeBogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(java.util.stream.Collectors.toList());
        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;
        
        System.out.println("Loop Filter Result Size   : " + loopFiltered.size());
        System.out.println("Stream Filter Result Size : " + streamFiltered.size());
        System.out.println("Loop Filtering Time (ns)  : " + loopDuration);
        System.out.println("Stream Filtering Time (ns): " + streamDuration);
        
        // UC14: Handle Invalid Bogie Capacity (Custom Exception)
        System.out.println("\n--- UC14: Handle Invalid Bogie Capacity (Custom Exception) ---");
        try {
            System.out.println("Attempting to create a valid bogie...");
            Bogie validBogie = new Bogie("General", 90);
            System.out.println("Success: " + validBogie);
            
            System.out.println("Attempting to create a bogie with zero capacity...");
            Bogie zeroBogie = new Bogie("Zero", 0);
            System.out.println("Success: " + zeroBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        
        try {
            System.out.println("Attempting to create a bogie with negative capacity...");
            Bogie negativeBogie = new Bogie("Negative", -10);
            System.out.println("Success: " + negativeBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
    
    // UC12: GoodsBogie class to store type and cargo
    static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // UC14: Custom Exception class for invalid capacity
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }
}
