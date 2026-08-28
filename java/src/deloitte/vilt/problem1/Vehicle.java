package deloitte.vilt.problem1;

public class Vehicle {
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

    public double calculateTravelCost(double distance, double fuelPrice) {
        double fuelRequired = distance / mileage;
        return fuelRequired * fuelPrice;
    }

    public void displayInfo() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Mileage: " + getMileage() + " km/l");
    }
}