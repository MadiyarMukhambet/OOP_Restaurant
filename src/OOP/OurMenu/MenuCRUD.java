package OOP.OurMenu;
import java.sql.*;

public class MenuCRUD {
    private static Connection connection;

    public MenuCRUD(Connection connection) {
        OOP.OurMenu.MenuCRUD.connection = connection;
    }
    public static void addMenuItem(MenuItem menuItem) {
        try {
            String sql = "INSERT INTO Menu (name, price, description, time) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, menuItem.getName());
            statement.setDouble(2, menuItem.getPrice());
            statement.setString(3, menuItem.getDescription());
            statement.setInt(4, menuItem.getTime());
            statement.executeUpdate();
            System.out.println("New menu item added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateMenuItem(MenuItem menuItem) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Menu SET name = ?, price = ?, description = ?, time = ?, WHERE id = ?");
            statement.setString(1, menuItem.getName());
            statement.setDouble(2, menuItem.getPrice());
            statement.setString(3, menuItem.getDescription());
            statement.setInt(4, menuItem.getTime());
            statement.setInt(5, menuItem.getId());
            statement.executeUpdate();
            System.out.println("Menu item updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void deleteMenuItem(int id) {
        try {
            String sql = "DELETE FROM Menu WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Menu item deleted successfully.");
            } else {
                System.out.println("No menu item found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayMenu() {
        System.out.println("'Sapore d'Italia' Restaurant Menu:");
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM Menu";
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Menu:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int time = resultSet.getInt("time");
                System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Description: " + description + ", Cooking time: " + time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
