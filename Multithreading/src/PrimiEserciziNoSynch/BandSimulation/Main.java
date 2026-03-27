package PrimiEserciziNoSynch.BandSimulation;

public class Main {
    public static void main(String[] args) {
        BandMember guitar = new BandMember("Strum...", 400);
        BandMember drums = new BandMember("Boom...", 600);
        BandMember singer = new BandMember("Yeahhh!", 1000);

        guitar.start();
        drums.start();
        singer.start();

        try {
            Thread.sleep(10000); // 10 secondi di.. concerto!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("IL CONCERTO FINISCE");
        guitar.stopPlaying();
        drums.stopPlaying();
        singer.stopPlaying();
    }
}
