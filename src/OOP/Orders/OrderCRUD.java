package OOP.Orders;

import java.sql.*;
import java.util.ArrayList;


public class OrderCRUD {
    public static Connection connection;

    public OrderCRUD(Connection connection) {
        OrderCRUD.connection = connection;
    }

    public static void CreateOrder(Order neworder) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders (user_id, dish_id, quantity, timer, cost) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, neworder.getUserId());
            statement.setInt(2, neworder.getDishId());
            statement.setInt(3, neworder.getQuantity());
            int time = calculateTime(neworder.getDishId(), neworder.getQuantity());
            statement.setInt(4,time);
            double cost = calculateCost(neworder.getDishId(), neworder.getQuantity());
            statement.setDouble(5, cost);

            // Выполнение запроса
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("New order created successfully.");
            } else {
                System.out.println("Failed to create new order.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void displayOrders() {
        try {
            String sql = "SELECT * FROM Orders";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                int dishId = resultSet.getInt("dish_id");
                int quantity = resultSet.getInt("quantity");
                int time = resultSet.getInt("timer");
                double cost = resultSet.getDouble("cost");

                System.out.println("Order ID: " + orderId);
                System.out.println("User ID: " + userId);
                System.out.println("Dish ID: " + dishId);
                System.out.println("Quantity: " + quantity);
                System.out.println("Cooking Time: " + time);
                System.out.println("Cost: " + cost);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static double calculateCost(int dishId, int quantity) {
        double totalCost = 0.0;
        try {
            // Создаем SQL-запрос для получения цены блюда из базы данных
            String sql = "SELECT price FROM Menu WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            ResultSet resultSet = statement.executeQuery();

            // Если запрос возвращает результат, считываем цену и рассчитываем общую стоимость заказа
            if (resultSet.next()) {
                double price = resultSet.getDouble("price");
                totalCost = price * quantity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCost;
    }

    public static int calculateTime(int dishId, int quantity){
        ArrayList<Integer> list = new ArrayList<>();
        int longestTime = 0;
        try {
            String sql = "SELECT time FROM Menu WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int time = resultSet.getInt("time");
                int current = time * quantity;
                if( current > longestTime ){
                    longestTime = current;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return longestTime;
    }
    public static void deleteOrder(int orderId) {
        try {
            String sql = "DELETE FROM Orders WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Order deleted successfully.");
            } else {
                System.out.println("No order found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*private static String getDishName(Connection connection, int dishId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT name FROM Dishes WHERE id = ?")) {
            statement.setInt(1, dishId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        }
        return null;
    }*/
}