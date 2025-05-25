package Vehcile;

import java.util.ArrayList;
import java.util.List;

public class VehicleCollection implements VehicleList {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public Iterator createIterator() {
        return new VehicleIterator(vehicles);
    }
}