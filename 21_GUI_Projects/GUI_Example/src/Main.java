import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(600, 400);

//        frame.setLayout(new FlowLayout());
//        frame.add(new Button("Click me :)"));

        frame.add(new MainForm().getMainPanel());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JFrame frame2 = new JFrame();
        frame2.setSize(400, 370);

        frame2.add(new FormForDraw().getMainPanel());

        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

    }


}
