package co.istad;

import java.sql.*;

public class DbMain {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "devkh";
        String password = "devkh";
        try {
            // 1.Register driver
            Class.forName("org.postgresql.Driver");
            // 2.Establish connection
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // 3. Create statement
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM student WHERE id = ? AND email = ?");
                statement.setLong(1, 3);
                statement.setString(2, "it.chhaya@gmail.com");
                // 4. Execute the statement
                ResultSet resultSet = statement.executeQuery();
                // 5. Handle ResultSet
                while(resultSet.next()) {
                    System.out.println("ID: " + resultSet.getLong("id"));
                    System.out.println("NAME: " + resultSet.getString("name"));
                    System.out.println("GENDER: " + resultSet.getString("gender"));
                    System.out.println("EMAIL: " + resultSet.getString("email"));
                    System.out.println("ADDRESS: " + resultSet.getString("address"));
                    System.out.println("------------------------------");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
