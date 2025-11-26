package Camera_Rental_Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class runnerclass {
	
	 static camera cam;
	
	public static void main(String[] args) {
		
		List<camera> cameraList=new ArrayList<>();
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("++------------------------------------++");
		System.out.println("WELCOME TO CAMERA RENTAL APP");
		System.out.println("++-------------------------------------++");
		
		while(true) {
		System.out.println("Please Login to Continue ");
		
		System.out.println("USERNAME : ");
		String userName=sc.next();
		
		System.out.println("Password : ");
		String passWord=sc.next();
		
		if(userName.equals("alex") && passWord.equals("camera")) {
			while(true) {
			System.out.println("\n 1. MY CAMERA \n 2. RENT A CAMERA \n 3. VIEW ALL CAMERAS \n 4. MY WALLET \n 5. EXIT");
			
			System.out.println();
			
			int option1=sc.nextInt();
			
			switch(option1) {
			case 1:
				System.out.println("\n 1. ADD \n 2. REMOVE \n 3. VIEW MY CAMERAS \n 4. GO TO PREVIOUS MENU");
					System.out.println("Enter : ");
					int addOption=sc.nextInt();
					switch(addOption) {
					case 1:
						System.out.println("Add A Camera");
					
					
						System.out.println("Enter the camera brand : ");
					
						String cameraBrand=sc.next();
					
						System.out.println("Enter the model : ");
						String model = sc.next();
					
						System.out.println("Enter the price per day : ");
						int pricePerDay=sc.nextInt();
					
						cam=new camera(cameraBrand,model,pricePerDay);
					
						cameraList.add(cam);
					
						System.out.println("Camera Successfully Added ::");
						break;
					
					case 2:
						if(cameraList.isEmpty()) {
							System.out.println("No Camera in the list");
						}else {
							System.out.println("Availabe Cameras : ");
							
					        System.out.println("------------------------------------------------------------------");
					        System.out.printf("%-5s %-15s %-15s %-10s%n", "No", "BRAND", "MODEL", "PRICE/DAY");
					        System.out.println("------------------------------------------------------------------");

					        cameraList.stream()
					            .map(c -> String.format("%-5d %-15s %-15s %-10d",
					                    cameraList.indexOf(c) + 1,
					                    c.getBrand(),
					                    c.getModel(),
					                    c.getPricePerDay()))
					            .forEach(System.out::println);

					        System.out.println("------------------------------------------------------------------");
							
							
						}
						
					}
			}
					break;
			}
			break;
		}else {
			System.out.println("------INVALID CREDENTIALS-------");
		}
		
		
		}
		
		
		
		
	}

}
