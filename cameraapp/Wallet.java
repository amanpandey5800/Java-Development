package cameraapp;

import java.util.Scanner;

public class Wallet {
    static Scanner sc = new Scanner(System.in);

    public static float manageWallet(float balance) {
        while (true) {
            System.out.println("1. View Balance");
            System.out.println("2. Add Money");
            System.out.println("3. Back");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("💰 Wallet Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to add: ₹");
                    float amount = sc.nextFloat();
                    balance += amount;
                    System.out.println("✅ ₹" + amount + " added.");
                    break;

                case 3:
                    return balance;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println();
        }
    }
}
