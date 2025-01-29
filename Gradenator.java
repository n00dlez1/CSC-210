package com.gradescope.gradenator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Gradenator {
    // This is the entry point of the program.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File name?");
        
        // Read file name input from the user
        String fileName = scanner.nextLine();
        
        
        double totalPercent = 0;
        double totalWeight = 0;
        
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
                                sum += Double.parseDouble(currentNum); // Add number to sum
                                count++; // Increase count
                                currentNum = ""; // Reset current number
                            }
                        } else {
                            currentNum += currentChar; 
                        }
                    }

                    // If there's a number left at the end, process it
                    if (!currentNum.isEmpty()) {
                        sum += Double.parseDouble(currentNum);
                        count++;
                    }
                    
                    

                    // Calculate and print the mean
                    if (count > 0) {
                        double mean = (double) sum / count;
                        
                        
                        String weightField = fields[2].trim().replace("%", "");
                        double weight = Double.parseDouble(weightField);
                        
                        System.out.format("%s; %.1f%%; avg=%.1f%n",fields[1].trim(), weight, mean);
                        
                        totalPercent += weight;
                    
                        totalWeight += (double) (mean * weight)/100;
                    } 
                    
                }
            }

            System.out.format("TOTAL = %.1f%% out of %.1f%%",totalWeight, totalPercent);
            // Close file scanner
            fileScanner.close();

       
            scanner.close();
        }
    }
