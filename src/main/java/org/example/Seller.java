package org.example;

import java.util.ArrayList;

public class Seller extends Account {
    // Attributes
    private String companyName;
    private int profitFromSelling;
    private static ArrayList<Seller> allSellers = new ArrayList<>();
    private ArrayList<SellerProduct> allSellerProducts = new ArrayList<>();

    // Constructor
    public Seller(String username, String password, String companyName) {
        super(username, password);
        this.companyName = companyName;
        allSellers.add(this);
    }

    // Public Functions

    public static Seller isSellerExist(String username, String password) {
        Seller target = null;
        for (Seller seller : allSellers) {
            if (seller.getUsername().equals(username)) {
                if (seller.getPassword().equals(password))
                    target = seller;
                break;
            }
        }
        return target;
    }

    public static boolean isUsernameExist(String username) {
        boolean flag = false;

        for (Seller seller : allSellers) {
            if (seller.getUsername().equals(username)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void increasingProfitFromSelling(int price) {
        this.profitFromSelling = this.profitFromSelling + price;
    }

    // Getter & Setter

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public SellerProduct getSellerProduct(String productName) {
        SellerProduct target = null;
        for (SellerProduct sellerProduct : allSellerProducts) {
            if (sellerProduct.getName().equals(productName)) {
                target = sellerProduct;
                break;
            }
        }
        return target;
    }
}
