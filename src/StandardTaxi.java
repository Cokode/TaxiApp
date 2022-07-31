import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class StandardTaxi {
    static Scanner myScanner = new Scanner(in);
    private final String driverName ;
    private final String driverPhoneNumber;
    private final String carModel;
    private final String carPlateNumber;
    private final int driverAge;
    private final String carColor;
    private final String carType;
    private final String rideType;
    private final double price;

    public StandardTaxi(String driverName, String driverPhoneNumber, int driverAge, String carColor, String carModel, String carPlateNumber, String carType, String rideType) {
        this.driverName = driverName;
        this.driverPhoneNumber = driverPhoneNumber;
        this.carModel = carModel;
        this.carPlateNumber = carPlateNumber;
        this.driverAge = driverAge;
        this.carColor = carColor;
        this.carType = carType;
        this.rideType = rideType;
        this.price = 1.2;
    }

    public String getDriverName(){
        return this.driverName;
    }
    public String getDriverPhoneNumber(){
        return this.driverPhoneNumber;
    }
    public String getCarModel(){
        return this.carModel;
    }
    public String getCarPlateNumber(){
        return this.carPlateNumber;
    }
    public int getDriverAge(){
        return this.driverAge;
    }
    public String getCarColor(){
        return this.carColor;
    }
    public String getCarType(){
        return this.carType;
    }

    public String getRideType(){
        return this.rideType;
    }

    public double getPrice(){
        return this.price;
    }

    public void getInfo() {
        System.out.println("Driver Name: " + getDriverName());
        System.out.println(getRideType() + " Ride");
        System.out.println("Driver PhoneNumber: " + getDriverPhoneNumber());
        System.out.println("Driver Age: " + getDriverAge());
        System.out.println("Car Model: " +getCarModel());
        System.out.println("Car Colour: " +getCarColor());
        System.out.println("Car Type: " +getCarType());
        System.out.println("Car PlateNumber: " + getCarPlateNumber());
    }
}