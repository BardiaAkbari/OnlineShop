package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Account{
    // Attributes
    private String email;
    private static ArrayList<Admin> allAdmins = new ArrayList<>();
    private static ArrayList<Request> allUserWalletRequest = new ArrayList<>();
    // Constructor
    public Admin(String username, String password){
        super(username, password);
        allAdmins.add(this);
    }

    // Public Functions

    public static Admin isAdminExist(String username, String password){
        Admin target = null;
        for (Admin admin : allAdmins) {
            if (admin.getUsername().equals(username)) {
                if (admin.getPassword().equals(password))
                    target = admin;
                break;
            }
        }
        return target;
    }

    public static void addingUserWalletRequest(Request request){
        allUserWalletRequest.add(request);
    }

    public static void removingUserRequest(Request request){
        allUserWalletRequest.remove(request);
    }

    public static int numberOfRequests(){
        return allUserWalletRequest.size();
    }

    public boolean isMasterAdmin(Admin admin){
        return admin.getUsername().equals("Bardi_ya");
    }

    public boolean isMasterAdmin(String username){
        return username.equals("Bardi_ya");
    }

    public static Request accesssToRequest(int index){

        return allUserWalletRequest.get(index);
    }

    // Getter & Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // To String
    @Override
    public String toString() {
        return "Admin{" +
                "username='" + this.getUsername() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
