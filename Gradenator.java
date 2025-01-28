package com.gradescope.gradenator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DraftPA_1 {
    // This is the entry point of the program.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Name?");
        
        // Read file name input from the user
        String fileName = scanner.nextLine();
        
        // REMOVE LATER. JUST FOR TESTS.
        System.out.println("The file name you inputted is " + fileName);
        
        double totalPercent = 0;
        double totalWeight = 0;
        
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            // Process each line in the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                int sum = 0;
                int count = 0;
                String[] fields = line.split(";");
                
                // Check if there is at least one field
                if (fields.length > 0) {
                    String numbersField = fields[0];
                    String currentNum = "";

                    // Loop through each character of the numbers field
                    for (int i = 0; i < numbersField.length(); i++) {
                        char currentChar = numbersField.charAt(i);

                        // When a space is encountered, process the number
                        if (currentChar == ' ') {
                            if (!currentNum.isEmpty()) {
                                sum += Integer.parseInt(currentNum); // Add number to sum
                                count++; // Increase count
                                currentNum = ""; // Reset current number
                            }
                        } else {
                            currentNum += currentChar; 
                        }
                    }

                    // If there's a number left at the end, process it
                    if (!currentNum.isEmpty()) {
                        sum += Integer.parseInt(currentNum);
                        count++;
                    }
                    
                    

                    // Calculate and print the mean
                    if (count > 0) {
                        double mean = sum / count;
                        
                        
                        String weightField = fields[2].trim().replace("%", "");
                        double weight = Double.parseDouble(weightField);
                        
                        System.out.format("%s; %.1f%%; avg=%.1f%n",fields[1], weight, mean);
                        
                        totalPercent += weight;
                        totalWeight += (mean * weight)/100;
                    } 
                    
                }
            }

            System.out.format("TOTAL = %.1f%% out of %.1f%%",totalWeight, totalPercent);
            // Close file scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            // Close the user input scanner
            scanner.close();
        }
    }
}
