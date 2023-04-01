package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }



































    // Menu For all
    public static void runMenuForAll(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to our onlineshop!");
        System.out.println("Please choose your postion!" + '\n' + "1-User" + '\n' + "2-Seller" + '\n' + "3-Admin");
        int number = myScanner.nextInt();
        if(number == 1)
            userStartMenu();
        else if(number == 2)
            sellerMenu();
        else if (number == 3)
            adminMenu();
        else{
            System.out.println("You choose wrong number, please choose right one!" + '\n');
            runMenuForAll();
        }

    }

    // Menu For User
    public static void userStartMenu(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hi there" + '\n' + "Do you have an account?: (yes / no)");
        String ansewr = myScanner.nextLine();
        if(ansewr.equals("yes") || ansewr.equals("Yes"))
            loginOperationForUser();
        else
            signupOperationForUser();
    }
    public static void loginOperationForUser(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = myScanner.nextLine();
        System.out.println("Please enter your passwrod: ");
        String password = myScanner.nextLine();
        if (User.isUserExist(username, password) == null) {
            System.out.println("There no account with this username and password, Please Try again!" + '\n');
            loginOperationForUser();
        }
        else
            userMenu(User.isUserExist(username, password));
    }
    public static void signupOperationForUser(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("You must creat account.");
        System.out.println("Please enter your username: ");
        String username = myScanner.nextLine();
        String password;
        if(User.isUsernameExist(username)){
            System.out.println("This username is Exist, please Try again" + '\n');
            signupOperationForUser();
        }
        else{
            System.out.println("well done, Do you want to generate password for you?(yes / no): ");
            String ansewr = myScanner.nextLine();
            if(ansewr.equals("yes") || ansewr.equals("Yes")){
                password = User.passwordGenerator();
                System.out.println("Your password is : " + password + '.' + '\n' + "Please save it");
            }
            else {
                System.out.println("Please enter your password");
                password = myScanner.nextLine();
            }
            User newUser = new User(username, password);
            Shop.addAccount(newUser);
            userMenu(newUser);
        }
    }
    public static void increasingWalletPriceRequestForUser(User user){
        Request newRequest = new Request();
        System.out.println("Please enter your price that you want: ");
        Scanner myScanner = new Scanner(System.in);
        int price = myScanner.nextInt();
        newRequest.requestOfIncreasingPriceOfWalletForUser(user, price);
    }
//    public static void makingOrder(){
//
//    }
    public static void userMenu(User user){
        System.out.println("Now you are in main Menu." + '\n' + "please select your operation :D" + '\n');
        System.out.println("1-Make Order" + '\n' + "2-Purchase Products" + '\n' + "3-My Last Orders" + '\n' + "4-Log out" + '\n' +
                "5-Request for increaing wallet price");
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        switch (number){
            case 1:




            case 5:
                increasingWalletPriceRequestForUser(user);

        }








    }

    // Menu For Seller

    public static void sellerMenu(){

    }













    // Admin
    public static void readingWalletUserRequests(){
        Scanner readingScnanner = new Scanner(System.in);
        int round = 0;
        boolean flag = true;
        while(flag && round < Admin.numberOfRequests() ){
            System.out.println("The user " + Admin.accesssToRequest(round).getUser().getUsername() + "have an request for " +
                    Admin.accesssToRequest(round).getPrice() + '.' + '\n' + "Do you want to accept it? (yes/no/skip): ");
            String ansewr = readingScnanner.nextLine();
            if(ansewr.equals("yes") || ansewr.equals("Yes")){
                Admin.removingUserRequest(Admin.accesssToRequest(round));
                System.out.println("The request have accepted.");
            }
            else if (ansewr.equals("No") || ansewr.equals("no")) {
                Admin.removingUserRequest(Admin.accesssToRequest(round));
                System.out.println("The request have not accpeted.");
            }
            else
                System.out.println("The request have skipped.");
            System.out.println('\n' + "Do you want to see other requests?! (yes/no)");
            String resume = readingScnanner.nextLine();
            if(resume.equals("no") || resume.equals("No")){
                flag = false;
                adminMenu();
            }
        }
    }
    public static void adminMenu() {

    }
}