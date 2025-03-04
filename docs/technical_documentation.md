
# Technical Documentation: Ticket Sales Management System

## Code Structure
The project consists of a Java program that simulates a **theater ticket sales system**. It uses **maps (`HashMap`)** for efficient storage of event details and pricing.

### Global Variables
- `theaterName`: The name of the theater.
- `totalRevenue`: Stores the total income from ticket sales.
- `availableTickets`: Tracks the number of available tickets.
- `sales`: A list that stores all sales transactions.

### Data Structures Used
- `HashMap<String, Double>`: Stores **event names with prices** and **seat types with their respective prices**.
- `ArrayList<String>`: Stores **sales records** for reporting purposes.

### Key Methods
1. `sellTickets(Scanner scanner)`: Handles ticket sales and applies discounts.
2. `displaySalesSummary()`: Displays all recorded sales.
3. `generateReceipt()`: Generates a formatted receipt for purchases.
4. `calculateTotalRevenue()`: Computes and displays total revenue from all sales.

## Expected Output Example
If a user selects **option 4 (Calculate Total Revenue)** after making multiple sales, the output might look like this:
=== Total Revenue === Total Revenue: $35000


## How the System Works
1. The user selects an **event** from a list.
2. The user selects a **seat type** with its corresponding price.
3. A **discount** is applied if the user is a student or a senior citizen.
4. The system calculates the **final price** and records the sale.
5. The number of **available tickets** is updated.
6. The user can **view sales summaries**, **generate receipts**, or **calculate total revenue**.

## Compilation & Execution
To compile and run the project, use the following commands:

```bash
javac src/TicketManagementSystem.java
java src.TicketManagementSystem

This script will create **docs/technical_documentation.md** in a **single execution** with all the necessary information. 🚀 Let me know if you need any changes!








