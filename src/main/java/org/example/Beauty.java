package org.example;

import java.util.ArrayList;

public class Beauty extends Product{
    // Attributes
    private static ArrayList<Beauty> allOfBeautyProducts = new ArrayList<>();
    // Public Functions
    public static int numberOfBeautyProducts(){
        return allOfBeautyProducts.size();
    }
    public static Beauty accessToBeautyProduct(int index){
        return allOfBeautyProducts.get(index);
    }
    public static Beauty SearchForBeautyProduct(String name){
        Beauty beauty = null;
        for(Beauty mybeauty : allOfBeautyProducts){
            if(mybeauty.getName().equals(name)){
                beauty = mybeauty;
                break;
            }
        }
        return beauty;
    }
    public static void decreasingAmountOfBeautyProduct(Beauty beauty ,int range){
        int newQuantitiy = beauty.getQuantity() - range;
        if(newQuantitiy == 0){
            allOfBeautyProducts.remove(beauty);
        }
        else{
            beauty.setQuantity(newQuantitiy);
        }
    }
}
