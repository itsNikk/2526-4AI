package Exceptions.Exercises.sportello13022026;

public class Fregata extends Nave {

    private int cannoniOperativi;
    private int munizioni;

    public Fregata(String name, int scafoIniziale, int cannoniOperativi, int munizioni) {
        super(name, scafoIniziale);
        this.cannoniOperativi = cannoniOperativi;
        this.munizioni = munizioni;
    }

    public void ripristinaCannone() {
        if (Math.random() < 0.20) {
            cannoniOperativi++;
            System.out.println(getName() + "Cannone ripristinato: Cannoni operativi: " + cannoniOperativi);
        }
    }

    @Override
    public void takeDamage(int damage) {
        //COME PRIMA
    }

    public void defend(Nave target) throws MunizioniEsauriteException {
        if (munizioni < 0) throw new MunizioniEsauriteException(getName() + " munizioni esaurite");
        // sparo anche senza cannoni? ODD...
        munizioni--;
        target.takeDamage(cannoniOperativi * 5);
    }

    @Override
    public void shoot(Nave nave) {
        if (munizioni < 0) return;

        munizioni--;
        nave.takeDamage(cannoniOperativi * 5);
    }
}
