package Exceptions.Exercises.sportello13022026;

public class NavePirata extends Nave {

    private int cannonPower;

    public NavePirata(String name, int scafo, int cannonPower) {
        super(name, scafo);
        this.cannonPower = cannonPower;
    }

    @Override
    public void takeDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException("Il danno deve essere positivo (" + damage + ")");
        setScafo(getScafo() - damage);
        if (getScafo() < 0) {
            //Nave affondata
            throw new NaveAffondataException(getName());
        }
    }

    @Override
    public void shoot(Nave nave) {
        nave.takeDamage(cannonPower);
    }
}
