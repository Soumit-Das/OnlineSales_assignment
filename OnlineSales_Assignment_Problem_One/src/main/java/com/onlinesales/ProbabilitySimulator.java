package com.onlinesales;

import java.util.*;

public class ProbabilitySimulator {

    private Map<String, Double> events = new LinkedHashMap<String, Double>();

    
    
    /**
	 * Raises a new complaint by the employee with the provided complaint type.
	 * 
	 * @param event         The event that will be given.
	 * @param probability   The probability for the event.
	 * @return {@code true} if the event was added successfully, {@code false} if the event is already present.
	 */
    public boolean addEvent(String event, double probability) {
        if (isEventPresent(event)) {
            return false;
        } else {
            return events.put(event, probability) == null;
        }
    }

    
    /**
     * Checks if a given event is already present in the list of events.
     * 
     * @param event The event to check for presence.
     * @return {@code true} if the event is present, {@code false} otherwise.
     */
    public boolean isEventPresent(String event) {
        return events.containsKey(event);
    }

    
    /**
     * Gets the number of events currently stored.
     * 
     * @return The number of events.
     */
    public int getNumberOfEvent() {
        return events.size();
    }

    
    /**
     * Retrieves a list of all event names.
     * 
     * @return A list containing the names of all events.
     */
    public List<String> getEvents() {
        return new ArrayList<String>(events.keySet());
    }

    
    /**
     * Retrieves an array of event probabilities.
     * 
     * @return An array containing the probabilities of all events.
     */
    public double[] getProbabilityArray() {
        double[] probabilityArray = new double[getNumberOfEvent()];
        int i = 0;

        for (double probability : events.values()) {
            probabilityArray[i++] = probability;
        }

        return probabilityArray;
    }

    
    /**
     * Simulates events based on their probabilities.
     * 
     * @param numSimulations The number of simulations to run.
     * @return A map containing event names as keys and the count of occurrences as values.
     */
    public Map<String, Integer> simulateEvents(int numSimulations) {
        int[] eventCounts = new int[getNumberOfEvent()];
        double[] probabilityArray = getProbabilityArray();

        Random random = new Random();

        for (int i = 0; i < numSimulations; i++) {
            double randDouble = random.nextDouble() * 100;
            double summedProbability = 0.0;

            for (int j = 0; j < getNumberOfEvent(); j++) {
                summedProbability += probabilityArray[j];

                if (randDouble < summedProbability) {
                    eventCounts[j]++;
                    break;
                }
            }
        }

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        List<String> eventNames = getEvents();

        for (int i = 0; i < eventCounts.length; i++) {
            result.put(eventNames.get(i), eventCounts[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProbabilitySimulator simulator = new ProbabilitySimulator();

        System.out.print("Enter the number of events: ");
        int numEvents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numEvents; i++) {
            System.out.print("Enter the name for event " + (i + 1) + ": ");
            String eventName = scanner.nextLine();

            System.out.print("Enter the probability for event " + (i + 1) + ": ");
            double eventProbability = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            simulator.addEvent(eventName, eventProbability);
        }

        System.out.print("Enter the number of simulations: ");
        int numSimulations = scanner.nextInt();

        Map<String, Integer> simulationResult = simulator.simulateEvents(numSimulations);

        System.out.println("\nSimulation Results:");
        for (Map.Entry<String, Integer> entry : simulationResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
