package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    Main() {
        // background context
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel img = new JLabel(icon3);
        img.setBounds(0, 0, 1120, 630);
        add(img);
        // title
        JLabel heading = new JLabel("Employee management system");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);
        // add button
        JButton add = new JButton("Add employees");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);
        // view button
        JButton view = new JButton("View employees");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);
        // remove button
        JButton remove = new JButton("Remove employees");
        remove.setBounds(440, 370, 150, 40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.black);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
                setVisible(false);
            }
        });
        img.add(remove);
        // main window
        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
