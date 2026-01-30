package Exceptions.Exercises.Pandora;

import java.util.Random;

public class Avatar {
    private String nome;
    private Arma arma;
    private double forzaAttacco;

    private Random r;

    public Avatar(String nome, Arma arma, double forzaAttacco) {
        this.nome = nome;
        this.arma = arma;
        this.forzaAttacco = forzaAttacco;
        this.r = new Random();
    }

    public void attaccaPostazione(PostazioneRDA postazioneRDA) throws AttaccoFallitoException, ArmaMalfunzionanteException {
        double attackProb = r.nextDouble();

        if (attackProb <= 0.5) {
            double weaponMalfunction = r.nextDouble();
            if (weaponMalfunction <= 0.3)
                throw new ArmaMalfunzionanteException("L'arma " + arma + " di " + nome + " non funziona.");
            else postazioneRDA.riceviDanno(forzaAttacco);
        } else throw new AttaccoFallitoException(this.nome + " non attacca");
    }
}
