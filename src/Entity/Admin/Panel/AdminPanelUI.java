package Entity.Admin.Panel;

import javax.swing.*;
import java.awt.*;

public class AdminPanelUI {

    public static void showAdminPanel() {
        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Admin Dashboard");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton usersButton = createStyledButton("Users", () -> {
            JOptionPane.showMessageDialog(frame, "Users section coming soon...");
        });

        JButton vehiclesButton = createStyledButton("Vehicles", () -> {
            JOptionPane.showMessageDialog(frame, "Vehicles section coming soon...");
        });

        JButton paymentsButton = createStyledButton("Payments", () -> {
            JOptionPane.showMessageDialog(frame, "Payments section coming soon...");
        });

        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(usersButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(vehiclesButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(paymentsButton);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private static JButton createStyledButton(String text, Runnable onClick) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(200, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.addActionListener(e -> onClick.run());
        return button;
    }
}

