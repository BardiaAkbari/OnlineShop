package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runMenuForAll();
    }

    // Functions For all

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

    // Functions For User

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
        String answer = categoryScanner.nextLine();
        switch (answer) {
            case "yes":
            case "Yes":
                System.out.println("Please enter your target category" + '\n');
                System.out.println("1-Beauty" + '\n' + "2-Book" + '\n' + "3-Cloth" + '\n' + "4-Electronic" + '\n' +
                        "5-KitchenStuff" + '\n' + "6-SuperMarketStuff" + '\n' + "7-Vehicle" + '\n' + "8-OtherProducts");
                int select = categoryScanner.nextInt();
                passingCategoryTOCorrespondingFunction(user, select, order);
                break;
            case "no":
            case "No":
                System.out.println("Ok you use search from all products.");
                passingCategoryTOCorrespondingFunction(user, 9, order);
                break;
            case "Finish":
            case "finish":
                finishingTheOrder(user, order);
                break;
            default:
                System.out.println("Please give right ansewr.");
                selectingCategory(user, order);
                break;
        }
    }

    public static void passingCategoryTOCorrespondingFunction(User user, int number, Order order){
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

    public static void beautyCategory(User user, Order order){
        Scanner beautyScanner = new Scanner(System.in);
        System.out.println("A)Search in beauty." + '\n'
                +"B)see all beauty products.(A/B)" + '\n' );
        String answer = beautyScanner.nextLine();
        if(answer.equals("A") || answer.equals("a")){
            System.out.println("Please enter your beauty product name: ");
            String productName = beautyScanner.nextLine();
            if(Beauty.SearchForBeautyProduct(productName) == null){
                System.out.println("Sorry we dont have product with this name :(");
            }
            else{
                System.out.println("Name: " + Beauty.SearchForBeautyProduct(productName).getName() + "      " + " Quantity: "
                        + Beauty.SearchForBeautyProduct(productName).getQuantity() + "     " + " Price: "
                        + Beauty.SearchForBeautyProduct(productName).getPrice() + "     " + " SellerProduct comment: "
                        + Beauty.SearchForBeautyProduct(productName).getCommentOfProduct());
                System.out.println('\n' + "Do you want this product?(yes/no)");
                String userDecide = beautyScanner.nextLine();
                if(userDecide.equals("yes") || userDecide.equals("Yes")){
                    SellerProduct userDecideProduct = Beauty.SearchForBeautyProduct(productName);
                    System.out.println("How much do you want from this product?");
                    int range = beautyScanner.nextInt();
                    if(range > 0 && range <= userDecideProduct.getQuantity() && userDecideProduct.isAvailable()){
                        userDecideProduct.setQuantity(userDecideProduct.getQuantity() - range);
                        Shop.changingTheAvailableStatusOfAllProductIfTheyEnd(userDecideProduct);
                        UserProduct userProduct = new UserProduct();
                        userProduct.setName(userDecideProduct.getName());
                        userProduct.setQuantity(range);
                        userProduct.setPrice(userDecideProduct.getPrice());
                        userProduct.setCommentOfProduct(userDecideProduct.getCommentOfProduct());
                        order.addToProductUserOrders(userProduct);
                        order.increasingNumberOfProducts(range);
                        order.increasingTotalPrice(userProduct.getPrice() * range);
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
                        + Beauty.accessToBeautyProduct(round).getPrice() + "        " + " SellerProduct comment: "
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

    public static void userDemand(User user, Order order , int category){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("A)Be in this category" + '\n' +
                "B)Back to user menu(This make your order uncompleted and you must make it from first)" + '\n' +
                "C)Go to all Search box or selecting other category" + '\n' + "D)Finish the making order" + '\n' +
                "F)See my cart for update it");
        String respond = myScanner.nextLine();
        switch (respond) {

            case "A":
            case "a":
                passingCategoryTOCorrespondingFunction(user, category, order);
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
                seeTheShoppingCart(user, order, category);
                break;
            default:
                System.out.println("You type wrong ansewr." + '\n' + "Please enter keywords that we offers." + '\n' +
                        "We must show the category page :(");
                selectingCategory(user, order);
                break;
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
            addProfits(order);
        }
        else{
            System.out.println("Your wallet cash is not enough this stuff." + '\n' +
                    "We take you back to the main user menu" + '\n');
            numberOfProductsWhenDeletes(order);
            userMenu(user);
        }
    }

    public static void addProfits(Order order){
        for(int i = 0; i < order.numberOfProductUserOrder(); i++){
            UserProduct target = order.getFromUserOrder(i);
            target.getSeller().increasingProfitFromSelling(target.getPrice() * target.getQuantity() * 90 / 100);
        }
        Shop.increasingPrfoitFromAllOrders(order.getTotalPrice() / 10);
    }

    public static void numberOfProductsWhenDeletes(Order order){
        for(int i = 0; i < order.numberOfProductUserOrder(); i++){
            UserProduct userProduct = order.getFromUserOrder(i);
            SellerProduct sellerProduct = Shop.getFromAllProducts(userProduct.getName());
            if(!sellerProduct.isAvailable()){
                Shop.changingTheAvailableStatusOfAllProductIfTheyEnd(sellerProduct);
                sellerProduct.setQuantity(userProduct.getQuantity());
                }
            else{
                sellerProduct.setQuantity(sellerProduct.getQuantity() + userProduct.getQuantity());
            }
        }
    }

    public static void seeTheShoppingCart(User user, Order order, int category) {
        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < order.numberOfProductUserOrder(); i++) {
            System.out.println(order.getFromUserOrder(i));
        }
        System.out.println("Do you want to change anything?!");
        String answer = myScanner.nextLine();
        if (answer.equals("Yes") || answer.equals("yes")) {
            System.out.println("Please enter the name of product that you want the change.(it must be in product we show you!): ");
            String respond = myScanner.nextLine();
            if (order.getFromUserOrder(respond) == null) {
                System.out.println("Please enter right respond for product name(exactly that one we write for you)" + '\n');
                seeTheShoppingCart(user, order,category);
            }
            else{
                handlingNumberOfProductsForSeeShoppingCart(user, order.getFromUserOrder(respond), order,category);
            }
        }
        else if (answer.equals("No") || answer.equals("no")) {
            System.out.println("Ok you guid to the categories without any changing in the order." + '\n');
            userDemand(user, order, category);
        }
        else {
            System.out.println("Please choose between yes or no!" + '\n');
            seeTheShoppingCart(user, order, category);
        }
    }

    public static void handlingNumberOfProductsForSeeShoppingCart(User user, UserProduct userProduct, Order order, int category) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What do you want to do with this order?!" + '\n' + "A)Change the quantity." + '\n' +
                "B)Remove this product");
        String answer = myScanner.nextLine();
        if (answer.equals("A") || answer.equals("a")) {
            System.out.println("Give us new amount of product: ");
            int amount = myScanner.nextInt();
            SellerProduct sellerProduct = Shop.getFromAllProducts(userProduct.getName());
            if (!sellerProduct.isAvailable()) {
                if (amount > userProduct.getQuantity()) {
                    System.out.println("Sorry you cant order more from this product because it is finish." + '\n');
                }
                else if (amount < userProduct.getQuantity()) {
                    userProduct.setQuantity(amount);
                    Shop.changingTheAvailableStatusOfAllProductIfTheyEnd(sellerProduct);
                    sellerProduct.setQuantity(userProduct.getQuantity() - amount);
                    System.out.println("Ok, This demand amount is set.");
                }
            }
            else {
                int subtract = userProduct.getQuantity() - amount;
                if (subtract > 0) {
                    userProduct.setQuantity(amount);
                    sellerProduct.setQuantity(sellerProduct.getQuantity() + subtract);
                }
                else if (subtract < 0) {
                    if (sellerProduct.getQuantity() > -1 * subtract) {
                        userProduct.setQuantity(amount);
                        sellerProduct.setQuantity(sellerProduct.getQuantity() + subtract);
                    }
                    else if (sellerProduct.getQuantity() == -1 * subtract) {
                        Shop.changingTheAvailableStatusOfAllProductIfTheyEnd(sellerProduct);
                        sellerProduct.setQuantity(0);
                        userProduct.setQuantity(amount);
                    }
                    else {
                        System.out.println("Sorry you cant order this amount." + '\n' + "The highest amount is: " + sellerProduct.getQuantity() + userProduct.getQuantity());
                        handlingNumberOfProductsForSeeShoppingCart(user, userProduct, order, category);
                    }
                }
            }
        }
        else if (answer.equals("B") || answer.equals("b")) {
            SellerProduct myProduct = Shop.getFromAllProducts(userProduct.getName());
            if (!myProduct.isAvailable()) {
                Shop.changingTheAvailableStatusOfAllProductIfTheyEnd(myProduct);
                myProduct.setQuantity(userProduct.getQuantity());
            }
            else {
                myProduct.setQuantity(myProduct.getQuantity() + userProduct.getQuantity());
            }
            order.removingProductFromProductUserOrder(userProduct);
            System.out.println("Ok this product is removed from your cart." + '\n');
        }
        else {
            System.out.println("Please enter right answer." + '\n');
            handlingNumberOfProductsForSeeShoppingCart(user, userProduct, order, category);
        }
        System.out.println("Do you want to continue(yes / no)?!" + '\n');
        String con = myScanner.nextLine();
        if(con.equals("Yes") || con.equals("yes")){
            seeTheShoppingCart(user, order,category);
        }
        else{
            userDemand(user, order, category);
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
        System.out.println("1-Add product" + '\n' + "2-Change available product status" + '\n' + "3-Edit product" + '\n' + "4-Log Out" );
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        switch (number){
            case 1:
                addProduct(seller);
                break;
            case 2:
                changeProductStatus(seller);
                break;
            case 3:
                editProduct(seller);
                break;
            case 4:
                logout();
                break;
        }
    }

    public static void addProduct(Seller seller){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your product name: ");
        SellerProduct mySellerProduct = new SellerProduct();
        mySellerProduct.setName(myScanner.nextLine());
        System.out.println("Enter your product quantity: ");
        mySellerProduct.setQuantity(myScanner.nextInt());
        System.out.println("Enter your product price: ");
        mySellerProduct.setPrice(myScanner.nextInt());
        System.out.println("Please describe your product for user to know it better.(if you dont have any just press enter): ");
        mySellerProduct.setCommentOfProduct(myScanner.nextLine());
        System.out.println("Please enter your product category name.");
        String category = myScanner.nextLine();
        addProductToSpecificCategory(seller, mySellerProduct, category);
        System.out.println('\n' + "Your product is addeed to shop.");
    }

    public static void addProductToSpecificCategory(Seller seller, SellerProduct sellerProduct, String category){
        Shop.addProductToAllProducts(sellerProduct);
        switch (category){
            case "Beauty":
            case "beauty":
                Beauty.addToAllOfBeautyProducts(sellerProduct);
                break;
                // Baghie ro ham bezan
        }
    }

    public static void changeProductStatus(Seller seller){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your product that you want change: ");
        String answer = myScanner.nextLine();
        SellerProduct target = seller.getSellerProduct(answer);
        if(target == null){
            System.out.println("This product is not in your market."+ '\n' + "Please enter right answer.");
            changeProductStatus(seller);
        }
        else{
            System.out.println("The status of your desired product has changed.");
            Shop.changingTheAvailableStatusOfAllProductIfTheyEnd(target);
        }
        System.out.println("Do you want to do this with another product?!(Yes/No)");
        String respond = myScanner.nextLine();
        if(respond.equals("Yes") || respond.equals("yes")){
            changeProductStatus(seller);
        }
        else {
            System.out.println("You backing to main seller menu.");
            sellerMenu(seller);
        }
    }

    public static void editProduct(Seller seller){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Give the product name that you want to edit: ");
        String answer = myScanner.nextLine();
        SellerProduct sellerProduct = seller.getSellerProduct(answer);
        if(sellerProduct == null){
            System.out.println("There is no product name like this in your all products." + '\n' +
                    "Please give the right answer.");
        }
        else{
            changingProductPart(seller, sellerProduct);
        }
        System.out.println("Do you want to change anything?(Yes/No)");
        String con = myScanner.nextLine();
        if(con.equals("Yes") || con.equals("yes")){
            editProduct(seller);
        }
        else {
            sellerMenu(seller);
        }
    }

    public static void changingProductPart(Seller seller,SellerProduct sellerProduct){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What part of product do you want to change?" + '\n'
                + "A)Name" + '\n' + "B)Price" + '\n' + "C)Quantity" + '\n' +"D)Product comment");
        String respond = myScanner.nextLine();
        switch (respond){
            case "A":
            case"a":
                System.out.println("Enter your new product name: ");
                sellerProduct.setName(myScanner.nextLine());
                break;
            case "B":
            case "b":
                System.out.println("Enter your new product price: ");
                sellerProduct.setPrice(myScanner.nextInt());
                break;
            case "C":
            case "c":
                System.out.println("Enter your new product quantity: ");
                sellerProduct.setQuantity(myScanner.nextInt());
                break;
            case "D":
            case "d":
                System.out.println("Enter your new product 'product comment': ");
                sellerProduct.setCommentOfProduct(myScanner.nextLine());
                break;
            default:
                System.out.println("You choose wrong word." + '\n' + "please try again");
                changingProductPart(seller, sellerProduct);
                break;
        }
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