package Exceptions.Exercises.sportello13022026;

public class NaveMercantile extends Nave {
    private int carico;

    public NaveMercantile(String name, int scafoIniziale, int carico) {
        super(name, scafoIniziale);
        this.carico = carico;
    }

    @Override
    public void takeDamage(int damage) {
        setScafo(getScafo() - damage);

        if (Math.random() < 0.3) {
            //Danneggiare carico
            int loss = Math.min(carico, damage);
            this.carico -= loss;
            if (getScafo() < 0) {
                //Nave affondata
                throw new NaveAffondataException(getName());
            }
        }
    }

    @Override
    public void shoot(Nave nave) {

    }
}
