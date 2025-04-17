package OOP;

import OOP.Orders.Order;

public class OrderLogger implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Order updated: " + order);
    }
}
