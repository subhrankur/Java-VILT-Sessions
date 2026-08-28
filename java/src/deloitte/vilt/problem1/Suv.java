package deloitte.vilt.problem1;

public class Suv extends Car {

    public Suv(String brand, String model, double mileage) {
        super(brand, model, mileage);
    }

    @Override
    public double calculateTravelCost(double distance, double fuelPrice) {
        
        double carCost = super.calculateTravelCost(distance, fuelPrice);
        double baseCost = carCost / 1.05;

        return baseCost * 1.15;
    }
}