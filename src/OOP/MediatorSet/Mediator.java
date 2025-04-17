package OOP.MediatorSet;
import java.util.Scanner;
public interface Mediator {
    void addUser(Scanner scanner);
    void updateUser(Scanner scanner);
    void deleteUser(Scanner scanner);
    void makeOrder();
    void showOrder();
    void deleteOrder(Scanner scanner);
    void addDishToMenu();
    void updateMenuItem();
    void deleteMenuItem();
    void getMenu();
}