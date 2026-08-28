package deloitte.vilt.problem2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        double distance = 300;
        double fuelPrice = 100;
        double electricityPrice = 10;


        Vehicle car = new Car("Honda", "City", 18, fuelPrice);
        Vehicle suv = new Suv("Toyota", "Fortuner", 12, fuelPrice);
        Vehicle electricCar = new ElectricCar("Tata", "Nexon EV", 6, electricityPrice);

        
        car.displayBasicInfo();
        System.out.println("Mileage: " + car.getMileage() + " km/l");
        System.out.println("Travel Cost: " + car.calculateTravelCost(distance));


        suv.displayBasicInfo();
        System.out.println("Mileage: " + suv.getMileage() + " km/l");
        System.out.println("Travel Cost: " + suv.calculateTravelCost(distance));


        electricCar.displayBasicInfo();
        System.out.println("Travel Cost: " + electricCar.calculateTravelCost(distance));


        Vehicle vehicle = new Suv("Toyota", "Fortuner", 12, fuelPrice);

        System.out.println("Actual Type: " + vehicle.getClass().getSimpleName());
        System.out.println("Travel Cost: " + vehicle.calculateTravelCost(distance));


        vehicle = new ElectricCar("Tata", "Nexon EV", 6, electricityPrice);

        System.out.println("Actual Type: " + vehicle.getClass().getSimpleName());
        System.out.println("Travel Cost: " + vehicle.calculateTravelCost(distance));


        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Honda", "City", 18, fuelPrice));
        vehicles.add(new Suv("Toyota", "Fortuner", 12, fuelPrice));
        vehicles.add(new ElectricCar("Tata", "Nexon EV", 6, electricityPrice));
        vehicles.add(new Car("Hyundai", "Verna", 18, fuelPrice));
        vehicles.add(new Suv("Mahindra", "XUV700", 12, fuelPrice));

        for (Vehicle currentVehicle : vehicles) {

            currentVehicle.displayBasicInfo();
            System.out.println("Type: " + currentVehicle.getClass().getSimpleName());
            System.out.println("Travel Cost: " + currentVehicle.calculateTravelCost(distance));
        }
    }
}