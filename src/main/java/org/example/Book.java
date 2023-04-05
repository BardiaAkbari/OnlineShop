package org.example;

import java.util.ArrayList;

public class Book extends SellerProduct {
    // Attributes
    private static ArrayList<SellerProduct> allOfBookProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfBookProducts(){
        return allOfBookProducts.size();
    }
    public static SellerProduct accessToBookProduct(int index){
        return allOfBookProducts.get(index);
    }
    public static SellerProduct SearchForBookProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct myBook : allOfBookProducts){
            if(myBook.getName().equals(name)){
                sellerProduct = myBook;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfBookProducts(SellerProduct sellerProduct){
        allOfBookProducts.add(sellerProduct);
    }
}
