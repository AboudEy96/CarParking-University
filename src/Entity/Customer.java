package Entity;

import Entity.User.User;

public class Customer extends User {

    @Override
    public void getUserInfo() {
        System.out.println(getRole());
        System.out.print("Name: " + getName() + " ID: "+ getId() + " Phone: " + getPhoneNO());
    }

    public String getRole() {
        return "CUSTOMER";
    }

    public void browseCars() {

    }
    public void reserveCar() {

    }
}
