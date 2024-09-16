package BankAccount;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER YOUR 'NAME' : ");
        String name=sc.nextLine();
        System.out.print("ENTER YOUR 'CUSTOMER ID' : ");
        String customerId = sc.nextLine();
        BankAccount account = new BankAccount(name, customerId);
        account.menu();
        sc.close();  
    }
}
