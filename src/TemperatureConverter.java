import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {

        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32;
        }
        else {
            return (temperature - 32) * 5.0 / 9.0;
        }
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        String userInput = "";
        boolean keepGoing = true;

        while (keepGoing) {

            System.out.print("Enter a temperature value or type stop to quit: ");

            if (scnr.hasNextDouble()) {

                double temperature = scnr.nextDouble();
                scnr.nextLine();

                String unit = "";

                while (!(unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F"))) {

                    System.out.print("Enter the unit (C or F): ");
                    unit = scnr.nextLine();

                    if (!(unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F"))) {
                        System.out.println("Error: Invalid unit.");
                    }
                }

                double convertedTemp =
                        convertTemperature(temperature, unit);

                if (unit.equalsIgnoreCase("C")) {
                    System.out.printf("%.2f C is equal to %.2f F%n",
                            temperature, convertedTemp);
                }
                else {
                    System.out.printf("%.2f F is equal to %.2f C%n",
                            temperature, convertedTemp);
                }
            }
            else {

                userInput = scnr.nextLine();

                if (userInput.equalsIgnoreCase("stop")) {
                    keepGoing = false;
                }
                else {
                    System.out.println("Error: Invalid temperature input.");
                }
            }
        }

        System.out.println("Program ended.");
    }
}