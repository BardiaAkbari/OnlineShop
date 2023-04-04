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
    public void increasingNumberOfProducts(int number){
        this.numberOfProducts = this.numberOfProducts + number;
    }
    public void increasingTotoalPrice(int price){
        this.totalPrice = this.totalPrice + price;
    }
    public void addingToUserorder(Product product){
        this.userOrder.add(product);
    }
    public int numberOfUserOrder(){
        return this.userOrder.size();
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

    public void setUserOrder(ArrayList<Product> userOrder) {
        this.userOrder = userOrder;
    }

    public Product getFromUserOrder(int index){
        return this.userOrder.get(index);
    }
    public Product getFromUserOrder(String name){
        Product target = null;
        for(Product product : userOrder){
            if(product.getName().equals(name)){
                target = product;
                break;
            }
        }
        return target;
    }

    // To String

    @Override
    public String toString() {

        return "Order{" +
                ", numberOfProducts=" + numberOfProducts + '\n' +
                ", totalPrice=" + totalPrice + '\n' +
                ", userOrder=" + userOrder +
                '}';
    }
}
