package org.example;

import java.util.ArrayList;

public class OtherProducts {
    // Attributes
    private static ArrayList<SellerProduct> allOfOtherProductsProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfOtherProductsProducts(){
        return allOfOtherProductsProducts.size();
    }
    public static SellerProduct accessToOtherProductsProduct(int index){
        return allOfOtherProductsProducts.get(index);
    }
    public static SellerProduct SearchForOtherProductsProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct myOtherProducts : allOfOtherProductsProducts){
            if(myOtherProducts.getName().equals(name)){
                sellerProduct = myOtherProducts;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfOtherProductsProducts(SellerProduct sellerProduct){
        allOfOtherProductsProducts.add(sellerProduct);
    }
}
