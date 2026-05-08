package Exercises.ReentrantLockAndConditions.Airport;

//CTRL+ALT+T
public class Volo extends Thread {
    private TipoVolo type;
    private Terminal terminal;

    public Volo(String nome, TipoVolo type, Terminal terminal) {
        super(nome);
        this.type = type;
        this.terminal = terminal;
    }

    @Override
    public void run() {

        try {
            sleep(1000);
            if (type == TipoVolo.INTERNAZIONALE) {
                terminal.occupaGateInternazionale(this);
            } else {
                terminal.occupaGatenNazionale(this);
            }
            sleep(3500);
            if (type == TipoVolo.INTERNAZIONALE) {
                terminal.rilasciaGateInternazionale(this);
            } else {
                terminal.rilasciaGateNazionale(this);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
