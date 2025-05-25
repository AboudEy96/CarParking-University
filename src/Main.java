import Entity.User.User;
import Entity.User.UserFactory;
import UserInterface.Screen;
import UserInterface.ScreenBuilder;
import Vehcile.Iterator;
import Vehcile.Vehicle;
import Vehcile.VehicleCollection;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.desktop.ScreenSleepEvent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      /*  JFrame frame = new JFrame();
        JButton button = new JButton();
        button.setText("uwu");
        button.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(button);
        frame.setVisible(true);*/

        User user = UserFactory.createUser("Customer");
        assert user != null;
        user.setName("test");
        JFrame frame = new ScreenBuilder("Menu")
                .addButton("uwu")
                .addButton("test")
                .addButton("gwgwgw").build();
        user.getUserInfo();


        VehicleCollection vehicleCollection = new VehicleCollection();
        vehicleCollection.addVehicle(new Vehicle(1, "RangeRover", "2020", 10));
        vehicleCollection.addVehicle(new Vehicle(1, "UwU", "2002", 5));
        Iterator iterator = vehicleCollection.createIterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = (Vehicle) iterator.next();
            System.out.println(vehicle);

        }
    }
}