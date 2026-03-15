package Exceptions.verifica27022026.Alchimist;

public class Ingredient {
    private String name;
    private int weight;

    public Ingredient(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " kg)";
    }
}