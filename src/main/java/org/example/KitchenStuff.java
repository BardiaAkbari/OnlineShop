package org.example;

import java.util.ArrayList;

public class KitchenStuff extends SellerProduct{
    // Attributes
    private static ArrayList<SellerProduct> allOfKitchenStuffProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfKitchenStuffProducts(){
        return allOfKitchenStuffProducts.size();
    }
    public static SellerProduct accessToKitchenStuffProduct(int index){
        return allOfKitchenStuffProducts.get(index);
    }
    public static SellerProduct SearchForKitchenStuffProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct myKitchenStuff : allOfKitchenStuffProducts){
            if(myKitchenStuff.getName().equals(name)){
                sellerProduct = myKitchenStuff;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfKitchenStuffProducts(SellerProduct sellerProduct){
        allOfKitchenStuffProducts.add(sellerProduct);
    }
}
