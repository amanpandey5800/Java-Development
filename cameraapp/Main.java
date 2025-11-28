package cameraapp;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Camera> cameraMap = new TreeMap<>();
        float walletBalance = 100.0f;

        cameraMap.put(11, new Camera(11, "Something", "Some", 200.0f, "RENTED"));
        cameraMap.put(12, new Camera(12, "Some", "Another", 100.0f, "AVAILABLE"));
        cameraMap.put(14, new Camera(14, "NIKON", "DSLR-D700", 500.0f, "AVAILABLE"));
        cameraMap.put(17, new Camera(17, "Samsung", "SM123", 200.0f, "AVAILABLE"));
        cameraMap.put(19, new Camera(19, "SONY", "SONY1234", 123.0f, "RENTED"));
        cameraMap.put(15, new Camera(15, "Sony", "DSLR12", 200.0f, "AVAILABLE"));
        cameraMap.put(20, new Camera(20, "Canon", "5030", 25000.0f, "AVAILABLE"));
        cameraMap.put(21, new Camera(21, "Nikon", "2030", 500.0f, "AVAILABLE"));

        System.out.println("+------------------------------------------+");
        System.out.println("|      Welcome to Camera Rental App        |");
        System.out.println("+------------------------------------------+");
        System.out.print("Enter Username: ");
        String uname = sc.next();
        System.out.print("Enter Password: ");
        String pwd = sc.next();
        System.out.println();

        if (uname.equals("admin") && pwd.equals("admin123")) {
            while (true) {
                System.out.println("1. My Camera");
                System.out.println("2. Rent Camera");
                System.out.println("3. View All Cameras");
                System.out.println("4. My Wallet");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int option = sc.nextInt();
                System.out.println();

                switch (option) {
                    case 1:
                        Camera_Functions.manageCamera(cameraMap);
                        break;

                    case 2:
                        walletBalance = Camera_Functions.rentCamera(cameraMap, walletBalance);
                        break;

                    case 3:
                        Camera_Functions.viewAllCameras(cameraMap);
                        break;

                    case 4:
                        walletBalance = Wallet.manageWallet(walletBalance);
                        break;

                    case 5:
                        System.out.println("👋 Exiting. Thank you!");
                        return;

                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        } else {
            System.out.println("❌ Invalid credentials.");
        }

        sc.close();
    }
}