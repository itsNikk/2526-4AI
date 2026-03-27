package ParkingLotv1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int maxCapacity = 5;
        final int maxVehicles = 10;
        List<Auto> vehicles = new ArrayList<>();

        ParkingLot parkingLot = new ParkingLot(maxCapacity);

        for (int i = 0; i < maxVehicles; i++) vehicles.add(new Auto("AUTO-" + (i + 1), parkingLot));

        for (Auto a : vehicles) a.start();
        for (Auto a : vehicles) a.join();

        System.out.println("Parcheggio chiude");


    }
}
