package menuItems;

import java.util.Scanner;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nRestaurant Management System");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Search Menu Item");
            System.out.println("4. Display Menu");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter item quantity: ");
                    String description = scanner.nextLine();
                    MenuItem newItem = new MenuItem(name, price, description);
                    restaurant.addMenuItem(newItem);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = scanner.nextLine();
                    restaurant.removeMenuItem(removeName);
                    if (removeName != null) {
                        System.out.println("Item found: " + removeName);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter item name to search: ");
                    String searchName = scanner.nextLine();
                    MenuItem item = restaurant.searchMenuItem(searchName);
                    if (item != null) {
                        System.out.println("Item found: " + item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    restaurant.displayMenu();
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
