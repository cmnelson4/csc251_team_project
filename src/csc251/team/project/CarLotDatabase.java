package csc251.team.project;

import java.sql.*;

public class CarLotDatabase {
    private static Connection conn;

    public CarLotDatabase(String url, String username, String password) throws SQLException {
        // Initialize driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Make DB Connection
        CarLotDatabase.conn = DriverManager.getConnection(url, username, password);

        // Determine if cars table exists and create it if it doesnt
        DatabaseMetaData md = conn.getMetaData();
        ResultSet rs = md.getTables(null, null, "cars", null);
        if (!rs.next()) {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE cars "
                    + "(id VARCHAR(255) NOT NULL PRIMARY KEY,"
                    + "mileage INT NOT NULL,"
                    + "mpg INT NOT NULL, "
                    + " cost DOUBLE NOT NULL, "
                    + "salesPrice DOUBLE NOT NULL, "
                    + " sold TINYINT(1) NOT NULL, "
                    + "priceSold DOUBLE NULL, "
                    + "profit DOUBLE NULL)";
            stmt.executeUpdate(sql);
        }

    }

    public static void addInventory(Car car) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(
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
        PreparedStatement statement = conn.prepareStatement(
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