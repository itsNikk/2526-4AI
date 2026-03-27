package Exercises.StazioneFerroviaria_V2;

public class Stazione {
    private String nome;
    private final Binario[] binari;

    public Stazione(String nome, int numeroBinari) {
        this.nome = nome;
        binari = new Binario[numeroBinari];
        creaBinari();
    }

    public Stazione(String nome, Binario[] binari) {
        this.nome = nome;
        this.binari = binari;
    }

    public synchronized Binario arrivaTreno() throws InterruptedException {
        while (tuttiIBinariOccupati()) wait();

        Binario binarioAssegnato = trovaBinarioLibero();
        if (binarioAssegnato != null) binarioAssegnato.setOccupato(true);

        return binarioAssegnato;
    }

    public synchronized void parteTreno(Binario binario) {
        binario.setOccupato(false);
        notifyAll();
    }

    private Binario trovaBinarioLibero() {
        //Con questa implementazione si trova il primo binario libero
        for (Binario binario : binari) if (!binario.isOccupato()) return binario;
        return null;
    }

    private boolean tuttiIBinariOccupati() {
        for (Binario binario : binari) if (!binario.isOccupato()) return false;
        return true;
    }

    private void creaBinari() {
        for (int i = 0; i < binari.length; i++) binari[i] = new Binario(i + 1);
    }


    @Override
    public String toString() {
        return "Stazione " + nome;
    }
}
