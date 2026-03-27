package Exercises.StazioneFerroviaria_V2;

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
                    + ". Tempo di viagigio " + (float) tripTime / 1000 + " secondi");
            sleep(tripTime);
            Binario binarioAssegnato = stazioneDestinazione.arrivaTreno();
            System.out.println(getName() + " è arrivato al binario " + binarioAssegnato.getNumeroBinario()
                    + ". Tempo di attesa: " + (float) waitTime / 1000);
            sleep(waitTime);
            System.out.println(getName() + " è partito dal binario " + binarioAssegnato.getNumeroBinario());
            stazioneDestinazione.parteTreno(binarioAssegnato);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }
}
