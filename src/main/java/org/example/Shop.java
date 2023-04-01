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
    //private static ArrayList<>
    //private ArrayList<>


    // Public Functions

    public static void addAccount(Account account){
        allOfAccounts.add(account);
    }

}
