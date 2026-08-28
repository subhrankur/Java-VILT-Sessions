package deloitte.vilt.problem1;

public class Car extends Vehicle {

    public Car(String brand, String model, double mileage) {
        super(brand, model, mileage);
    }

    @Override
    public double calculateTravelCost(double distance, double fuelPrice) {
        double baseCost = super.calculateTravelCost(distance, fuelPrice);
        return baseCost * 1.05;
    }
}