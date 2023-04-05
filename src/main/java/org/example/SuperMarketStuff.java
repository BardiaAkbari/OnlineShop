package org.example;

import java.util.ArrayList;

public class SuperMarketStuff extends SellerProduct {
    // Attributes
    private static ArrayList<SellerProduct> allOfSuperMarketStuffProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfSuperMarketStuffProducts(){
        return allOfSuperMarketStuffProducts.size();
    }
    public static SellerProduct accessToSuperMarketStuffProduct(int index){
        return allOfSuperMarketStuffProducts.get(index);
    }
    public static SellerProduct SearchForSuperMarketStuffProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct mySuperMarketStuff : allOfSuperMarketStuffProducts){
            if(mySuperMarketStuff.getName().equals(name)){
                sellerProduct = mySuperMarketStuff;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfSuperMarketStuffProducts(SellerProduct sellerProduct){
        allOfSuperMarketStuffProducts.add(sellerProduct);
    }
}
