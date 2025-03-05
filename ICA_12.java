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
		default:
			System.out.println("Invalid color entered.");
		}

		scanner.close();
	}
}
