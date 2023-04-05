package org.example;

import java.util.ArrayList;

public class Shop {

    // Attributes

    private String name;
    private String webAddress;
    private String supportPhoneNumber;
    private static int profitCashFromAllOrders;
    private static ArrayList<Account> allOfAccounts = new ArrayList<>();
    private static ArrayList<SellerProduct> allProducts = new ArrayList<>();
    private static ArrayList<Order> allAcceptedOrders = new ArrayList<>();

    // Public Functions

    public static SellerProduct SearchFromAllProducts(String name){
        SellerProduct target = null;
        for(SellerProduct sellerProduct : allProducts){
            if(sellerProduct.getName().equals(name)){
                target = sellerProduct;
                break;
            }
        }
        return target;
    }

    public static void addAccount(Account account){
        allOfAccounts.add(account);
    }

    public static void changingTheAvailableStatusFromAllProduct(SellerProduct product){
            product.setAvailable(!product.isAvailable());
    }

    public static void addProductToAllProducts(SellerProduct product){
        allProducts.add(product);
    }

    public static void increasingProfitFromAllOrders(int price){
        profitCashFromAllOrders = profitCashFromAllOrders + price;
    }

    public static boolean isUsernameExist(String username) {
        boolean flag = false;
        for (Account account : allOfAccounts) {
            if (account.getUsername().equals(username)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static Account searchInAllAccounts(String username){
        Account target = null;
        for(Account account : allOfAccounts){
            if(account.getUsername().equals(username)){
                target = account;
                break;
            }
        }
        return target;
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

    public static SellerProduct getFromAllProducts(String name){
        SellerProduct target = null;
        for(SellerProduct product : allProducts){
            if (product.getName().equals(name)){
                target = product;
                break;
            }
        }
        return target;
    }


}
