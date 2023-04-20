package csc251.team.project;

import java.sql.*;;

public class CarLotDatabase {
    private static Connection connection;

    public CarLotDatabase(String url, String username, String password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CarLotDatabase.connection = DriverManager.getConnection(url, username, password);
    }

    public static void addInventory(Car car) throws SQLException {
        System.out.printf("Saving", car.getId());
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cars (id, mileage, mpg, cost, salesPrice, sold, priceSold, profit) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        statement.setString(1, car.getId());
        statement.setInt(2, car.getMileage());
        statement.setInt(3, car.getMpg());
        statement.setDouble(4, car.getCost());
        statement.setDouble(5, car.getSalesPrice());
        statement.setBoolean(6, car.isSold());
        statement.setDouble(7, car.getPriceSold());
        statement.setDouble(8, car.getProfit());
        statement.executeUpdate();
    }

    public static void updateInventory(Car car) throws SQLException {
        System.out.printf("Updating", car.getId());
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE cars set mileage = ?, mpg = ?, cost = ?, salesPrice = ?, sold = ?, priceSold = ?, profit = ? where id = ?;");
        statement.setInt(1, car.getMileage());
        statement.setInt(2, car.getMpg());
        statement.setDouble(3, car.getCost());
        statement.setDouble(4, car.getSalesPrice());
        statement.setBoolean(5, car.isSold());
        statement.setDouble(6, car.getPriceSold());
        statement.setDouble(7, car.getProfit());
        statement.setString(8, car.getId());
        statement.executeUpdate();
    }
}