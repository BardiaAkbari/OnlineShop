package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Account{
    // Attributes
    private static ArrayList<Request> allUserWalletRequest = new ArrayList<>();
    // Constructor
    public Admin(String username, String password){
        super(username, password);
    }


    // Public Functions
    public static void addingUserWalletRequest(Request request){
        allUserWalletRequest.add(request);
    }
    public static void removingUserRequest(Request request){
        allUserWalletRequest.remove(request);
    }
    public static int numberOfRequests(){
        return allUserWalletRequest.size();
    }
    public static Request accesssToRequest(int index){
        return allUserWalletRequest.get(index);
    }
}
