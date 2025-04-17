import java.util.*;
import OOP.Orders.*;
import OOP.OurMenu.*;
import OOP.User.*;
import java.sql.*;
import OOP.MediatorSet.*;
public class ItalianRestaurant {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";

    private static void createMenuTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Menu (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "price NUMERIC(10, 2) NOT NULL," +
                    "description TEXT NOT NULL," + "time INTEGER NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
        }
    }

    private static void createOrdersTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Orders (" +
                    "id SERIAL PRIMARY KEY," +
                    "user_id INTEGER REFERENCES Users(id)," +
                    "dish_id INTEGER REFERENCES Menu(id)," +
                    "quantity INTEGER NOT NULL," + "timer INTEGER NOT NULL,"+
                    "cost NUMERIC(10, 2) NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
        }
    }

    private static void createUsersTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "balance NUMERIC(10, 2) NOT NULL," +
                    "is_vip BOOLEAN NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
        }
    }

    public static void Choice(Mediator mediator, Scanner scanner) {
        while (true) {
            System.out.println("Choose your option:");
            System.out.println("1. To Show menu\n2. To show your order\n3. Add new User\n4. Update User INFO\n5. Delete User\n6. Add new dish\n7. Update menu item\n8. Delete dish from menu\n9. To delete your order\n10.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    mediator.getMenu();
                    mediator.makeOrder();
                    break;
                case 2:
                    mediator.showOrder();
                    mediator.deleteOrder(scanner);
                    break;
                case 3:
                    mediator.addUser(scanner);
                    break;
                case 4:
                    mediator.updateUser(scanner);
                    break;
                case 5:
                    mediator.deleteUser(scanner);
                    break;
                case 6:
                    mediator.addDishToMenu();
                    break;
                case 7:
                    mediator.getMenu();
                    mediator.updateMenuItem();
                    break;
                case 8:
                    mediator.getMenu();
                    mediator.deleteMenuItem();
                    break;
                case 9:
                    mediator.showOrder();
                    mediator.deleteOrder(scanner);
                    break;
                case 10:
                    System.out.println("Exit from application...");
                    return;
                default:
                    System.out.println("Not Found");
            }
        }
    }

    public static void main(String[] args) {
        try {
            welcomeMessage();
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            createUsersTable(connection);
            UserCRUD userCRUD = new UserCRUD(connection);
            UserController userController = new UserController(userCRUD);
            createMenuTable(connection);
            MenuCRUD menuCRUD = new MenuCRUD(connection);
            MenuController menuController = new MenuController(menuCRUD);
            createOrdersTable(connection);
            OrderCRUD orderCRUD = new OrderCRUD(connection);
            OrderController orderController = new OrderController(orderCRUD);
            Mediator mediator = new RestaurantMediator(userController, menuController, orderController);
            Scanner scanner = new Scanner(System.in);
            Choice(mediator, scanner);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

    }

    private static void welcomeMessage() {
        System.out.println("Welcome to 'Sapore d'Italia'! Enjoy the authentic tastes of Italy in the cozy atmosphere of our restaurant. Immerse yourself in a world of gourmet dishes prepared with love for the Italian tradition. Buon appetito!");
    }
}


