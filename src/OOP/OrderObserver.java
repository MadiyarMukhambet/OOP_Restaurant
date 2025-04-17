package OOP;

import OOP.Orders.Order;

public interface OrderObserver {
    void update(Order order);
}