package Exceptions.verifica27022026.Alchimist;

import java.util.ArrayList;

public class Alchemist {
    private int energy;
    private ArrayList<Ingredient> container;
    private int containerWeight;
    private boolean stoneUsed;

    public Alchemist(int energy) {
        this.energy = energy;
        this.container = new ArrayList<>();
        this.containerWeight = 0;
        this.stoneUsed = false;
    }

    public void loseEnergy(int amount) {
        energy -= amount;
    }

    public boolean hasNoEnergy() {
        return energy <= 0;
    }

    public boolean tryUsePhilosopherStone(int currentZone) {
        if (stoneUsed) return false;
        for (int i = 0; i < container.size(); i++) {
            Ingredient ing = container.get(i);
            if (ing.getName().equals("pietra filosofale")) {
                container.remove(i);
                containerWeight -= ing.getWeight();
                energy += 2;
                stoneUsed = true;
                System.out.println("Zona " + currentZone + ": energia esaurita! Usata pietra filosofale: recuperate 2 unita'. Energia rimanente: " + energy + ".");
                return true;
            }
        }
        return false;
    }

    public void addIngredient(Ingredient ing, int maxWeight, int currentZone) throws ContainerFullException {
        if (containerWeight + ing.getWeight() > maxWeight) throw new ContainerFullException("Contenitore pieno!");

        container.add(ing);
        containerWeight += ing.getWeight();
        System.out.println("Zona " + currentZone + ": trovato " + ing + ". Peso totale contenitore: " + containerWeight + " kg.");
    }

    public void dropHeaviestAndAdd(Ingredient newIng, int currentZone) {
        Ingredient heaviest = container.get(0);
        int heaviestIndex = 0;
        for (int i = 1; i < container.size(); i++) {
            Ingredient current = container.get(i);
            if (current.getWeight() > heaviest.getWeight()) {
                heaviest = current;
                heaviestIndex = i;
            }
        }
        container.remove(heaviestIndex);
        containerWeight -= heaviest.getWeight();
        container.add(newIng);
        containerWeight += newIng.getWeight();
        System.out.println("Zona " + currentZone + ": contenitore pieno! Rimosso " + heaviest + ". Raccolto " + newIng + ". Peso totale contenitore: " + containerWeight + " kg.");
    }

    public int getEnergy() {
        return energy;
    }
}