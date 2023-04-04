package org.example;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

public class Seller extends Account{
    // Attributes
    private String companyName;
    private static ArrayList<Seller> allSellers = new ArrayList<>();
    private static ArrayList<Product> allSellerAvailbleProducts = new ArrayList<>();

    // Constructor
    public Seller(String username, String password, String companyName){
        super(username, password);
        this.companyName = companyName;
        allSellers.add(this);
    }

    // Public Functions
    public static Seller isSellerExist(String username, String password){
        Seller target = null;
        for(Seller seller : allSellers){
            if(seller.getUsername().equals(username)){
                if(seller.getPassword().equals(password))
                    target = seller;
                break;
            }
        }
        return target;
    }
    public static boolean isUsernameExist(String username){
        boolean flag = false;

        for(Seller seller : allSellers){
            if(seller.getUsername().equals(username)){
                flag = true;
                break;
            }
        }
        return flag;
    }

}
