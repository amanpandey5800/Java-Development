package Camera_Rental_Application;

public class camera {
	String brand;
	String model;
	int pricePerDay;
	
	camera(String b, String m, int price){
		this.brand=b;
		this.model=m;
		this.pricePerDay=price;
	
	}
	
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

}
