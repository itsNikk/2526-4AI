package ParkingLotv2;

import java.util.Random;

// MAIUSC+F6 = rename in all project
public class Veicolo extends Thread {

    private Random random;
    private ParkingLot parkingLot;
    private VehicleType type;

    public Veicolo(String name, ParkingLot parkingLot, VehicleType type) {
        super(name); //setName(name);
        this.random = new Random();
        this.parkingLot = parkingLot;
        this.type = type;
    }

    @Override
    public void run() {
        //guida
        try {
            int driveTime = 2000 + random.nextInt(3000);
            System.out.println(getName() + " sta guidando per " + driveTime / 1000 + " sec");
            sleep(driveTime);
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

    public VehicleType getType() {
        return type;
    }
}
