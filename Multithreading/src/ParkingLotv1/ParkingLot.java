package ParkingLotv1;

public class ParkingLot {
    private int postiDisponibili;
    private final int PARKINGLOT_MAX_CAPACITY;

    public ParkingLot(int maxCapacity) {
        this.PARKINGLOT_MAX_CAPACITY = maxCapacity;
        this.postiDisponibili = PARKINGLOT_MAX_CAPACITY;
    }

    public synchronized void enter(Auto auto) throws InterruptedException {
        while (postiDisponibili == 0) {
            System.out.println("L'auto " + auto.getName() + " in attesa. posti disponibili: " + postiDisponibili);
            wait();
        }

        postiDisponibili--;
        System.out.println("L'auto " + auto.getName() + " prende posto. posti disponibili " + postiDisponibili);

    }

    public synchronized void exit(Auto auto) {

        postiDisponibili++;
        System.out.println("L'auto " + auto.getName() + "esce. posti disponibili: " + postiDisponibili);
        notifyAll();
    }

}
