package ticket_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicketManagementSystem {
// Static variables to store theater information and sales
private static final String theaterName = "Teatro Moro";
private static final int hallCapacity = 100;
private static int availableTickets = hallCapacity;
private static double totalRevenue = 0;

// Data structures to store sales details, seats, customers, and promotions
private static ArrayList<String> sales = new ArrayList<>();
private static ArrayList<String> seats = new ArrayList<>();
private static ArrayList<String> customers = new ArrayList<>();
private static ArrayList<String> promotions = new ArrayList<>();

// Maps to store event prices and seat types
private static final Map<String, Double> eventPrices = new HashMap<>();
static {
    eventPrices.put("Rolling Stones Concert", 15000.0);
    eventPrices.put("Don Quixote Theater Play", 10000.0);
    eventPrices.put("Chris Stapleton Concert", 12000.0);
    eventPrices.put("Phantom of the Opera", 13000.0);
}

private static final Map<String, Double> seatPrices = new HashMap<>();
static {
    seatPrices.put("VIP", 7000.0);
    seatPrices.put("Platea", 5000.0);
    seatPrices.put("Box", 3000.0);
}

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    boolean continueLoop = true;

    // Main loop for the interactive menu
    while (continueLoop) {
        displayMenu();

        int option;
        try { // Handling exceptions with 'try'
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Please enter a number.");
            continue;
        }
        
        // Evaluate the user's selected option
        switch (option) {
            case 1:
                // Process ticket sales
                sellTickets(scanner);
                break;
            case 2:
                // Display sales summary
                displaySalesSummary();
                break;
            case 3:
                // Generate receipt
                generateReceipt();
                break;
            case 4:
                // Calculate total revenue
                calculateTotalRevenue();
                break;
            case 5:
                // Exit the program
                continueLoop = false;
                System.out.println("Thank you for your purchase.");
                break;
            default:
                // Handle incorrect option
                System.out.println("Invalid option. Please select again.");
                break;
        }
    }
}

// Method to display the main menu
private static void displayMenu() {
    System.out.println("\n=== " + theaterName + " ===");
    System.out.println("1. Ticket Sales");
    System.out.println("2. View Sales Summary");
    System.out.println("3. Generate Receipt");
    System.out.println("4. Calculate Total Revenue");
    System.out.println("5. Exit");
    System.out.print("Select an option: ");
}

// Method to display sales summary
private static void displaySalesSummary() {
    System.out.println("\n=== Sales Summary ===");
    for (String sale : sales) {
        System.out.println(sale);
    }
}

// Method to generate a receipt with the sales summary
private static void generateReceipt() {
    System.out.println("\n=== Receipt ===");
    System.out.println("---------------------------------------");
    System.out.println("              " + theaterName);
    System.out.println("---------------------------------------");
    for (String sale : sales) {
        System.out.println(sale);
    }
    System.out.println("---------------------------------------");
    System.out.println("Total: $" + totalRevenue);
    System.out.println("Thank you for visiting " + theaterName);
    System.out.println("---------------------------------------");
}

// Method to calculate and display total revenue
private static void calculateTotalRevenue() {
    System.out.println("\n=== Total Revenue ===");
    System.out.println("Total Revenue: $" + totalRevenue);
}

// Method to add a sale to the sales list
    private static void addSale(String sale) {
        sales.add(sale);
    }
}
