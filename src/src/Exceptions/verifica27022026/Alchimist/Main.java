package Exceptions.verifica27022026.Alchimist;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Alchemist alchemist = new Alchemist(10);
        Jungle jungle = new Jungle(alchemist, 15);

        try {
            jungle.explore();
        } catch (OutOfEnergyException e) {
            System.out.println("FINE: " + e.getMessage() + ". L'alchimista e' bloccato.");
        }
    }
}