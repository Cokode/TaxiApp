import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    static Scanner myScanner = new Scanner(in);
    public static StandardTaxi standardTaxi = new StandardTaxi("Moses", "08067543628", 45, "Grey", "Toyota Corolla", "ABJ763", "Sedan", "Standard ");
    public static LuxuryTaxi luxuryTaxi = new LuxuryTaxi();
    public static ExecutiveTaxi executiveTaxi = new ExecutiveTaxi();
    public static MyTaxi myTaxi = new MyTaxi(standardTaxi, luxuryTaxi, executiveTaxi);


    public static void bookRide() {

        System.out.println("Please provide your details");
        myTaxi.passengerInfo();
        System.out.println();

        myTaxi.rideDistanceAndPrice();
        System.out.println();
    }
    public static void findRides(){
        if(myTaxi.searchRides()) {
            System.out.println("Rides are available");
            //bookRide();
        } else {
            System.out.println("rides are not available at the moment, try again later.");
        }
    }
    public static void loadWallet(){
        myTaxi.topUpWallet();
    }
    // How are you today

    public static void myTaxiMenu(){
        System.out.println("""
                Press
                1 to book a ride.
                2 to search for taxi.
                3 for passenger number.
                4 to quit this application.
                5 to return to Menu.
                6 to reload passenger wallet.
                7 to check wallet Balance.
                """
        );
    }
    public static void passengersInRide(){
        myTaxi.numberOfPassengers();
    }
    public static void walletBalance(){
        myTaxi.checkWalletBalance();
    }

    public static void main(String[] args) {
        boolean quit = false;

        myTaxiMenu();
        do {
            System.out.println();
            System.out.println("Select menu option");
            int options = myScanner.nextInt();
            switch (options) {
                case 1 -> bookRide();
                case 4 -> quit = true;
                case 3 -> passengersInRide();
                case 2 -> findRides();
                case 5 -> myTaxiMenu();
                case 6 -> loadWallet();
                case 7 -> walletBalance();
                default -> System.out.println("invalid selection, press 5 to return to menu");
            }
        } while (!quit);
    }
}
