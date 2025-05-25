package Vehcile;

import Entity.User.User;

import java.util.Date;

public class Vehicle {
    int id;
    String brand;
    String model;
    double PricePerDay;
    User owner;
    private Date entryTime;
    private Date exitTime;
    private boolean isPaid;

    public Vehicle(int id, String brand, String model, double PricePerDay, User owner) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.PricePerDay = PricePerDay;
        this.owner = owner;
        this.entryTime = new Date();
        this.isPaid = false;

    }
    public String getName() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getId() {
        return id;
    }
    public double getPricePerDay() {
        return PricePerDay;
    }
    public User getOwner() {
        return owner;
    }
    @Override
    public String toString() {
        return "id=" + id + " brand=" + brand + " model=" + model + " PricePerDay=" + PricePerDay + " Owner=" + owner;
    }
    public void setExitTime(Date exitTime) { this.exitTime = exitTime; }
    public void markAsPaid() { this.isPaid = true; }
    public double calculateParkingFee() {
        long hours = (exitTime.getTime() - entryTime.getTime()) / (1000 * 60 * 60);
        return hours * 5;
    }

}
