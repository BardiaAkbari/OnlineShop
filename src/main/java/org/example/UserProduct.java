package org.example;

public class UserProduct {

    // Attributes
    private String name;
    private int price;
    private int quantity;
    private String commentOfProduct;
    private Seller seller;



    // Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCommentOfProduct() {
        return commentOfProduct;
    }

    public void setCommentOfProduct(String commentOfProduct) {
        this.commentOfProduct = commentOfProduct;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    // To String


    @Override
    public String toString() {
        return "UserProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", commentOfProduct='" + commentOfProduct + '\'' +
                ", seller=" + seller +
                '}';
    }
}
