package Entity.Admin.Panel;

import javax.swing.*;
import java.awt.*;

public class RealAdminPanel implements AdminPanel {
    @Override
    public void access() {
        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to Admin Panel", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(welcomeLabel);

        JButton usersBtn = new JButton("Users");
        JButton vehiclesBtn = new JButton("Vehicles");
        JButton paymentsBtn = new JButton("Payments");

        panel.add(usersBtn);
        panel.add(vehiclesBtn);
        panel.add(paymentsBtn);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
