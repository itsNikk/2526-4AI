package UMLExercises.CDs.Impl.Cucina;

public abstract class Piatto {
    private String name;

    //costruttore?
    public Piatto(String name) {
        this.name = name;
    }

    public abstract void prepara();
}
