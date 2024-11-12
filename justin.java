public class Main {

    // Hardcoded temperature data based on your original input
    static int[][] temperatures = {
        {22, 25, 29, 35, 24},  // Monday
        {25, 20, 26, 35, 28},  // Tuesday
        {24, 21, 35, 30, 29},  // Wednesday
        {22, 25, 25, 29, 20},  // Thursday
        {30, 25, 22, 31, 26},  // Friday
        {26, 21, 25, 33, 34},  // Saturday
        {33, 27, 30, 29, 27}   // Sunday
    };

    static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static String[] cities = {"Tacloban", "Bohol", "Manila", "Japan", "Cebu"};

    public static void main(String[] args) {
        displayTemperatures();
        averageTemperaturePerCity();
        hottestDay();
        coldestDay();
    }

    // Method to display temperatures in a table format
    public static void displayTemperatures() {
        System.out.println("Temperatures (°C):");
        System.out.print("           ");
        for (String city : cities) {
            System.out.printf("%8s", city); // Print city names aligned
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.printf("%-10s", days[i]); // Print day names with spacing
            for (int j = 0; j < 5; j++) {
                System.out.printf("%8d", temperatures[i][j]); // Print temperature values aligned
            }
            System.out.println();
        }
    }

    // Method to calculate and print average temperature for each city
    public static void averageTemperaturePerCity() {
        System.out.println("\nAverage Temperature per City:");
        for (int city = 0; city < 5; city++) {
            int sum = 0;
            for (int day = 0; day < 7; day++) {
                sum += temperatures[day][city]; // Sum temperatures for the current city
            }
            double avg = sum / 7.0; // Use 7.0 for floating-point division
            System.out.printf("%-10s: %.2f°C%n", cities[city], avg); // Print average with two decimal places
        }
    }

    // Method to find and print the hottest day and city
    public static void hottestDay() {
        int maxTemp = Integer.MIN_VALUE;
        String hottestDay = "";
        String hottestCity = "";

        // Iterate over all days and cities to find the hottest day
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (temperatures[i][j] > maxTemp) {
                    maxTemp = temperatures[i][j];
                    hottestDay = days[i];
                    hottestCity = cities[j];
                }
            }
        }

        // Output the hottest day and city
        System.out.printf("\nHottest Day: %s, %s with %d°C%n", hottestDay, hottestCity, maxTemp);
    }

    // Method to find and print the coldest day and city
    public static void coldestDay() {
        int minTemp = Integer.MAX_VALUE;
        String coldestDay = "";
        String coldestCity = "";

        // Iterate over all days and cities to find the coldest day
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (temperatures[i][j] < minTemp) {
                    minTemp = temperatures[i][j];
                    coldestDay = days[i];
                    coldestCity = cities[j];
                }
            }
        }

        // Output the coldest day and city
        System.out.printf("\nColdest Day: %s, %s with %d°C%n", coldestDay, coldestCity, minTemp);
    }
}
