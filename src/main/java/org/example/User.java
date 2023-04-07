package org.example;
import java.util.ArrayList;
import java.util.Random;

public class User extends Account {
    // Attributes
    private String phoneNumber;
    private String address;
    private String email;
    private int walletCash;
    private static ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Purchase> allPurchaseProducts = new ArrayList<>();

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

    public static String passwordGenerator(){

        String numbers = "1234567890";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String special = "<>@#$%&()-?/{}[]\\!=";
        String combination = numbers + upper + lower + special;
        int len = combination.length();
        Random myRandom = new Random();
        StringBuilder passWord = new StringBuilder();
        boolean flag = false;
        do{
            int myNum = myRandom.nextInt(12);
            if(myNum > 6){
                Random genrator = new Random();
                for(int i = 0; i < myNum; i++){
                    passWord.append(combination.charAt(genrator.nextInt(combination.length())));
                }
                flag = true;
            }
        }
        while(!flag);
        return passWord.toString();
    }

    public void decreasingWalletCash(int price){
        this.walletCash = price;
    }

    public void addToOrders(Order order){
        this.orders.add(order);
    }

    public int numberOfAllOrders(){
        return this.orders.size();
    }

    public int numberAllPurchaseProducts(){
        return this.allPurchaseProducts.size();
    }

    public void addToAllPurchaseProducts(Purchase purchase){
        this.allPurchaseProducts.add(purchase);
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

    public int getWalletCash() {
        return walletCash;
    }

    public void setWalletCash(int walletCash) {
        this.walletCash = walletCash;
    }

    public Order getFromOrders(int index){
        return this.orders.get(index);
    }

    public Purchase getFromAllPurchaseProducts(int index){
        return this.allPurchaseProducts.get(index);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // To String
    @Override
    public String toString() {
        return "User{" +
                "username='" + this.getUsername() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

