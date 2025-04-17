package OOP.User;

import OOP.Orders.Order;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private static Person instance;


    private boolean isVip;
    private int id;
    private String name;
    private double balance;
    private List<Order> orderHistory;



    Person() {
        this.id = 0;
        this.name = "";
        this.balance = 0.0;
        this.isVip = false;
        this.orderHistory = new ArrayList<>();
    }


    public static Person getInstance() {

        if (instance == null) {
            instance = new Person();
        }
        return instance;
    }



    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public boolean getIsVIP() {
        return this.isVip;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setIsVIP(boolean isVip) {
        this.isVip = isVip;
    }

    public List<Order> getOrderHistory() {
        return this.orderHistory;
    }

    public void displayVipCompliment() {
        if (this.isVip) {
            System.out.println("VIP Compliment: Enjoy a complimentary Tiramisu dessert!");
        }
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}

