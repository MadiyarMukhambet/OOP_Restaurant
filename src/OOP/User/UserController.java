package OOP.User;
import OOP.OrderObserver;
import OOP.Orders.Order;
import OOP.OrderLogger;
import java.util.Scanner;

public class UserController {
    private static Order order;
    private static OrderObserver orderLogger;
    private UserCRUD userCRUD;

    public UserController(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    public static void addUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("You're VIP?");
        boolean isVip = scanner.nextLine().equalsIgnoreCase("yes");
        Person newUser = new Person();
        newUser.setUsername(username);
        newUser.setBalance(balance);
        newUser.setIsVIP(isVip);
        Person.getInstance();
        UserCRUD.createUser(newUser);
    }
    public static void updateUser(Scanner scanner) {
        System.out.print("Enter user ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();

        System.out.print("You're VIP?");
        boolean isVip = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Enter new balance: ");
        double newBalance = scanner.nextDouble();

        Person updatedUser = new Person();
        updatedUser.setId(userId);
        updatedUser.setUsername(newUsername);
        updatedUser.setIsVIP(isVip);
        updatedUser.setBalance(newBalance);

        UserCRUD.updateUser(updatedUser);
    }
    public void getAllUsers() {
        userCRUD.readAllUsers();
    }
    public void takeAllUsers() {
        userCRUD.getAllUsers();
    }
    public static void deleteUser(Scanner scanner) {
        System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        if(order != null){
            order.removeObserver(orderLogger);
            UserCRUD.deleteUser(userId);
        }
        else {
            System.out.println("Order is null. Cannot remove observer.");
        }
    }
}


