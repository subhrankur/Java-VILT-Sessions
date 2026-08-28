package deloitte.vilt.problem2;

public class ElectricCar extends Vehicle {

    private double electricityPrice;

    public ElectricCar(
            String brand,
            String model,
            double efficiency,
            double electricityPrice) {

        super(brand, model, efficiency);
        this.electricityPrice = electricityPrice;
    }

    @Override
    public double calculateTravelCost(double distance) {

        double energyConsumed = distance / getMileage();

        return energyConsumed * electricityPrice;
    }

    @Override
    public void displayBasicInfo() {

        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Efficiency: " + getMileage() + " km/kWh");
    }
}