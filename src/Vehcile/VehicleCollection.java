package Vehcile;

import Notifactions.Observer;
import Notifactions.Subject;

import java.util.ArrayList;
import java.util.List;

public class VehicleCollection implements VehicleList, Subject {
    private List<Vehicle> vehicles = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        notifyObservers("New vehicle added: " + vehicle.getName());
    }
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    @Override
    public Iterator createIterator() {
        return new VehicleIterator(vehicles);
    }
}