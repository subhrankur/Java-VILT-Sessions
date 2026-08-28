package deloitte.vilt.problem1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        double distance = 300;
        double fuelPrice = 100;

        Vehicle vehicleReference = new Suv("Toyota", "Fortuner", 12);

        System.out.println("Type: " + vehicleReference.getClass().getSimpleName());
        System.out.println("Travel Cost: " + vehicleReference.calculateTravelCost(distance, fuelPrice));


        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("Tata", "Ace", 20));
        vehicles.add(new Car("Honda", "City", 18));
        vehicles.add(new Suv("Toyota", "Fortuner", 12));
        vehicles.add(new Car("Hyundai", "Verna", 18));
        vehicles.add(new Suv("Mahindra", "XUV700", 12));

        for (Vehicle currentVehicle : vehicles) {

            currentVehicle.displayInfo();
            
            System.out.println("Type: " + currentVehicle.getClass().getSimpleName());
            System.out.println("Travel Cost: " + currentVehicle.calculateTravelCost(distance, fuelPrice));
        }
    }
}