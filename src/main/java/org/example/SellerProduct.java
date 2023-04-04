package org.example;

public class SellerProduct extends UserProduct {

    // Attributes
    private boolean isAvailable;

    // Constructor

    public SellerProduct(){
        this.isAvailable = true;
    }

    //Public Functions



    // Getter & Setter

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // To String

    @Override
    public String toString() {
        return "SellerProduct{" +
                "name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", quantity=" + this.getQuantity() +
                ", commentOfProduct='" + this.getCommentOfProduct() + '\'' +
                ", seller=" + this.getSeller().getCompanyName() +
                ", isAvailable="+ isAvailable +
                '}';
    }
}
