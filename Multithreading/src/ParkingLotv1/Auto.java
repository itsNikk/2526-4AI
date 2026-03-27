package ParkingLotv1;

import java.util.Random;

public class Auto extends Thread {

    private Random random;
    private ParkingLot parkingLot;

    public Auto(String name, ParkingLot parkingLot) {
        super(name); //setName(name);
        this.random = new Random();
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        //guida
        try {
            sleep(2000 + random.nextInt(3000));
            //cerca di entrare..
            parkingLot.enter(this);
            // se entra parcheggia
            sleep(3000 + random.nextInt(5000));
            //esce
            parkingLot.exit(this);

        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
