package deloitte.vilt.problem2;

public class Car extends Vehicle {

    private double fuelPrice;

    public Car(String brand, String model, double mileage, double fuelPrice) {
        super(brand, model, mileage);
        this.fuelPrice = fuelPrice;
    }

    @Override
    public double calculateTravelCost(double distance) {

        double fuelRequired = distance / getMileage();
        double baseCost = fuelRequired * fuelPrice;

        return baseCost * 1.05;
    }
}