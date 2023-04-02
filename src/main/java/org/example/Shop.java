package org.example;

import java.util.ArrayList;

public class Shop {
    // Attributes
    private String name;
    private String webAddress;
    private String supportPhoneNumber;
    private int profitCashFromAllOrders;
    private static ArrayList<Account> allOfAccounts = new ArrayList<>();
    private static ArrayList<Product> allProducts = new ArrayList<>();
    private static ArrayList<Order> allAcceptedOrders = new ArrayList<>();
    //private static ArrayList<>
    //private ArrayList<>


    // Public Functions

    public static void addAccount(Account account){
        allOfAccounts.add(account);
    }

    public static void decreasingAmountOfProduct(Product product, int range){
        int newQuantity = product.getQuantity() - range;
        if(newQuantity == 0){
            allProducts.remove(product);
        }
        else{
            product.setQuantity(newQuantity);
        }
    }
}
