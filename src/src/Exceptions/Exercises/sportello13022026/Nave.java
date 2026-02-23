package Exceptions.Exercises.sportello13022026;

public abstract class Nave {
    private String name;
    private int scafo;

    public Nave(String name, int scafoIniziale) {
        this.name = name;
        this.scafo = scafoIniziale;
    }

    public abstract void takeDamage(int damage);

    public abstract void shoot(Nave nave);

    public int getScafo() {
        return scafo;
    }

    public void setScafo(int scafo) {
        this.scafo = scafo;
    }

    public String getName() {
        return name;
    }
}
