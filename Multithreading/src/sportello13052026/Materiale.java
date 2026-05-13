package sportello13052026;

public class Materiale {
    private String name;
    private double weight;

    public Materiale(String name, double weight) throws MaterialeNonValidoException {
        checkParams(name, weight);
        this.name = name;
        this.weight = weight;
    }

    private void checkParams(String name, double weight) throws MaterialeNonValidoException {
        if (name == null || name.isEmpty())
            throw new MaterialeNonValidoException("Il materiale non ha il nome");

    }

    @Override
    public String toString() {
        return name + ":" + weight + " kg";
    }
}
