package org.example;

import java.util.ArrayList;

public class Order {
    User user;
    private int numberOfProducts;
    private int totalPrice;
    private ArrayList<UserProduct> productUserOrder = new ArrayList<>();


    // Constructor

    public Order(User user){
        this.user = user;
    }

    // Public Functions
    public void increasingNumberOfProducts(int range){
        this.numberOfProducts = this.numberOfProducts + range;
    }
    public void increasingTotalPrice(int price){
        this.totalPrice = this.totalPrice + price;
    }
    public void addToProductUserOrders(UserProduct product){
        this.productUserOrder.add(product);
    }
    public int numberOfProductUserOrder(){
        return this.productUserOrder.size();
    }
    public void removingProductFromProductUserOrder(UserProduct userProduct){
        this.productUserOrder.remove(userProduct);
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


    public UserProduct getFromUserOrder(int index){
        return this.productUserOrder.get(index);
    }
    public UserProduct getFromUserOrder(String name){
        UserProduct target = null;
        for(UserProduct product : productUserOrder){
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
                "numberOfProducts=" + numberOfProducts + '\n' +
                ", totalPrice=" + totalPrice + '\n' +
                ", productUserOrder=" + productUserOrder +
                '}';
    }
}
