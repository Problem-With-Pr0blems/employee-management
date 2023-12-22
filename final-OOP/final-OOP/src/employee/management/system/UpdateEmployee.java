package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tAddress, tPhone, tEmail, tSalary;
    JLabel tempId;
    JButton add,back;
    String number;
    UpdateEmployee(String number){

        this.number = number;
        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tSalary = new JTextField();
        tSalary.setBounds(600,200,150,30);
        tSalary.setBackground(new Color(177,252,197));
        add(tSalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        tAddress = new JTextField();
        tAddress.setBounds(200,250,150,30);
        tAddress.setBackground(new Color(177,252,197));
        add(tAddress);


        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(phone);

        tPhone = new JTextField();
        tPhone.setBounds(600,250,150,30);
        tPhone.setBackground(new Color(177,252,197));
        add(tPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(email);

        tEmail = new JTextField();
        tEmail.setBounds(200,300,150,30);
        tEmail.setBackground(new Color(177,252,197));
        add(tEmail);


        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempId = new JLabel();
        tempId.setBounds(200,400,150,30);
        tempId.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempId.setForeground(Color.RED);
        add(tempId);


        try {
            Config c = new Config();
            String query = "select * from employee where empId = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tdob.setText(resultSet.getString("dob"));
                tAddress.setText(resultSet.getString("address"));
                tSalary.setText(resultSet.getString("salary"));
                tPhone.setText(resultSet.getString("phone"));
                tEmail.setText(resultSet.getString("email"));
                tempId.setText(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String salary = tSalary.getText();
            String address = tAddress.getText();
            String phone = tPhone.getText();
            String email = tEmail.getText();

            try {
                Config c = new Config();
                String query = "update employee set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"' where empId = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Main();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {

    }
}
