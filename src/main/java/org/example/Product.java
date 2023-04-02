package org.example;

import java.util.ArrayList;
import java.util.UUID;

public class Product {
    // Attributes
    private String name;
    private int price;
    private int quantity;
    private String commentOfProduct;
    private String id;

    public Product(){
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }



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

    public String getId() {
        return id;
    }
}
