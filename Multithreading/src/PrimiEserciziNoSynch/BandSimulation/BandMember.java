package PrimiEserciziNoSynch.BandSimulation;

public class BandMember extends Thread {

    private String suono;
    private int delay;
    private boolean isPlaying;

    public BandMember(String suono, int delay) {
        this.suono = suono;
        this.delay = delay;
    }

    @Override
    public void run() {
        //Si poteva fare anche altrove...
        isPlaying = true;
        while (isPlaying) {
            System.out.println(suono);
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void stopPlaying() {
        isPlaying = false;
    }
}
