package org.example;

import java.util.ArrayList;

public class Vehicle extends SellerProduct {
    // Attributes
    private static ArrayList<SellerProduct> allOfVehicleProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfVehicleProducts(){
        return allOfVehicleProducts.size();
    }
    public static SellerProduct accessToVehicleProduct(int index){
        return allOfVehicleProducts.get(index);
    }
    public static SellerProduct SearchForVehicleProduct(String name){
        SellerProduct sellerProduct = null;
        for(SellerProduct myVehicle : allOfVehicleProducts){
            if(myVehicle.getName().equals(name)){
                sellerProduct = myVehicle;
                break;
            }
        }
        return sellerProduct;
    }
    public static void addToAllOfVehicleProducts(SellerProduct sellerProduct){
        allOfVehicleProducts.add(sellerProduct);
    }
}
