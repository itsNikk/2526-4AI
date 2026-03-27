package ParkingLotv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        /*
         * 1) il parcheggio chuide dopo X secondi.
         * 2) NOn tutti i veicoli sono uguali. Auto prende un posto solo. un camion ne prende 2
         * 3) Ogni auto vuole un posto specifico
         */
        final int maxCapacity = 5;
        final int maxVehicles = 10;
        final Random rnd = new Random();
        VehicleType[] types = VehicleType.values();
        List<Veicolo> vehicles = new ArrayList<>();

        ParkingLot parkingLot = new ParkingLot(maxCapacity);

        for (int i = 0; i < maxVehicles; i++) {
            VehicleType type = types[rnd.nextInt(types.length)];
            vehicles.add(new Veicolo(type + "-" + (i + 1), parkingLot, type));
        }

        for (Veicolo a : vehicles) a.start();
        for (Veicolo a : vehicles) a.join();

        System.out.println("Parcheggio chiude");


    }
}
