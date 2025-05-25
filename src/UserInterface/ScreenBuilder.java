package UserInterface;

import javax.swing.*;
import java.awt.*;

public class ScreenBuilder extends JFrame {
    private final JFrame frame;
    public ScreenBuilder(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 600);
    }

    public ScreenBuilder addButton(String text) {
        JButton button = new JButton(text);
        frame.add(button);
        return this;
    }
    public ScreenBuilder addLabel(String text) {
        JLabel label = new JLabel(text);
        frame.add(label);
        return this;
    }
   public ScreenBuilder setLayOut(LayoutManager manager){
   frame.setLayout(manager);
   return this;
   }
    public JFrame build() {
        frame.setVisible(true);
        return frame;
    }
}
