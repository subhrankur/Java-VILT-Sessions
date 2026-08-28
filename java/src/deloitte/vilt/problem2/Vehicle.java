package deloitte.vilt.problem2;

public abstract class Vehicle {

    private String brand;
    private String model;
    private double mileage;

    public Vehicle(String brand, String model, double mileage) {
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getMileage() {
        return mileage;
    }

    public abstract double calculateTravelCost(double distance);

    public void displayBasicInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
    }
}