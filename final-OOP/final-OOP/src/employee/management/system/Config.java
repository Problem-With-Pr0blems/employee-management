package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Config {
    Connection connection;
    Statement statement;
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static String password = "1234";

    Config() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("connected to database ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
