package electricity;

import java.util.Scanner;

public class ElectricityBillManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Customer[] customers = new Customer[100]; 
        int customerCount = 0;

        try {
            do {
                System.out.println("\nElectricity Bill Management System");
                System.out.println("1) ADD NEW CUSTOMER");
                System.out.println("2) RECORD METER READING");
                System.out.println("3) CALCULATE BILL AMOUNT");
                System.out.println("4) EXIT");
                System.out.print("ENTER YOUR CHOICE : ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("ENTER CUSTOMER NAME : ");
                        String name = scanner.next();
                        scanner.nextLine(); // Consume newline
                        System.out.print("ENTER CUSTOMER ADRESS : ");
                        String address = scanner.nextLine();
                        customers[customerCount++] = new Customer(name, address);
                        System.out.println("CUSTOMER ADDED SUCESSFULLY !");
                        break;
                    case 2:
                        System.out.print("ENTER CUSTOMER NAME : ");
                        String custName = scanner.next();
                        int index = findCustomerIndex(custName, customers, customerCount);
                        if (index != -1) {
                            System.out.print("ENTER METER READING : ");
                            int reading = scanner.nextInt();
                            customers[index].setMeterReading(reading);
                            System.out.println("METER READING RECORDED SUCESSFULLY !");
                        } else {
                            System.out.println("CUSTOMER NOT FOUND !");
                        }
                        break;
                    case 3:
                        System.out.print("ENTER CUSTOMER NAME : ");
                        String customerName = scanner.next();
                        
                        int idx = findCustomerIndex(customerName, customers, customerCount);
                        if (idx != -1) {
                            int units = customers[idx].getMeterReading();
                            double billAmount = BillCalculator.calculateBill(units);
                            System.out.println("Bill for " + customerName + " is: $" + billAmount);
                        } else {
                            System.out.println("CUSTOMER NOT FOUND !");
                        }
                        break;
                    case 4:
                        System.out.println("EXISTING THANKYOU FOR USING INDIAN ELECTRICITY...");
                        break;
                    default:
                        System.out.println("INVALID CHOICE! PLEASE ENTER A VALID OPTION.");
                }
            } while (choice != 4);
        } finally {
            scanner.close();
        }
    }

    private static int findCustomerIndex(String name, Customer[] customers, int customerCount) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
