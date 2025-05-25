package UserInterface;

import Payment.*;
import Vehcile.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScreenBuilder {
    private final JFrame frame;
    private JPanel currentPanel;

    private static final Color PRIMARY = new Color(0x3498DB);
    private static final Color SUCCESS = new Color(0x2ECC71);
    private static final Color BACKGROUND = new Color(0xECF0F1);
    private static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 22);

    public ScreenBuilder(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(BACKGROUND);
        currentPanel = new JPanel();
        frame.add(currentPanel, BorderLayout.CENTER);
    }

    public ScreenBuilder createPanel(String layout) {
        currentPanel = new JPanel();
        currentPanel.setBackground(BACKGROUND);
        switch (layout.toLowerCase()) {
            case "flow":
                currentPanel.setLayout(new FlowLayout());
                break;
            case "box":
                currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.Y_AXIS));
                break;
            case "grid":
                currentPanel.setLayout(new GridLayout(0, 1));
                break;
            default:
                currentPanel.setLayout(new BorderLayout());
                break;
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
        styleButton(button, PRIMARY);
        button.addActionListener(listener);
        currentPanel.add(button);
        return this;
    }

    public ScreenBuilder addLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(DEFAULT_FONT);
        currentPanel.add(label);
        return this;
    }

    public ScreenBuilder addComponent(Component component, String constraint) {
        frame.add(component, constraint);
        return this;
    }

    public ScreenBuilder addVehicleList(VehicleCollection vehicleCollection,
                                        PaymentGateway stripeGateway,
                                        PaymentGateway paypalGateway) {
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BoxLayout(vehiclePanel, BoxLayout.Y_AXIS));
        vehiclePanel.setBackground(Color.WHITE);
        vehiclePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(vehiclePanel);
        scrollPane.setBorder(null);

        JLabel titleLabel = new JLabel("Cars in Park");
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(new Color(0x2C3E50));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        vehiclePanel.add(titleLabel);
        vehiclePanel.add(Box.createRigidArea(new Dimension(0, 15)));

        Iterator iterator = vehicleCollection.createIterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = (Vehicle) iterator.next();

            JPanel carPanel = new JPanel(new BorderLayout(10, 10));
            carPanel.setMaximumSize(new Dimension(750, 100));
            carPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0xBDC3C7), 1, true),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            carPanel.setBackground(BACKGROUND);

            JLabel carLabel = new JLabel(
                    "<html><b style='font-size:13px'>" + vehicle.getName() + "</b> (" + vehicle.getModel() + ")<br>" +
                            "Owner: " + vehicle.getOwner().getName() + "<br>" +
                            "Daily Price: <b>$" + vehicle.getPricePerDay() + "</b></html>"
            );
            carLabel.setFont(DEFAULT_FONT);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.setOpaque(false);

            JButton infoButton = new JButton("Info");
            styleButton(infoButton, PRIMARY);
            infoButton.addActionListener(e -> showVehicleInfo(vehicle));

            JButton paymentButton = new JButton("Pay");
            styleButton(paymentButton, SUCCESS);
            paymentButton.addActionListener(e -> showPaymentOptions(vehicle, stripeGateway, paypalGateway));

            buttonPanel.add(infoButton);
            buttonPanel.add(paymentButton);

            carPanel.add(carLabel, BorderLayout.CENTER);
            carPanel.add(buttonPanel, BorderLayout.EAST);

            vehiclePanel.add(carPanel);
            vehiclePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        frame.add(scrollPane, BorderLayout.CENTER);
        return this;
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }

    private void showVehicleInfo(Vehicle vehicle) {
        JOptionPane.showMessageDialog(frame,
                "Car Information:\n" +
                        "Brand: " + vehicle.getName() + "\n" +
                        "Model: " + vehicle.getModel() + "\n" +
                        "Owner: " + vehicle.getOwner().getName() + "\n" +
                        "Daily Price: $" + vehicle.getPricePerDay(),
                "Car Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPaymentOptions(Vehicle vehicle, PaymentGateway stripe, PaymentGateway paypal) {
        Object[] options = {"Pay with Stripe", "Pay with PayPal"};
        int choice = JOptionPane.showOptionDialog(frame,
                "Select payment method for " + vehicle.getName(),
                "Payment Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) return;

        String cardNumber = "4111111111111111";
        String cardHolder = vehicle.getOwner().getName();

        Payment payment;
        if (choice == 0) {
            payment = new CreditCardPayment(stripe, cardNumber, cardHolder);
        } else {
            payment = new CreditCardPayment(paypal, cardNumber, cardHolder);
        }

        payment.makePayment(vehicle.getPricePerDay());
        JOptionPane.showMessageDialog(frame,
                "Payment of $" + vehicle.getPricePerDay() + " processed successfully!",
                "Payment Complete",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public JFrame build() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }
}
