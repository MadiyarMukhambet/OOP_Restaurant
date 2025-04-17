package OOP.User;
import java.sql.*;

public class UserCRUD {
    public static Connection connection;

    public UserCRUD(Connection connection) {
        UserCRUD.connection = connection;
    }

    public static void createUser(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Users (name, balance, is_vip) VALUES (?, ?, ?)");
            statement.setString(1, person.getName());
            statement.setDouble(2, person.getBalance());
            statement.setBoolean(3, person.getIsVIP());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User created successfully.");
            } else {
                System.out.println("Failed to create user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void readAllUsers() {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                boolean isVip = resultSet.getBoolean("is_vip");
                System.out.println("User ID: " + userId);
                System.out.println("Name: " + name);
                System.out.println("Balance: $" + balance);
                System.out.println("VIP: " + (isVip ? "Yes" : "No"));
                System.out.println(); // Добавим пустую строку между пользователями для лучшей читаемости
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Users SET name = ?, balance = ?, is_vip = ? WHERE id = ?");
            statement.setString(1, person.getName());
            statement.setDouble(2, person.getBalance());
            statement.setBoolean(3, person.getIsVIP());
            statement.setInt(4, person.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("Failed to update user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Users WHERE id = ?");
            statement.setInt(1, userId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Failed to delete user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllUsers() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                boolean isVip = resultSet.getBoolean("is_vip");
                System.out.println("User ID: " + id + ", Name: " + name + ", Balance: $" + balance + ", VIP: " + (isVip ? "Yes" : "No"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}