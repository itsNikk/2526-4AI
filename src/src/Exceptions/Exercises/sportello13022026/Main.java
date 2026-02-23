package Exceptions.Exercises.sportello13022026;

import javax.management.MBeanRegistration;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<NaveMercantile> mercantili = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            mercantili.add(new NaveMercantile("Mercantile" + (i + 1), 80, 500));
        }

        Fregata fregata = new Fregata("Fregata!", 153, 25, 210);

        Convoglio convoglio = new Convoglio(mercantili, fregata, 42);

        ArrayList<NavePirata> pirati = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            pirati.add(new NavePirata("Pirata" + (i + 1), 80, 500));
        }

        int turno = 0;

        while (!convoglio.isArrived() && !pirati.isEmpty()) {
            turno++;

            System.out.println(" Turno " + turno);
            convoglio.printConvoyState();

            //1. Pirati che attaccano...
            for (NavePirata pirata : pirati) {
                ArrayList<NaveMercantile> targets = convoglio.getMercantiliVivi();
                if (targets.isEmpty()) break;

                NaveMercantile target = targets.get((int) (Math.random() * targets.size()));

                pirata.shoot(target);

            }

            NavePirata p = pirati.get((int) (Math.random() * pirati.size()));
            try {
                fregata.defend(p);
            } catch (MunizioniEsauriteException e) {
                System.out.println(e.getMessage());
            } catch (NaveAffondataException aff) {
                System.out.println(aff.getMessage() + " è stato affondato.");
                pirati.remove(p);
            }

            fregata.ripristinaCannone();

            //f3.
            convoglio.step(1);

            if (convoglio.getTotalLoad() <= 0) {
                System.out.println("HO PERSO");
                return;
            }

        }

    }
}
