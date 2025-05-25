package Vehcile;

import java.util.List;

public class VehicleIterator implements Iterator {
    private List<Vehicle> vehicles;
    private int position = 0;

    public VehicleIterator(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean hasNext() {
        return position < vehicles.size();
    }

    @Override
    public Vehicle next() {
        if (!hasNext()) {
            throw new RuntimeException("No more vehicles");
        }
        Vehicle vehicle = vehicles.get(position);
        position++;
        return vehicle;
    }
}

