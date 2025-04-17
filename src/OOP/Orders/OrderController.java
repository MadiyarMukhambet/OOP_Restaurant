package OOP.Orders;

import OOP.OrderLogger;

import java.util.Scanner;

import static OOP.Orders.OrderCRUD.calculateCost;
import static OOP.Orders.OrderCRUD.calculateTime;

public class OrderController {
    private OrderCRUD orderCRUD;

    public OrderController(OrderCRUD orderCRUD) {
        this.orderCRUD = orderCRUD;
    }

    public static void MakeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter dish ID: ");
        int dishId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        int longestTime = calculateTime(dishId, quantity);
        double totalCost = calculateCost(dishId, quantity);

        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setDish(dishId);
        newOrder.setQuantity(quantity);
        newOrder.setTime(longestTime);
        newOrder.setCost(totalCost);
        OrderCRUD.CreateOrder(newOrder);
        OrderLogger orderLogger = new OrderLogger();
        newOrder.addObserver(orderLogger);
    }
    public static void ShowOrder(){
        OrderCRUD.displayOrders();
    }
    public static void deleteOrder(Scanner scanner){
        System.out.print("Enter order ID to delete: ");
        int orderId = scanner.nextInt();

        OrderCRUD.deleteOrder(orderId);
    }


}
