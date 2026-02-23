package Exceptions.Exercises.sportello13022026;

import java.lang.classfile.instruction.StoreInstruction;
import java.util.ArrayList;

public class Convoglio {
    private ArrayList<NaveMercantile> mercantili;
    private Fregata fregata;

    private double distance;

    public Convoglio(ArrayList<NaveMercantile> navi, Fregata fregata, double distance) {
        this.mercantili = navi;
        this.fregata = fregata;
        this.distance = distance;
    }

    //steps in km
    public void step(int steps) {
        distance -= steps;
    }

    public ArrayList<NaveMercantile> getMercantiliVivi() {
        ArrayList<NaveMercantile> result = new ArrayList<>();

        for (NaveMercantile nave : mercantili) {
            if (nave.isAlive()) result.add(nave);
        }

        return result;
    }

    public void checkConvoy() throws ConvoglioSbandatoException {
        int count = 0;
        for (Nave nave : mercantili) {
            if (!nave.isAlive()) count++;
        }
        if (count > mercantili.size() / 2) throw new ConvoglioSbandatoException("Il convoglio sbanda");
    }

    public boolean isArrived() {
        return distance <= 0;
    }

    public void printConvoyState() {
        System.out.println("Distanza dal porto: " + distance + " | " + "Navi totali: " + mercantili.size());
    }

    public int getTotalLoad() {
        int totalLoad = 0;
        for (NaveMercantile nave : getMercantiliVivi()) {
            totalLoad += nave.getCarico();
        }

        return totalLoad;
    }
}
