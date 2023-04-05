package org.example;

public class Request {
    // Attributes
    private User user;
    private int price;
    // Public Functions
    public void requestOfIncreasingPriceOfWalletForUser(User user, int price) {
        this.user = user;
        this.price = price;
        Admin.addingUserWalletRequest(this);
    }

    // Getter & Setter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
