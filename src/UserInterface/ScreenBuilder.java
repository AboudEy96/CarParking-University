package UserInterface;

import Entity.Customer;
import Payment.*;
import Vehcile.*;
import Entity.User.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScreenBuilder {
    private final JFrame frame;
    private JPanel currentPanel;

    public ScreenBuilder(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        currentPanel = new JPanel();
        frame.add(currentPanel, BorderLayout.CENTER);
    }

    public ScreenBuilder createPanel(String layout) {
        currentPanel = new JPanel();
        switch (layout.toLowerCase()) {
            case "flow" -> currentPanel.setLayout(new FlowLayout());
            case "box" -> currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.Y_AXIS));
            case "grid" -> currentPanel.setLayout(new GridLayout(0, 1));
            default -> currentPanel.setLayout(new BorderLayout());
        }
        frame.add(currentPanel, BorderLayout.CENTER);
        return this;
    }

    public ScreenBuilder withLayout(LayoutManager manager) {
        frame.setLayout(manager);
        return this;
    }

    public ScreenBuilder addButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(33, 150, 243));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(listener);
        currentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        currentPanel.add(button);
        return this;
    }

    public ScreenBuilder addLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(label);
        return this;
    }

    public ScreenBuilder addVehicleList(VehicleCollection vehicleCollection,
                                        PaymentGateway stripeGateway,
                                        PaymentGateway paypalGateway) {
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BoxLayout(vehiclePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(vehiclePanel);
        scrollPane.setPreferredSize(new Dimension(850, 400));

        JLabel titleLabel = new JLabel("Cars in Park", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        vehiclePanel.add(titleLabel);
        vehiclePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        renderVehicles(vehicleCollection, vehiclePanel, stripeGateway, paypalGateway);

        JButton addCarButton = new JButton("Add New Car");
        addCarButton.setFont(new Font("Arial", Font.BOLD, 14));
        addCarButton.setBackground(new Color(76, 175, 80));
        addCarButton.setForeground(Color.WHITE);
        addCarButton.setFocusPainted(false);
        addCarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addCarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addCarButton.addActionListener(e -> {
            Vehicle newVehicle = createNewVehicleDialog(vehicleCollection);
            if (newVehicle != null) {
                vehicleCollection.addVehicle(newVehicle);
                vehiclePanel.removeAll();
                renderVehicles(vehicleCollection, vehiclePanel, stripeGateway, paypalGateway);
                vehiclePanel.revalidate();
                vehiclePanel.repaint();
            }
        });

        currentPanel.add(scrollPane);
        currentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        currentPanel.add(addCarButton);

        return this;
    }

    private void renderVehicles(VehicleCollection vehicleCollection,
                                JPanel vehiclePanel,
                                PaymentGateway stripeGateway,
                                PaymentGateway paypalGateway) {
        Iterator iterator = vehicleCollection.createIterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = (Vehicle) iterator.next();

            JPanel carPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            carPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            carPanel.setMaximumSize(new Dimension(800, 100));
            carPanel.setBackground(new Color(250, 250, 250));

            JLabel carLabel = new JLabel(
                    "<html><b>" + vehicle.getName() + "</b> (" + vehicle.getModel() + ")<br>" +
                            "Owner: " + vehicle.getOwner().getName() + "<br>" +
                            "Price/Day: <font color='green'>$" + vehicle.getPricePerDay() + "</font></html>");

            JButton infoButton = new JButton("Info");
            styleSmallButton(infoButton);
            infoButton.addActionListener(e -> showVehicleInfo(vehicle));

            JButton payButton = new JButton("Pay");
            styleSmallButton(payButton);
            payButton.addActionListener(e -> showPaymentOptions(vehicle, stripeGateway, paypalGateway));

            carPanel.add(carLabel);
            carPanel.add(Box.createHorizontalStrut(20));
            carPanel.add(infoButton);
            carPanel.add(payButton);

            vehiclePanel.add(carPanel);
            vehiclePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
    }

    private void styleSmallButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setBackground(new Color(3, 169, 244));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private Vehicle createNewVehicleDialog(VehicleCollection collection) {
        JTextField nameField = new JTextField(10);
        JTextField modelField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField ownerField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Car Name:")); panel.add(nameField);
        panel.add(new JLabel("Model:")); panel.add(modelField);
        panel.add(new JLabel("Price/Day:")); panel.add(priceField);
        panel.add(new JLabel("Owner Name:")); panel.add(ownerField);

        int result = JOptionPane.showConfirmDialog(frame, panel,
                "Add New Vehicle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = collection.getVehicles().size() + 1;
                double price = Double.parseDouble(priceField.getText());
                User owner = new Customer();
                owner.setName(ownerField.getText());
                return new Vehicle(id, nameField.getText(), modelField.getText(), price, owner);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    private void showVehicleInfo(Vehicle vehicle) {
        JOptionPane.showMessageDialog(frame,
                "Car Information:\n" +
                        "Name: " + vehicle.getName() + "\n" +
                        "Model: " + vehicle.getModel() + "\n" +
                        "Owner: " + vehicle.getOwner().getName() + "\n" +
                        "Price/Day: $" + vehicle.getPricePerDay(),
                "Vehicle Info",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPaymentOptions(Vehicle vehicle, PaymentGateway stripe, PaymentGateway paypal) {
        JDialog dialog = new JDialog(frame, "Choose Payment Method", true);
        dialog.setSize(400, 250);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
        dialog.getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Pay for " + vehicle.getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JLabel priceLabel = new JLabel("Price per Day: $" + vehicle.getPricePerDay());
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);

        JButton stripeButton = new JButton("Pay with Stripe");
        stripeButton.setBackground(new Color(88, 86, 214));
        stripeButton.setForeground(Color.WHITE);
        stripeButton.setFocusPainted(false);

        JButton paypalButton = new JButton("Pay with PayPal");
        paypalButton.setBackground(new Color(0, 119, 181));
        paypalButton.setForeground(Color.WHITE);
        paypalButton.setFocusPainted(false);

        stripeButton.addActionListener(e -> {
            payAndClose(vehicle, stripe, dialog);
        });

        paypalButton.addActionListener(e -> {
            payAndClose(vehicle, paypal, dialog);
        });

        buttonPanel.add(stripeButton);
        buttonPanel.add(paypalButton);

        dialog.add(titleLabel);
        dialog.add(priceLabel);
        dialog.add(Box.createRigidArea(new Dimension(0, 10)));
        dialog.add(buttonPanel);

        dialog.setVisible(true);
    }

    private void payAndClose(Vehicle vehicle, PaymentGateway gateway, JDialog dialog) {
        String cardNumber = "4111111111111111";  // Simulated
        String cardHolder = vehicle.getOwner().getName();

        Payment payment = new CreditCardPayment(gateway, cardNumber, cardHolder);
        payment.makePayment(vehicle.getPricePerDay());

        dialog.dispose();

        JOptionPane.showMessageDialog(frame,
                "Payment of $" + vehicle.getPricePerDay() + " completed successfully!",
                "Payment Successful",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public JFrame build() {
        frame.setVisible(true);
        return frame;
    }
}
