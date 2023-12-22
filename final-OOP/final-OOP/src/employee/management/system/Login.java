package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarEntry;

public class Login extends JFrame implements ActionListener {

    JTextField tUserName;
    JPasswordField tPassword;
    JButton login, back;

    Login() {
        // username label
        JLabel username = new JLabel("username");
        username.setBounds(40, 20, 100, 30);
        add(username);
        // username field
        tUserName = new JTextField();
        tUserName.setBounds(150, 20, 150, 30);
        add(tUserName);
        // password label
        JLabel password = new JLabel("password");
        password.setBounds(40, 70, 100, 30);
        add(password);
        // password field
        tPassword = new JPasswordField();
        tPassword.setBounds(150, 70, 150, 30);
        add(tPassword);
        // login button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        // back button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        // background context
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel img = new JLabel(icon3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        // main window
        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tUserName.getText();
                String password = tPassword.getText();

                Config conn = new Config();

                String query = String.format("select * from login where username = '%s' and password = '%s' ",username,  password);
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }
}
