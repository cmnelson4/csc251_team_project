package csc251.team.project;

import java.sql.*;;

public class CarLotDatabase {
    private static Connection connection;

    public CarLotDatabase(String url, String username, String password) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CarLotDatabase.connection = DriverManager.getConnection(url, username, password);
    }

    public static void addInventory(Car car) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO car_inventory (id, mileage, mpg, cost, sales_price) VALUES (?, ?, ?, ?, ?);");
        statement.setString(1, car.getId());
        statement.setInt(2, car.getMileage());
        statement.setInt(3, car.getMpg());
        statement.setDouble(4, car.getCost());
        statement.setDouble(5, car.getSalesPrice());
        statement.executeUpdate();
    }
}