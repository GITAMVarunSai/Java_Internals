import java.util.Scanner;

public class SmartThermostat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking temperature input
        System.out.print("Enter current temperature (°C): ");
        int temperature = scanner.nextInt();

        // Determine action based on temperature
        String action;
        if (temperature > 28) {
            action = "TURN_ON_AC";
        } else if (temperature >= 22 && temperature <= 28) {
            action = "MAINTAIN";
        } else {
            action = "TURN_ON_HEATER";
        }

        // Switch-case to display appropriate action
        switch (action) {
            case "TURN_ON_AC":
                System.out.println("Temperature is high! Turning on AC...");
                break;
            case "MAINTAIN":
                System.out.println("Temperature is optimal. Maintaining current state.");
                break;
            case "TURN_ON_HEATER":
                System.out.println("Temperature is low! Turning on Heater...");
                break;
            default:
                System.out.println("Invalid input.");
        }

        scanner.close();
    }
}


//output

Enter current temperature (°C): 30
Temperature is high! Turning on AC...

//output

Enter current temperature (°C): 25
Temperature is optimal. Maintaining current state.


//output

Enter current temperature (°C): 18
Temperature is low! Turning on Heater...
