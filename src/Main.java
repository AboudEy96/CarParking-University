import Entity.User.User;
import Entity.User.UserFactory;
import Payment.PayPalGateway;
import Payment.PaymentGateway;
import Payment.StripeGateway;
import UserInterface.Screen;
import UserInterface.ScreenBuilder;
import Vehcile.Iterator;
import Vehcile.Vehicle;
import Vehcile.VehicleCollection;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.desktop.ScreenSleepEvent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = UserFactory.createUser("Customer");
        assert user != null;
        user.setName("ABD ELKADIR");
        User user1 = UserFactory.createUser("Customer");
        user1.setName("Mostafa");

        VehicleCollection vehicleCollection = new VehicleCollection();
        vehicleCollection.addVehicle(new Vehicle(1, "RangeRover", "2020", 10, user));
        vehicleCollection.addVehicle(new Vehicle(2, "Toyota", "2002", 5, user1));

        PaymentGateway stripeGateway = new StripeGateway();
        PaymentGateway paypalGateway = new PayPalGateway();

        JFrame frame = new ScreenBuilder("Car Parking System")
                .withLayout(new BorderLayout())
                .createPanel("box")
                .addVehicleList(vehicleCollection, stripeGateway, paypalGateway)
                .addButton("Quit", e -> System.exit(0))
                .build();
    }
}