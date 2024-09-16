package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SupermarketBillingSoftware {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> cart = new ArrayList<>();

        int choice;
        try {
            do {
                System.out.println("\nSUPERMARKET BILLING SOFTWARE");
                System.out.println("1) ADD ITEM TO CART");
                System.out.println("2) GENERATE BILL");
                System.out.println("3) THANKYOU FOR YOUR PURCHASE PLEASE VISIT AGAIN...");
                System.out.print("ENTER YOUR CHOICE: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addItemToCart(scanner, cart);
                        break;
                    case 2:
                        generateBill(cart);
                        break;
                    case 3:
                        System.out.println("EXISTING...");
                        break;
                    default:
                        System.out.println("INVALID CHOICE ! PLEASE ENTER A VALID OPTION.");
                }
            } while (choice != 3);
        } finally {
            scanner.close();
        }
    }

    private static void addItemToCart(Scanner scanner, ArrayList<Item> cart) {
        System.out.print("ENTER ITEM NAME : ");
        String name = scanner.next();
        System.out.print("ENTER ITEM PRICE : ");
        double price = scanner.nextDouble();
        System.out.print("ENTER ITEM QUANTITY : ");
        int quantity = scanner.nextInt();
        cart.add(new Item(name, price, quantity));
        System.out.println("ITEM ADDED TO CART SUCESSFULLY!");
    }

    private static void generateBill(ArrayList<Item> cart) {
        if (cart.isEmpty()) {
            System.out.println("CART IS EMPTY. PLEASE ADD ITEMS FIRST.");
            return;
        }

        System.out.println("\nGENERATING BILL...");
        double totalBill = 0;
        System.out.println("\n--- RECEIPT ---");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "ITEM", "PRICE", "QUANTITY", "TOTAL");
        System.out.println("------------------------------------------------------------");
        for (Item item : cart) {
            System.out.printf("%-20s $%-9.2f %-10d $%-9.2f\n", item.name, item.price, item.quantity, item.getTotalPrice());
            totalBill += item.getTotalPrice();
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("Total Bill: $%.2f\n", totalBill);
        System.out.println("------------------------------------------------------------");
        System.out.println("THANK YOU FOR SHOPPING WITH US !");
        cart.clear(); 
    }
}
