package Entity.Admin;

import Entity.User.User;
import Vehcile.Vehicle;

public class Admin extends User {

    public void getUserInfo() {
        System.out.println(getRole());
        System.out.print("Name: " + getName() + "ID:"+ getId() + "Phone:" + getPhoneNO());
    }
    public String getRole() {
        return "ADMIN";
    }

    public void addVehicle() {
    }
    public void removeVehicle() {

    }
    public void updateVehicle() {

    }
}
