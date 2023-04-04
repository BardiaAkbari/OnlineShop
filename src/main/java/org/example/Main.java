package org.example;


import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runMenuForAll();
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
            sellerStartMenu();
        else if (number == 3)
            adminMenu();
        else{
            System.out.println("You choose wrong number, please choose right one!" + '\n');
            runMenuForAll();
        }

    }
    private static String passwordGeneratorAsking(Scanner myScanner) {
        String password;
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
        return password;
    }

    // Menu For User
    public static void userStartMenu(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hi there" + '\n' + "Do you have an account?: (yes / no)");
        String ansewr = myScanner.nextLine();
        if(ansewr.equals("yes") || ansewr.equals("Yes"))
            loginOperationForUser();
        else if (ansewr.equals("No") || ansewr.equals("no"))
            signupOperationForUser();
        else{
            System.out.println("Please give the right ansewr" + '\n');
            userStartMenu();
        }
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
        if(User.isUsernameExist(username)){
            System.out.println("This username is Exist, please Try again" + '\n');
            signupOperationForUser();
        }
        else{
            String password = passwordGeneratorAsking(myScanner);
            User newUser = new User(username, password);
            Shop.addAccount(newUser);
            userMenu(newUser);
        }
    }
    public static void userMenu(User user){
        System.out.println("Now you are in main Menu." + '\n' + "please select your operation :D" + '\n');
        System.out.println("1-Make Order" + '\n' + "2-Purchases" + '\n' + "3-My Last Orders" + '\n' + "4-Log out" + '\n' +
                "5-Request for increaing wallet price");
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        switch (number){
            case 1:
                Order myOrder = new Order(user);
                selectingCategory(user, myOrder);
            case 2:
                seePurchases(user);
            case 3:
                seeLastOrders(user);
            case 4:
                logout();
            case 5:
                increasingWalletPriceRequestForUser(user);
        }
    }
    public static void selectingCategory(User user, Order order){
        Scanner categoryScanner = new Scanner(System.in);
        System.out.println("Do you want to select category or just using search in all products?(yes(for using category)/no): ");
        System.out.println("If you wanna finish shoppping write word \"Finish\" ");
        String ansewr = categoryScanner.nextLine();
        if(ansewr.equals("yes") || ansewr.equals("Yes")){
            System.out.println("Please enter your target category" + '\n');
            System.out.println("1-Beauty" + '\n' + "2-Book" + '\n' + "3-Cloth" + '\n' + "4-Electronic" + '\n' +
                    "5-KitchenStuff" + '\n' + "6-SuperMarketStuff" + '\n' + "7-Vehicle" + '\n' + "8-OtherProducts");
            int select = categoryScanner.nextInt();
            makingOrder(user, select, order);
        }
        else if (ansewr.equals("no") || ansewr.equals("No")){
            System.out.println("Ok you use search from all products.");
            makingOrder(user,9, order);
        }
        else if (ansewr.equals("Finish") || ansewr.equals("finish")) {
            finishingTheOrder(user, order);
        }
        else{
            System.out.println("Please give right ansewr.");
            selectingCategory(user, order);
        }
    }
    public static void makingOrder(User user, int number, Order order){
        switch (number){
            case 1:
                beautyCategory(user, order);
                break;
            case 2:
                bookCategory(user, order);
                break;
            case 3:
                clothCategory(user, order);
                break;
            case 4:
                electronicCategory(user, order);
                break;
            case 5:
                kitchenStuffCategory(user, order);
                break;
            case 6:
                superMarketStuffCategory(user, order);
                break;
            case 7:
                vehicleCategory(user, order);
                break;
            case 8:
                otherProductCategory(user, order);
                break;
            case 9:
                allProductCategory(user, order);
        }
    }
    public static void userDemand(User user, Order order , int category){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("A)Be in this category" + '\n' +
                "B)Back to user menu(This make your order uncomplete and you must make it from first)" + '\n' +
                "C)Go to all Search box or selecting other category" + '\n' + "D)Finish the making order" + '\n' +
                "F)See my cart for update it");
        String respond = myScanner.nextLine();
        switch (respond) {

            case "A":
            case "a":
                makingOrder(user, category, order);
                break;
            case "B":
            case "b":
                userMenu(user);
                break;
            case "C":
            case "c":
                selectingCategory(user, order);
                break;
            case "D":
            case "d":
                finishingTheOrder(user, order);
                break;
            case "F":
            case "f":
                seeTheCart(user, order, category);
                break;
            default:
                System.out.println("You type wrong ansewr." + '\n' + "Please enter keywords that we offers." + '\n' +
                        "We must show the category page :(");
                selectingCategory(user, order);
                break;
        }
    }
    public static void beautyCategory(User user, Order order){
        Scanner beautyScanner = new Scanner(System.in);
        System.out.println("A)Search in beauty." + '\n'
                +"B)see all beauty products.(A/B)" + '\n' );
        String ansewr = beautyScanner.nextLine();
        if(ansewr.equals("A") || ansewr.equals("a")){
            System.out.println("Please enter your beauty product name: ");
            String productName = beautyScanner.nextLine();
            if(Beauty.SearchForBeautyProduct(productName) == null){
                System.out.println("Sorry we dont have product with this name :(");
            }
            else{
                System.out.println("Name: " + Beauty.SearchForBeautyProduct(productName).getName() + "      " + " Quantity: "
                        + Beauty.SearchForBeautyProduct(productName).getQuantity() + "     " + " Price: "
                        + Beauty.SearchForBeautyProduct(productName).getPrice() + "     " + " Product comment: "
                        + Beauty.SearchForBeautyProduct(productName).getCommentOfProduct());
                System.out.println('\n' + "Do you want this product?(yes/no)");
                String userDecide = beautyScanner.nextLine();
                if(userDecide.equals("yes") || userDecide.equals("Yes")){
                    Beauty newProduct = Beauty.SearchForBeautyProduct(productName);
                    System.out.println("How much do you want from this product?");
                    int range = beautyScanner.nextInt();

                    if(range > 0 && range <= newProduct.getQuantity()){
                        newProduct.setQuantity(newProduct.getQuantity() - range);
                        Beauty.removingOfBeautyProductIfTheyEnd(newProduct);
                        Shop.RemovingOfProductIfTheyEnd(newProduct);
                        Product myProduct = new Product();
                        myProduct.setName(newProduct.getName());
                        myProduct.setQuantity(range);
                        myProduct.setPrice(newProduct.getPrice());
                        myProduct.setCommentOfProduct(newProduct.getCommentOfProduct());
                        order.addingToUserorder(myProduct);
                        order.increasingNumberOfProducts(range);
                        order.increasingTotoalPrice(myProduct.getPrice() * range);
                    }
                    else{
                        System.out.println("You choose wrong amount, so we skip this part and you cant order this" +
                                "(you can order this again with correct amount).");
                    }
                }
                else {
                    System.out.println("So we skip this part.");
                }
            }
        }
        else{
            int round = 0;
            while(round < Beauty.numberOfBeautyProducts()){
                System.out.println(round + ") Name: " + Beauty.accessToBeautyProduct(round).getName() + "     " + " Quantity: "
                        + Beauty.accessToBeautyProduct(round).getQuantity() + "     " + " Price: "
                        + Beauty.accessToBeautyProduct(round).getPrice() + "        " + " Product comment: "
                        + Beauty.accessToBeautyProduct(round).getCommentOfProduct() + '\n');
                round++;
            }
        }
        userDemand(user, order , 1);
    }
    public static void bookCategory(User user, Order order){

    }
    public static void clothCategory(User user, Order order){}
    public static void electronicCategory(User user, Order order){}
    public static void kitchenStuffCategory(User user, Order order){}
    public static void superMarketStuffCategory(User user, Order order){}
    public static void vehicleCategory(User user, Order order){}
    public static void otherProductCategory(User user, Order order){}
    public static void allProductCategory(User user, Order order){}
    public static void handlingNumberOfProductsForSeeChart(User user, Product product, Order order, int category) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What do you want to do with this order?!" + '\n' + "A)Change the quantity." + '\n' +
                "B)Remove this product");
        String ansewr = myScanner.nextLine();
        if (ansewr.equals("A") || ansewr.equals("a")) {
            System.out.println("Give us new amount of product");
            int amount = myScanner.nextInt();
            Product myProduct = Shop.getFromAllProducts(product.getName());
            if (myProduct == null) {
                if (amount > product.getQuantity()) {
                    System.out.println("Sorry you cant order more from this product because it is finish." + '\n');
                }
                else if (amount < product.getQuantity()) {
                    product.setQuantity(amount);
                    myProduct = product;
                    myProduct.setQuantity(product.getQuantity() - amount);
                    Shop.addProductToAllProducts(myProduct);
                    String detectClass = product.getClass().getName();
                    if (detectClass.equals("org.example.Beauty")) {
                        Beauty.addToAllOfBeautyProducts((Beauty) myProduct);
                    }
                    // baghie ro ham handel kon
                }
            }
            else {
                int subtarct = product.getQuantity() - amount;
                if (subtarct > 0) {
                    product.setQuantity(amount);
                    myProduct.setQuantity(myProduct.getQuantity() + subtarct);
                }
                else if (subtarct < 0) {
                    if (myProduct.getQuantity() > -1 * subtarct) {
                        product.setQuantity(amount);
                        myProduct.setQuantity(myProduct.getQuantity() + subtarct);
                    }
                    else if (myProduct.getQuantity() == -1 * subtarct) {
                        Shop.RemovingOfProductIfTheyEnd(myProduct);
                        String detectClass = product.getClass().getName();
                        if (detectClass.equals("org.example.Beauty")) {
                            Beauty.removingOfBeautyProductIfTheyEnd((Beauty) myProduct);
                            // baghie ro handel kon
                        }
                    }
                    else {
                        System.out.println("Sorry you cant order this amount." + '\n' + "The highest amount is: " + myProduct.getQuantity());
                        handlingNumberOfProductsForSeeChart(user, product, order, category);
                    }
                }
            }
        }
        else if (ansewr.equals("B") || ansewr.equals("b")) {
            System.out.println("Ok this product is removed from your cart." + '\n');
            Product myProduct = Shop.getFromAllProducts(product.getName());
            if (myProduct == null) {
                Shop.addProductToAllProducts(product);
                String detectClass = product.getClass().getName();
                if (detectClass.equals("org.example.Beauty")) {
                    Beauty.addToAllOfBeautyProducts((Beauty) product);
                }

                // baqieee ro ham handel kon
            }
            else {
                myProduct.setQuantity(myProduct.getQuantity() + product.getQuantity());
            }
        }
        else {
            System.out.println("Please enter right ansewr." + '\n');
            handlingNumberOfProductsForSeeChart(user, product, order, category);
        }
        System.out.println("Do you want to continue(yes / no)?!" + '\n');
        String con = myScanner.nextLine();
        if(con.equals("Yes") || con.equals("yes")){
            seeTheCart(user, order,category);
        }
    }
    public static void seeTheCart(User user, Order order, int category) {
        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < order.numberOfUserOrder(); i++) {
            System.out.println(order.getFromUserOrder(i));
        }
        System.out.println("Do you want to change anything?!");
        String ansewr = myScanner.nextLine();
        if (ansewr.equals("Yes") || ansewr.equals("yes")) {
            System.out.println("Please enter the name of product that you want the change!");
            System.out.println("Please ٍenter your product name: ");
            String respond = myScanner.nextLine();
            if (order.getFromUserOrder(respond) == null) {
                System.out.println("Please enter right respond for product name(exactly that one we write for you)" + '\n');
                seeTheCart(user, order,category);
            }
            else{
                handlingNumberOfProductsForSeeChart(user, order.getFromUserOrder(respond), order,category);
            }
        }
        else if (ansewr.equals("No") || ansewr.equals("no")) {
            System.out.println("Ok you guid to the categories without any changing in the order." + '\n');
            selectingCategory(user, order);
        }
        else {
            System.out.println("Please choose between yes or no!" + '\n');
        }
        userDemand(user, order,category);
    }
    public static void NorthumberlandOfProductsDeletingIt(Order order){
        for(int i = 0; i < order.numberOfUserOrder(); i++){
            Product product = Shop.getFromAllProducts(order.getFromUserOrder(i).getName());
            String detectClass = order.getFromUserOrder(i).getClass().getName();
            if(product == null){
                Shop.addProductToAllProducts(order.getFromUserOrder(i));
                if(detectClass.equals("org.example.Beauty")){
                    Beauty.addToAllOfBeautyProducts((Beauty) order.getFromUserOrder(i));


                // baghie ro ham handel kon
                }
            }
            else{
                product.setQuantity(product.getQuantity() + order.getFromUserOrder(i).getQuantity());
            }
        }
    }
    public static void finishingTheOrder(User user, Order order){
        if(user.getWalletCash() >= order.getTotalPrice()){
            System.out.println("your order has accepted!");
            user.decreasingWalletCash(user.getWalletCash() - order.getTotalPrice());
            user.addToOrders(order);
            Date date = new Date();
            Purchase newPurchase = new Purchase(user ,date, order, order.getTotalPrice());
            user.addToAllPurchaseProducts(newPurchase);
        }
        else{
            System.out.println("Your wallet cash is not enough this stuff." + '\n' + "We take you back to the main user menu" + '\n');
            NorthumberlandOfProductsDeletingIt(order);
            userMenu(user);
        }
    }
    public static void seeLastOrders(User user){
        for(int i = 0; i < user.numberOfAllOrders(); i++){
            System.out.println(user.getFromOrders(i));
        }
    }
    public static void seePurchases(User user){
        for(int  i = 0; i < user.numberAllPurchaseProducts(); i++){
            System.out.println(user.getFromAllPurchaseProducts(i));
        }
    }
    public static void increasingWalletPriceRequestForUser(User user){
        Request newRequest = new Request();
        System.out.println("Please enter your price that you want: ");
        Scanner myScanner = new Scanner(System.in);
        int price = myScanner.nextInt();
        newRequest.requestOfIncreasingPriceOfWalletForUser(user, price);
    }
    public static void logout(){

        Scanner logScanner = new Scanner(System.in);
        System.out.println("Do you want to exit onlineshop too?(yes / no)");
        String ansewr = logScanner.nextLine();
        if(ansewr.equals("yes") || ansewr.equals("Yes")){
            System.out.println("You make us happy to visit our onlineshop.");
            System.exit(1);
        }
        else if (ansewr.equals("no") || ansewr.equals("No")){
            System.out.println("You loged out");
            runMenuForAll();
        }
        else{
            System.out.println("Please ansewr in right way.");
            logout();
        }
    }

    // Menu For Seller
    public static void sellerStartMenu(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hi there" + '\n' + "Do you have an account?: (yes / no)");
        String ansewr = myScanner.nextLine();
        if(ansewr.equals("yes") || ansewr.equals("Yes"))
            loginOperationForSeller();
        else if (ansewr.equals("No") || ansewr.equals("no"))
            signupOperationForSeller();
        else{
            System.out.println("Please give the right ansewr" + '\n');
            sellerStartMenu();
        }
    }
    public static void loginOperationForSeller(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = myScanner.nextLine();
        System.out.println("Please enter your passwrod: ");
        String password = myScanner.nextLine();
        if(Seller.isSellerExist(username, password) == null){
            System.out.println("There no account with this username and password, Please Try again!" + '\n');
            loginOperationForUser();
        }
        else
            sellerMenu(Seller.isSellerExist(username, password));
    }
    public static void signupOperationForSeller(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("You must creat account.");
        System.out.println("Please enter your username: ");
        String username = myScanner.nextLine();
        if(Seller.isUsernameExist(username)){
            System.out.println("This username is Exist, please Try again" + '\n');
            signupOperationForUser();
        }
        else{
            String password = passwordGeneratorAsking(myScanner);
            System.out.println("Now please enter your company name : ");
            String companyName = myScanner.nextLine();
            Seller newSeller = new Seller(username, password, companyName);
            Shop.addAccount(newSeller);
            sellerMenu(newSeller);
        }
    }
    public static void sellerMenu(Seller seller){
        System.out.println("Now you are in main Menu." + '\n' + "Please select your operation :D" + '\n');
        System.out.println("1-Add product" + '\n' + "2-Remove product" + '\n' + "3-edit product" + '\n' + "4-Log Out" );
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        switch (number){
            case 1:

        }
    }


    public static void addProduct(Seller seller){

    }


















    // Menu For Admin
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