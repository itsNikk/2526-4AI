package ParkingLotv2;

public class ParkingLot {
    private int postiDisponibili;
    private final int PARKINGLOT_MAX_CAPACITY;

    public ParkingLot(int maxCapacity) {
        this.PARKINGLOT_MAX_CAPACITY = maxCapacity;
        this.postiDisponibili = PARKINGLOT_MAX_CAPACITY;
    }

    public synchronized void enter(Veicolo auto) throws InterruptedException {
        while (postiDisponibili < auto.getType().getGrandezzaVeicolo()) {
            System.out.println("L'auto " + auto.getName() + " in attesa. posti disponibili: " + postiDisponibili);
            wait();
        }

        postiDisponibili -= auto.getType().getGrandezzaVeicolo();
        System.out.println("L'auto " + auto.getName() + " prende posto. posti disponibili " + postiDisponibili);

    }

    public synchronized void exit(Veicolo veicolo) {

        postiDisponibili += veicolo.getType().getGrandezzaVeicolo();
        System.out.println("L'auto " + veicolo.getName() + "esce. posti disponibili: " + postiDisponibili);
        notifyAll();
    }

}
