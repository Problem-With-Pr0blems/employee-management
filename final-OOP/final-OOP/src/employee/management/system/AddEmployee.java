package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tName, tAddress, tPhone, tEmail, tSalary;
    JLabel tempId;
    JDateChooser tdob;
    JButton add, back;

    AddEmployee() {
        // background and title
        getContentPane().setBackground(new Color(163, 255, 188));
        JLabel heading = new JLabel("Add employee details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);
        // label name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);
        // field for name
        tName = new JTextField();
        tName.setBounds(200, 150, 150, 30);
        tName.setBackground(new Color(177, 252, 197));
        add(tName);


        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tSalary = new JTextField();
        tSalary.setBounds(600, 200, 150, 30);
        tSalary.setBackground(new Color(177, 252, 197));
        add(tSalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        tAddress = new JTextField();
        tAddress.setBounds(200, 250, 150, 30);
        tAddress.setBackground(new Color(177, 252, 197));
        add(tAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tPhone = new JTextField();
        tPhone.setBounds(600, 250, 150, 30);
        tPhone.setBackground(new Color(177, 252, 197));
        add(tPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        tEmail = new JTextField();
        tEmail.setBounds(200, 300, 150, 30);
        tEmail.setBackground(new Color(177, 252, 197));
        add(tEmail);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempId = new JLabel("" + number);
        tempId.setBounds(200, 400, 150, 30);
        tempId.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        tempId.setForeground(Color.RED);
        add(tempId);

        add = new JButton("ADD");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        // main window
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tName.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tSalary.getText();
            String address = tAddress.getText();
            String phone = tPhone.getText();
            String email = tEmail.getText();
            String empID = tempId.getText();
            try {
                Config conn = new Config();
                String query = String.format("""
                        insert into employee values('%s', '%s', '%s', '%s', '%s', '%s', '%s')
                        """, name, dob, salary, address, phone, email, empID);
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main();
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
