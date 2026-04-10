package Exercises.ParkingLotv2;

public enum VehicleType {
    AUTO(1), CAMION(2), AUTOBUS(3);

    private final int grandezzaVeicolo;

    VehicleType(int grandezzaVeicolo) {
        this.grandezzaVeicolo = grandezzaVeicolo;
    }

    public int getGrandezzaVeicolo() {
        return grandezzaVeicolo;
    }
}
