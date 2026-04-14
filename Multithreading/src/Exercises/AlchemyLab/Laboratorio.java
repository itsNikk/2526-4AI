package Exercises.AlchemyLab;

public class Laboratorio {
    private int fornaci;
    private int tavoli;
    private int cappe;

    public Laboratorio(int fornaci, int tavoli, int cappe) {
        this.fornaci = fornaci;
        this.tavoli = tavoli;
        this.cappe = cappe;
    }

    public synchronized void acquisisci(Alchimista alchimista) throws InterruptedException {
        while (fornaci == 0 || tavoli == 0 || cappe == 0) {
            System.out.println(alchimista.getName() + " in attesa dei suoi strumenti...");
            wait();
        }

        fornaci--;
        tavoli--;
        cappe--;

        System.out.println(alchimista.getName() + " inizia a lavorare. [F: " + fornaci + " T: " + tavoli + " C: " + cappe);

    }

    public synchronized void rilascia(Alchimista alchimista) throws InterruptedException {
        fornaci++;
        tavoli++;
        cappe++;

        System.out.println(alchimista.getName() + " restituisce gli strumenti. [F: " + fornaci + " T: " + tavoli + " C: " + cappe);
        notifyAll();
    }
}
