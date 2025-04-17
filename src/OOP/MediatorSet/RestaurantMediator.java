package OOP.MediatorSet;
import java.util.Scanner;

import OOP.Orders.OrderController;

import OOP.OurMenu.MenuController;

import OOP.User.UserController;
public class RestaurantMediator implements Mediator {
    private UserController userController;
    private MenuController menuController;
    private OrderController orderController;

    public RestaurantMediator(UserController userController, MenuController menuController, OrderController orderController) {
        this.userController = userController;
        this.menuController = menuController;
        this.orderController = orderController;
    }

    @Override
    public void addUser(Scanner scanner) {
        userController.addUser(scanner);
    }

    @Override
    public void updateUser(Scanner scanner) {
        userController.updateUser(scanner);
    }

    @Override
    public void deleteUser(Scanner scanner) {
        userController.deleteUser(scanner);
    }

    @Override
    public void makeOrder() {
        orderController.MakeOrder();
    }

    @Override
    public void showOrder() {
        orderController.ShowOrder();
    }

    @Override
    public void deleteOrder(Scanner scanner) {
        orderController.deleteOrder(scanner);
    }

    @Override
    public void addDishToMenu() {
        menuController.addDishToMenu();
    }

    @Override
    public void updateMenuItem() {
        menuController.UpdateMenuItem();
    }

    @Override
    public void deleteMenuItem() {
        menuController.deleteMenuItem();
    }

    @Override
    public void getMenu() {
        menuController.getMenu();
    }
}
