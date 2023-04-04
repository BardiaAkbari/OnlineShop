package org.example;

import java.util.Date;

public class Purchase {
    // Attributes
    User user;
    Date date;
    Order order;
    int totalPrice;

    // Constructor
    public Purchase(User user,Date date, Order order, int totalPrice){
        this.user = user;
        this.date = date;
        this.order = order;
        this.totalPrice = totalPrice;

    }

    // Getter & Setter
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // To String

    @Override
    public String toString() {
        return "Purchase{" +
                "date=" + date +
                ", order=" + order +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
