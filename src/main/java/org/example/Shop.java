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

    public static void RemovingOfProductIfTheyEnd(Product product){
        if(product.getQuantity() == 0){
            allProducts.remove(product);
        }
    }

    public static void addProductToAllProducts(Product product){
        allProducts.add(product);
    }












    // Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getSupportPhoneNumber() {
        return supportPhoneNumber;
    }

    public void setSupportPhoneNumber(String supportPhoneNumber) {
        this.supportPhoneNumber = supportPhoneNumber;
    }

    public int getProfitCashFromAllOrders() {
        return profitCashFromAllOrders;
    }

    public void setProfitCashFromAllOrders(int profitCashFromAllOrders) {
        this.profitCashFromAllOrders = profitCashFromAllOrders;
    }

    public static Product getFromAllProducts(String name){
        Product target = null;
        for(Product product : allProducts){
            if (product.getName().equals(name)){
                target = product;
                break;
            }
        }
        return target;
    }


}
