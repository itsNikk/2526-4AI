package Exercises.Bouncer;

public class Utente extends Thread {

    private int eta;
    private final Buttafuori buttafuori;

    public Utente(String name, int eta, Buttafuori buttafuori) {
        super(name);
        this.eta = eta;
        this.buttafuori = buttafuori;
    }

    @Override
    public void run() {
        try {
            buttafuori.addPerson(eta);
            sleep((int) (Math.random() * 5000) + 2000);
            buttafuori.removePerson();
        } catch (InterruptedException e) {
            System.out.println(getName() + " è stato respinto per limiti d'età.");
        }
    }

    @Override
    public String toString() {
        return getName() + " Età: " + eta;
    }
}
