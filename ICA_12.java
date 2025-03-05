// ICA #12 
//#2
    //A: NullPointerException (s is declared, but not initialized)
    //B: StringIndexOutOfBoundsException (out of bounds)
//#3
    //Unchecked Exceptions (handled at run-time)
	//IndexOutofBoundsException
	//NullPointer Exception
	//ClassCastException
    //Checked Exceptions (handled at compile time)
	//IOException
	//FileNotFoundException
//#1 and #4 in code below.
	
import java.util.Scanner;

enum TrafficLight {
	RED(30), YELLOW(5), GREEN(25);
	private final int duration;
	TrafficLight(int duration) {
		this.duration = duration;
	}
	public int getDuration() {
		return duration;
	}
}

public class Traffic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Ask user for a traffic light color
		System.out.print("Enter a traffic light color (RED, YELLOW, GREEN): ");
		String userInput = scanner.next().toUpperCase();
		try {
		    // Convert user input to a TrafficLight enum
		    TrafficLight currentLight = TrafficLight.valueOf(userInput);

		   // Switch statement based on traffic light color
		    switch (currentLight) {
		        case RED:
			    System.out.println("Stop! The light is red." + currentLight.getDuration() + " seconds.");
			    break;
		        case YELLOW:
			    System.out.println("Slow down! The light is yellow." + currentLight.getDuration() + " seconds.");
			    break;
		       case GREEN:
			    System.out.println("Go! The light is green. " + currentLight.getDuration() + " seconds.");
			    break;
		     }
		 } catch (IllegalArgumentException e) {
			System.out.println("Invalid input! Please enter RED, YELLOW, or GREEN.");
		}
		scanner.close();
	}
}


