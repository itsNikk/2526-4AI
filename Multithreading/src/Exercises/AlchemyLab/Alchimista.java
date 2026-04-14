package Exercises.AlchemyLab;

public class Alchimista extends Thread {

    private final Laboratorio laboratorio;

    public Alchimista(String name, Laboratorio laboratorio) {
        super(name);
        this.laboratorio = laboratorio;
    }

    @Override
    public void run() {
        try {
            //1) studia
            System.out.println(getName() + " studia le formule delle pozioni...");
            sleep(getRandomNumberInRange(1000, 2000));

            //2) richiede strumenti
            laboratorio.acquisisci(this);
            System.out.println(getName() + " prepara la sua pozione..");

            //3) se li ottiene, lavora e poi rilascia
            sleep(getRandomNumberInRange(3000, 3000));
            laboratorio.rilascia(this);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrompe il lavoro.");
            interrupt();
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        return min + (int) (Math.random() * max);
    }
}
