package com.gradescope.airportinfo;
import java.io.*;
import java.util.*;



public class AirportInfo {
	
	public static List<String[]> parseFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
       
        List<String[]> parsedLines = new ArrayList<String[]>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] fields = line.trim().split(",");	
			parsedLines.add(fields);
		}
		scanner.close();
		return parsedLines;
	
		
	}
	


	private static HashMap<String, Integer> getAirportCount (String filename) throws FileNotFoundException {
		HashMap<String, Integer> airportCount = new HashMap<>();
		List<String[]> lines = parseFile(filename);
		
		for (String[] fields : lines) {
			
			String source = fields[2];
			String destination = fields[4];
			
			Integer sourceCount = airportCount.get(source);
			if (sourceCount == null) sourceCount = 0;
			airportCount.put(source,  sourceCount + 1 );
			
			Integer destCount = airportCount.get(destination);
			if (destCount == null) destCount = 0;
			airportCount.put(destination,  destCount + 1);
		}
		return airportCount;
	}
	
	private static HashMap<String, String> getDestinations(String filename) throws FileNotFoundException {
		HashMap<String, String> destinations = new HashMap<>();
		List<String[]> lines = parseFile(filename);
		
		for (String[] fields : lines) {
			String source = fields[2];
			String destination = fields[4];
			// Check if the airport already has the destinations listed
			if (!destinations.containsKey(source)) {
				destinations.put(source, destination);
			} else {
			// Append the new destination to the existing string, separated by commas
			destinations.put(source, destinations.get(source) + ", " + destination);
		}	}
		return destinations;
		
	}
	
	private static String getDepartures(HashMap<String, String> destinations) {
		String departures = "";
		List<String> sortedAirports = new ArrayList<String>(destinations.keySet());
		Collections.sort(sortedAirports);
		System.out.println("At beginning of getDepartures...");
		for (String airport : sortedAirports) {
			String destinationsList = destinations.get(airport);
			String[] sortedDestinations = destinationsList.split(", ");
			Arrays.sort(sortedDestinations);
			String sortedDestinationsStr = String.join(" ", sortedDestinations);
			departures += airport + " flies to " + sortedDestinationsStr + "\n";
		}
		return departures.trim();
	}
	
	private static String getMax(HashMap<String, Integer> airportCount) {
		int maxFlights = 0;
		System.out.println("At start of getMax...");
		List<String> maxAirports = new ArrayList<>();
		
		for(String airport : airportCount.keySet()) {
			int count = airportCount.get(airport);
			
			if (count > maxFlights) {
			maxFlights = count;
			maxAirports.clear();
			maxAirports.add(airport);
		} else if (count == maxFlights ) {
			maxAirports.add(airport);
		  }
		}
		String airportsStr = String.join(", ", maxAirports);
		String max = ("MAX FLIGHTS " + maxFlights + " : " + airportsStr);
		return max;
	}
	
	private static String getLimits (int limit, HashMap<String, Integer> airportCount) {
		String result = " ";
		List<String> filteredAirports = new ArrayList<String>();
		
		for (String airport : airportCount.keySet()) {
			if (airportCount.get(airport) > limit) {
				filteredAirports.add(airport + " - " + airportCount.get(airport));
			}
		}
		Collections.sort(filteredAirports);
		
		for (String entry : filteredAirports) {
			result += entry + "\n";
		}
		return result.trim();
	}	
		
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, String> destinations = getDestinations(args[0]);
		HashMap<String, Integer> airportCount = getAirportCount(args[0]);
				
		if (args[1].equals("MAX")) {
			System.out.println(getMax(airportCount));
		}
		if (args[1].equals("DEPARTURES")) {
			System.out.println(getDepartures(destinations));
		}
		if (args[1].equals("LIMIT")) {
			System.out.println(getLimits(Integer.valueOf(args[2]), airportCount));
		}
	}

}
