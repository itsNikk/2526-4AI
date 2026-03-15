package Exceptions.verifica27022026.Alchimist;

import java.util.Random;

public class Jungle {
    private Alchemist alchemist;
    private Random random;
    private int totalZones;

    private static final String[] INGREDIENT_NAMES = {
            "radice di mandragora", "fiore di loto nero", "resina di drago", "muschio lunare", "pietra filosofale"
    };
    private static final int MAX_CONTAINER_WEIGHT = 10;

    public Jungle(Alchemist alchemist, int totalZones) {
        this.alchemist = alchemist;
        this.random = new Random();
        this.totalZones = totalZones;
    }

    public void explore() throws InterruptedException {
        for (int i = 0; i < totalZones; i++) {

            if (alchemist.hasNoEnergy()) {
                if (!alchemist.tryUsePhilosopherStone(i + 1)) {
                    throw new OutOfEnergyException("Energia esaurita alla zona " + (i + 1));
                }
            }

            alchemist.loseEnergy(1);

            if (random.nextDouble() < 0.40) {
                int lost = 1 + random.nextInt(3);
                try {
                    throw new JungleHazardException("Pericolo! Perse " + lost + " unita' di energia.");
                } catch (JungleHazardException e) {
                    alchemist.loseEnergy(lost);
                    System.out.println("Zona " + (i + 1) + ": PERICOLO! Perse " + lost + " unita' di energia. Energia rimanente: " + alchemist.getEnergy() + ".");
                }
            } else {
                System.out.println("Zona " + (i + 1) + ": avanzato. Energia rimanente: " + alchemist.getEnergy() + ".");
            }

            if (random.nextDouble() < 0.40 + random.nextDouble() * 0.20) {
                String name = INGREDIENT_NAMES[random.nextInt(INGREDIENT_NAMES.length)];
                int weight = 1 + random.nextInt(5);
                Ingredient ing = new Ingredient(name, weight);
                try {
                    alchemist.addIngredient(ing, MAX_CONTAINER_WEIGHT, i + 1);
                } catch (ContainerFullException e) {
                    alchemist.dropHeaviestAndAdd(ing, i + 1);
                }
            }

            if (alchemist.hasNoEnergy()) {
                if (!alchemist.tryUsePhilosopherStone(i + 1)) {
                    throw new OutOfEnergyException("Energia esaurita alla zona " + (i + 1));
                }
            }

            Thread.sleep(1000);
        }
        System.out.println("Fine gioco.");
    }
}