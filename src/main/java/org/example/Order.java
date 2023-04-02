package org.example;

import java.util.ArrayList;

public class Order {
    User user;
    private int numberOfProducts;
    private int totalPrice;
    private ArrayList<Product> userOrder = new ArrayList<>();


    // Constructor

    public Order(User user){
        this.user = user;
    }

    // Public Functions
    public void increasingNumberOfProducts(){
        this.numberOfProducts = this.numberOfProducts + 1;
    }
    public void increasingTotoalPrice(int price){
        this.totalPrice = this.totalPrice + price;
    }
    public void addingToUserorder(Product product){
        this.userOrder.add(product);
    }

















    // Getter & Setter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(ArrayList<Product> userOrder) {
        this.userOrder = userOrder;
    }
    public Product getFromUserOrder(int index){
        return this.userOrder.get(index);
    }

    // To String

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", numberOfProducts=" + numberOfProducts +
                ", totalPrice=" + totalPrice +
                ", userOrder=" + userOrder +
                '}';
    }
}
