package OOP.Orders;

import OOP.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String dish;
    private int quantity;
    private double cost;
    private int userid;
    private int time;
    private List<OrderObserver> observers;

    public Order() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public String toString() {
        return "Order: " + dish + " (Quantity: " + quantity + " Cooking time: " + time + ", Cost: $" + cost + ")";
    }

    public void setDish(int id) {
        this.id = id;
        notifyObservers();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyObservers();
    }

    public int getDishId() {
        return id;
    }

    public void setTime(int time){
        this.time = time;
        notifyObservers();
    }

    public void setCost(double cost) {
        this.cost = cost;
        notifyObservers();
    }


    public void setUserId(int userid) {
        this.userid = userid;
        notifyObservers();
    }

    public int getUserId() {
        return userid;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getTime(){
        return time;
    }

    public double getCost() {
        return cost;
    }
}

