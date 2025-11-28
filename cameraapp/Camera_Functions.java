package cameraapp;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Camera_Functions {
    static Scanner sc = new Scanner(System.in);

    public static void manageCamera(TreeMap<Integer, Camera> cameraMap) {
        while (true) {
            System.out.println("1. Add Camera");
            System.out.println("2. Remove Camera");
            System.out.println("3. View All Cameras");
            System.out.println("4. Back");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Brand: ");
                    String brand = sc.next();
                    System.out.print("Enter Model: ");
                    String model = sc.next();
                    System.out.print("Enter Price: ");
                    float price = sc.nextFloat();
                    cameraMap.put(id, new Camera(id, brand, model, price, "AVAILABLE"));
                    System.out.println("✅ Camera added.");
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = sc.nextInt();
                    if (cameraMap.containsKey(removeId)) {
                        cameraMap.remove(removeId);
                        System.out.println("✅ Camera removed.");
                    } else {
                        System.out.println("⚠️ ID not found.");
                    }
                    break;

                case 3:
                    viewAllCameras(cameraMap);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    public static void viewAllCameras(TreeMap<Integer, Camera> cameraMap) {
        System.out.println();
        System.out.println("+----------+---------------+---------------+------------+------------+");
        System.out.printf("| %-8s | %-13s | %-13s | %-10s | %-10s |\n",
                "ID", "Brand", "Model", "Price", "Status");
        System.out.println("+----------+---------------+---------------+------------+------------+");

        for (Camera cam : cameraMap.values()) {
            System.out.printf("| %-8d | %-13s | %-13s | %-10.2f | %-10s |\n",
                    cam.getCameraId(), cam.getBrand(), cam.getModel(), cam.getPrice(), cam.getStatus());
        }

        System.out.println("+----------+---------------+---------------+------------+------------+");
        System.out.println();

        if (cameraMap.isEmpty()) {
            System.out.println("|          No Data Present at This Moment.           |");
            System.out.println("+----------------------------------------------------+");
        }
    }

    public static float rentCamera(TreeMap<Integer, Camera> cameraMap, float walletBalance) {
        TreeMap<Integer, Camera> available = new TreeMap<>();
        for (Map.Entry<Integer, Camera> entry : cameraMap.entrySet()) {
            if ("AVAILABLE".equals(entry.getValue().getStatus())) {
                available.put(entry.getKey(), entry.getValue());
            }
        }

        viewAllCameras(available);
        System.out.print("Enter Camera ID to rent: ");
        int id = sc.nextInt();

        if (available.containsKey(id)) {
            Camera cam = cameraMap.get(id);
            if (cam.getPrice() <= walletBalance) {
                cam.setStatus("RENTED");
                walletBalance -= cam.getPrice();
                System.out.println("✅ Rented " + cam.getBrand() + " " + cam.getModel());
            } else {
                System.out.println("❌ Insufficient balance.");
            }
        } else {
            System.out.println("⚠️ Camera not available.");
        }

        return walletBalance;
    }
}