package cameraapp;

public class Camera {
	
	    private int cameraId;
	    private String brand;
	    private String model;
	    private float price;
	    private String status;

	    public Camera(int cameraId, String brand, String model, float price, String status) {
	        this.cameraId = cameraId;
	        this.brand = brand;
	        this.model = model;
	        this.price = price;
	        this.status = status;
	    }

	    public int getCameraId() { return cameraId; }
	    public String getBrand() { return brand; }
	    public String getModel() { return model; }
	    public float getPrice() { return price; }
	    public String getStatus() { return status; }

	    public void setCameraId(int cameraId) { this.cameraId = cameraId; }
	    public void setBrand(String brand) { this.brand = brand; }
	    public void setModel(String model) { this.model = model; }
	    public void setPrice(float price) { this.price = price; }
	    public void setStatus(String status) { this.status = status; }
	}


