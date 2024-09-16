package BankAccount;

import java.util.Scanner;

public class BankAccount {
	private String customerName;
	private String customerId;
    private double balance;
    private double previousTransaction;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            previousTransaction = -amount;
            System.out.println("WITHDRAWAL SUCCESSFUL");
        } else {
            System.out.println("INSUFFICIENT BALANCE OR INVALID AMOUNT");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("DEPOSIT: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("WITHDRAWAL: " + Math.abs(previousTransaction));
        } else {
            System.out.println("NO TRANSACTION OCCURRED");
        }
    }

    public void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("YOUR ID: " + customerId);
        System.out.println("\n");
        System.out.println("a) CHECK BALANCE");
        System.out.println("b) DEPOSIT AMOUNT");
        System.out.println("c) WITHDRAW AMOUNT");
        System.out.println("d) PREVIOUS TRANSACTION");     
        System.out.println("e) EXIT");                  

        do {
            System.out.println("***************************************************************");                                
            System.out.print("CHOOSE AN OPTION : ");   
            option = sc.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'a':
                    System.out.println(".......");
                    System.out.println("BALANCE = " + balance);
                    System.out.println(".......");
                    System.out.println("\n");
                    break;

                case 'b':
                    System.out.println(".......");
                    System.out.print("ENTER AN AMOUNT TO DEPOSIT: ");
                    System.out.println(".......");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;

                case 'c':
                    System.out.println(".......");
                    System.out.println("ENTER AN AMOUNT TO WITHDRAW: ");
                    System.out.println(".......");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;

                case 'd':
                    System.out.println(".......");
                    System.out.println("PREVIOUS TRANSACTION: ");
                    getPreviousTransaction();
                    System.out.println(".......");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("THANK YOU FOR USING OUR BANKING SERVICES");
                    break;

                default:
                    System.out.println("CHOOSE THE CORRECT OPTION TO PROCEED");
                    break;
            }
        } while (option != 'e');
        sc.close();  
    }
}
