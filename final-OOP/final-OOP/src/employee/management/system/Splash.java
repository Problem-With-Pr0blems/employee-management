package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash(){
        // show gif
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image icon2 = icon1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(0, 0, 1170, 650);
        add(image);
        // main window
        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }

}
