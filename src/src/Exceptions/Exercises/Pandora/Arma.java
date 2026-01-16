package Exceptions.Exercises.Pandora;

public class Arma {
    private String nome;
    private double baseDamage;

    public Arma(String nome, double baseDamage) {
        this.nome = nome;
        this.baseDamage = baseDamage;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }
}
