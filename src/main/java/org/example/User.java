package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class User extends Account {
    // Attributes
    private String phoneNumber;
    private String address;
    private int walletCash;
    private static ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Product> allPurcahseProducts = new ArrayList<>();

    // Constructor
    public User(String username, String password){
        super(username, password);
        allUsers.add(this);
    }
    // Public Functions
    public static User isUserExist(String username, String password) {
        User target = null;
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password))
                    target = user;
                break;
            }
        }
        return target;
    }
    public static boolean isUsernameExist(String username) {
        boolean flag = false;

        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static String passwordGenerator(){
        String numbers = "1234567890";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String special = "<>@#$%&()-?/{}[]\\!=";
        String combination = numbers + upper + lower + special;
        int len = combination.length();
        Random myRandom = new Random();
        String passWord = "";
        boolean flag = false;
        do{
            int myNum = myRandom.nextInt(12);
            if(myNum > 6){
                Random genrator = new Random();
                for(int i = 0; i < myNum; i++){
                    passWord = passWord + combination.charAt(genrator.nextInt(combination.length()));
                }
                flag = true;
            }
        }
        while(!flag);
        return passWord;
    }





























    // Getter & Setter
    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address){
        this.address = address;
    }
}

