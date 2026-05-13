package sportello13052026;

import java.util.Random;

public class Fornitore extends Thread {

    private Magazzino magazzino;
    private String[] names;
    private double[] weights;
    private Random rnd;

    public Fornitore(Magazzino magazzino, String[] names, double[] weights) {
        this.magazzino = magazzino;
        //TODO: check lunghezza array
        this.names = names;
        this.weights = weights;
        this.rnd = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < names.length; i++) {
            //CTRL+ALT+T
            try {
                Materiale m = new Materiale(names[i], weights[i]);
                magazzino.deposita(m);
                sleep(rnd.nextInt(50, 101));
            } catch (MaterialeNonValidoException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException interruptedException) {
                System.out.println(getName() + " interrotto ");
            }
        }
    }
}
