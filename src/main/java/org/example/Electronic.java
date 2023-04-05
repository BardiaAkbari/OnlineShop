package org.example;

import java.util.ArrayList;

public class Electronic extends SellerProduct {
    // Attributes
    private static ArrayList<SellerProduct> allOfElectronicProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfElectronicProducts(){
        return allOfElectronicProducts.size();
    }
    public static SellerProduct accessToElectronicProduct(int index){
        return allOfElectronicProducts.get(index);
    }
    public static SellerProduct SearchForElectronicProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct myElectronic : allOfElectronicProducts){
            if(myElectronic.getName().equals(name)){
                sellerProduct = myElectronic;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfElectronicProducts(SellerProduct sellerProduct){
        allOfElectronicProducts.add(sellerProduct);
    }

}
