package Exercises.StazioneFerroviaria_V1;

public class Treno extends Thread {

    private Stazione stazioneDestinazione;
    private int codiceTreno;

    public Treno(int codiceTreno, Stazione stazioneDestinazione) {
        super("Treno " + codiceTreno);
        this.stazioneDestinazione = stazioneDestinazione;
        this.codiceTreno = codiceTreno;
    }


    @Override
    public void run() {
        int waitTime = (int) (Math.random() * 5000) + 2000;
        int tripTime = (int) (Math.random() * 5000) + 2000;
        try {
            System.out.println(getName() + " in viaggio verso " + stazioneDestinazione
                    + ". Tempo di viagigio " + tripTime + " secondi");
            sleep(tripTime);
            int binarioAssegnato = stazioneDestinazione.arrive(codiceTreno);
            System.out.println(getName() + " è arrivato al binario " + binarioAssegnato
                    + ". Tempo di attesa: " + waitTime);
            sleep(waitTime);
            stazioneDestinazione.depart(codiceTreno, binarioAssegnato);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }
}
