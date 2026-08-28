package deloitte.vilt.problem2;

public class Suv extends Car {

    public Suv(String brand, String model, double mileage, double fuelPrice) {
        super(brand, model, mileage, fuelPrice);
    }

    @Override
    public double calculateTravelCost(double distance) {

        double carCost = super.calculateTravelCost(distance);
        double baseCost = carCost / 1.05;

        return baseCost * 1.15;
    }
}