package Exercises.Launchpad6;

public class LaunchCenter {
    private int rampeDisponibili;
    private int torriDisponibili;

    public LaunchCenter(int rampeDisponibili, int torriDisponibili) {
        this.rampeDisponibili = rampeDisponibili;
        this.torriDisponibili = torriDisponibili;
    }

    //Acquisisco atomicamente le risorse: o tutte o nessuna :)
    public synchronized void acquisiciRisorse(MissionEntity mission) throws InterruptedException {
        while (torriDisponibili == 0 || rampeDisponibili == 0) {
            System.out.println(mission + " in attesa. [Rampe: " + rampeDisponibili + " - Torri: " + torriDisponibili + "]");
            wait();
        }

        rampeDisponibili--;
        torriDisponibili--;
        System.out.println(mission + " pronta al lancio. [Rampe: " + rampeDisponibili + " torri: " + torriDisponibili + "]");
    }

    public synchronized void rilasciaRisorse(MissionEntity mission) throws InterruptedException {
        rampeDisponibili++;
        torriDisponibili++;
        System.out.println(mission + " terminata. Rilascio risorse. [Rampe: " + rampeDisponibili + " torri: " + torriDisponibili + "]");

        notifyAll();
    }
}
