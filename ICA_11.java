//ICA #11
//Reference example of enum:
enum Day {
MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
SATURDAY, SUNDAY;
}
…
// Assume someDay is a String of letters
someDay = someDay.toUpperCase();
Day myDay = Day.valueOf(someDay);
if (myDay == Day.FRIDAY) { … }
//Define an enum named TrafficLight with three values: RED, YELLOW, and GREEN.
//Create a variable of type TrafficLight and give it a value. Use your variable in an if statement.

//#1 Response:
enum TrafficLight {
  RED, YELLOW, GREEN;
}
public class TrafficLight {
  public static void main(String[] args) {
    TrafficLight signal = TrafficLight.RED;
    if (signal == TrafficLight.RED) {
      System.out.println("Stop!");
    }
  }
}



//Write a Java program that:
//a) Uses the TrafficLight enum defined above.
//b) Asks the user for a traffic light color (RED, YELLOW, or GREEN) by prompting with a
//Scanner object
//c) d) Converts the user input to uppercase (because the user might type in lowercase…)
//Declares a variable currentLight of type TrafficLight and assigns it a value.
//o must use the valueOf() method on the user input string
//e) Uses a switch statement to print messages based on the traffic light color:
//o RED → "Stop! The light is red."
//o YELLOW → "Slow down! The light is yellow."
//o GREEN → "Go! The light is green."

//#2 Response:
import java.util.Scanner;
enum TrafficLight {
  RED, YELLOW, GREEN;
}

public class Main {
public static void main(String[] args) {
// Get a Scanner object called scanner
  Scanner scanner = new Scanner(System.in);
// get the next line of input and convert it to uppercase
  System.out.println("Enter a color (RED, YELLOW, GREEN): ");
  String userInput = scanner.nextLine().toUppercase();
// ex: userInput.toUpperCase()
// Convert userInput to a TrafficLight enum
  TrafficLight currentLight = TrafficLight.valueOf(userInput);
// Write your switch statement below
  switch (currentLight) {
    case RED:
      System.out.println("Stop! The light is red.");
      break;
    case YELLOW:
      System.out.println("Slow down! The light is yellow.");
      break;
    case GREEN:
      System.out.println("Go! The light is green.");
      break;
  }
  scanner.close();
}


