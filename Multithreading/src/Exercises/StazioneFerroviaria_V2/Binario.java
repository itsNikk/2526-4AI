package Exercises.StazioneFerroviaria_V2;

public class Binario {
    private int numeroBinario;
    private boolean occupato;

    public Binario(int numeroBinario) {
        this.numeroBinario = numeroBinario;
        this.occupato = false;
    }

    public int getNumeroBinario() {
        return numeroBinario;
    }

    public void setNumeroBinario(int numeroBinario) {
        this.numeroBinario = numeroBinario;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
}
