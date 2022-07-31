import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public record MyTaxi(StandardTaxi standardTaxi, LuxuryTaxi luxuryTaxi, ExecutiveTaxi executiveTaxi) {
    static Scanner myScanner = new Scanner(System.in);
    private static String name;
    private static String phoneNumber;
    private static double amount;
    private static int km;
    private static double passengerWallet;

    public boolean searchRides() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void rideDistanceAndPrice() {
        Random random = new Random();
        int distanceOfRide = random.nextInt(21) + 5;
        double farePrice = 0;
        km = distanceOfRide;

        System.out.println("Input your pick up Location");
        String currentLocation = myScanner.nextLine();
        System.out.println("Input your destination ");
        String gotoDestination = myScanner.nextLine();

        System.out.println();
        System.out.print(currentLocation + " to " + gotoDestination);
        System.out.println(" is " + distanceOfRide + " Km.");
        System.out.println();

        System.out.println(""" 
                Select taxi for your ride:
                1   For Standard Ride.
                2   For Luxury Ride.
                3   For Executive Ride."""
        );

        int input = myScanner.nextInt();
        myScanner.nextLine();
        bookingRide(input, farePrice, distanceOfRide);

    }

    public void bookingRide(int number, double farePrice2, int distanceOfRide2) {
        String taxiType = null;
        double thePrice;

        if(number == 1){
            thePrice = standardTaxi.getPrice() * distanceOfRide2;
            taxiType = standardTaxi.getRideType();
        } else if(number == 2){
            thePrice = luxuryTaxi.getPricePerKilometer() * distanceOfRide2;
            taxiType = luxuryTaxi.getRideType();
        } else if(number == 3){
            thePrice = executiveTaxi.getPrice() * distanceOfRide2;
            taxiType = executiveTaxi.getRideType();
        } else {
            System.out.println("HUH?...");
            return;
        }

        System.out.println();
        System.out.print(taxiType + "ride selected. ");
        System.out.println("... ");

        System.out.println("Please hold on while we find you a ride.");
        boolean flag = true;
        while(flag){
            if(!searchRides()){
                System.out.println("No rides are available...");
                System.out.println("..searching, Just a seconds.");

            } else {

                System.out.println("Yikes! We found you a ride.");
                System.out.println();
                System.out.println("Your ride details:");
                boolean taxiInfo = true;
                while (taxiInfo) {
                    if (number == 1) standardTaxi.getInfo();
                    if (number == 2) luxuryTaxi.getInfo();
                    if (number == 3) executiveTaxi.getInfo();
                    taxiInfo = false;
                }

                farePrice2 += thePrice;
                System.out.println("\nFare for this ride is " +  thePrice);
                System.out.println();
                bookingConfirmation(farePrice2);
                flag = false;
            }
        }
    }

    public void bookingConfirmation(double farePrice) {
        System.out.println("""
                To confirm this booking press 1
                To cancel this order press 0
                """
        );

        int decision = myScanner.nextInt();
        myScanner.nextLine();
        try {
            if (decision == 1) {
                System.out.println("Lets process your payment for this ride.");
                System.out.println("Pls hold...");
                double moneyReceived = passengerWallet;

                if (moneyReceived < farePrice) {
                    System.out.println("""
                            You have insufficient balance for this payment.
                            Press 1 to top up your wallet
                            Press 0 to exit this order"""
                    );
                    int takeOption = myScanner.nextInt();
                    reload(takeOption, farePrice);
                }

                passengerWallet-=farePrice;
                if(passengerWallet < 0) {
                    passengerWallet += farePrice;
                    farePrice = 0;
                    return;
                }
                // System.out.println("Do you have a discount code? "); I will add this discount function later.
                System.out.print("Payment successful!");
                System.out.println(" Thanks.");
                amount = farePrice;

                System.out.println();
                System.out.println("Ride receipt:");
                System.out.println("riders name is " + name + " and phone number is " + phoneNumber);
                System.out.println("Ride distance: " + km + ". Ride Fee: " + farePrice);
                System.out.println("Wallet balance: " + passengerWallet);
                System.out.println("Thanks, Book with us again! ");

                System.out.println();
                System.out.println("Please leave a review for this ride from 1-5 star");
                review();
            }

            if (decision == 0) System.out.println("Order canceled!");
        } catch (Exception e) {
            System.out.println("Something went wrong..");
        }
    }
    public void reload(int option, double amountToPay){
        if(option == 0 && amountToPay != 0) {
            System.out.println("order closed, Thanks");
        }
        else if(option == 1 && amountToPay != 0) {
            System.out.println("Yikes! lets reload your wallet");
            System.out.println("Enter amount to top up ");
            int reloadAmount = myScanner.nextInt();
            passengerWallet += reloadAmount;

            if(passengerWallet < amountToPay) {
                System.out.println("Your balance is still too low...");
                System.out.print("press 1 to continue to reload OR ");
                System.out.println("Press 0 to cancel this order ");
                int choiceOfReload = myScanner.nextInt();
                while(true) {
                    if(choiceOfReload == 0){
                        System.out.println("order cancelled.. Bye");
                        System.out.println("""
                Press
                1 to book a ride.
                2 to search for taxi.
                3 to for passenger number.
                4 to quit this application.
                5 to return to Menu.
                6 to reload passenger wallet.
                7 to check wallet Balance.
                """
                        );
                        break;
                    }
                    if (choiceOfReload == 1){
                        topUpWallet();
                        if(passengerWallet < amountToPay){

                            System.out.println("You've tried too many times");
                            System.out.println("Press 6 to reload wallet");
                           return;
                        }
                        break;
                    } else {
                        System.out.println("HUh? ");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Sorry, That's not a valid option");
        }
    }

    public void numberOfPassengers() {
        final Random random = new Random();
        int numOfPax = random.nextInt(3) + 1;
        System.out.println("number of passengers = " + numOfPax);
    }

    public void passengerInfo() {
        try {
            System.out.println("Enter your name: ");
            name = myScanner.nextLine();
            System.out.println("Enter your phoneNumber: ");
            phoneNumber = myScanner.nextLine();
        } catch (Exception e) {
            System.out.println("incorrect input, check your letters and spellings");
        }
    }

    public void topUpWallet(){
        try {
            System.out.println("Enter Top up amount");
            double topUPAmount = myScanner.nextDouble();
            passengerWallet += topUPAmount;
            System.out.print("Top up successful! ");
            System.out.println("New wallet Balance = $" + passengerWallet);
        } catch (Exception e) {
            System.out.println("sorry, we suspect a problem");
        }
    }
    public void checkWalletBalance(){
        System.out.println("Wallet Balance = $" + passengerWallet);
    }
    public void review(){
       // System.out.println("Rate this ride ");
        int rate;
        rate = myScanner.nextInt();
        myScanner.nextLine();
        while (rate <= 0 || rate >= 6) {
            // System.out.println("...");
            System.out.println("Input ratings from 1-5 only");
            int newRate = myScanner.nextInt();
            rate = newRate;
            myScanner.nextLine();
        }

        for(int i = 0; i <rate; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("Thanks for the review");
        System.out.println();
        System.out.println("""
                Press
                1 to book a ride.
                2 to search for taxi.
                3 to for passenger number.
                4 to quit this application.
                5 to return to Menu.
                6 to reload passenger wallet.
                7 to check wallet Balance.
                """
        );
    }
}
