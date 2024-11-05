package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static final String URL = "jdbc:mysql://localhost:3306/web";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0728012004"; // Change this to your password

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connection successful!");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle error for missing driver
            throw new SQLException("Driver not found", e);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL errors
            throw e; // Propagate the exception
        }
    }

    // Method to get all clients
    public static List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                clients.add(new Client(name, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    // Main method to test the connection and fetch client list
    public static void main(String[] args) {
        List<Client> clients = getAllClients();
		System.out.println("Client list:");
		for (Client client : clients) {
		    System.out.println("Name: " + client.getName() + ", Email: " + client.getEmail());
		}
    }
}
