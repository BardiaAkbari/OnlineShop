package org.example;

import java.util.ArrayList;

public class Cloth extends SellerProduct {
    // Attributes
    private static ArrayList<SellerProduct> allOfClothProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfClothProducts(){
        return allOfClothProducts.size();
    }
    public static SellerProduct accessToClothProduct(int index){
        return allOfClothProducts.get(index);
    }
    public static SellerProduct SearchForClothProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct myCloth : allOfClothProducts){
            if(myCloth.getName().equals(name)){
                sellerProduct = myCloth;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfClothProducts(SellerProduct sellerProduct){
        allOfClothProducts.add(sellerProduct);
    }
}
