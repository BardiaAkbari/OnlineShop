package org.example;

import java.util.ArrayList;

public class Beauty extends SellerProduct {
    // Attributes
    private static ArrayList<SellerProduct> allOfBeautyProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfBeautyProducts(){
        return allOfBeautyProducts.size();
    }
    public static SellerProduct accessToBeautyProduct(int index){
        return allOfBeautyProducts.get(index);
    }
    public static SellerProduct SearchForBeautyProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct mybeauty : allOfBeautyProducts){
            if(mybeauty.getName().equals(name)){
                sellerProduct = mybeauty;
                break;
            }
        }
        return sellerProduct;
    }
    public static void changingTheAvailableBeautyProductStatusIfTheyEnd(Beauty beauty){
        if(beauty.getQuantity() == 0) {
            allOfBeautyProducts.remove(beauty);
        }
    }



    public static void addToAllOfBeautyProducts(SellerProduct sellerProduct){
        allOfBeautyProducts.add(sellerProduct);
    }

}
