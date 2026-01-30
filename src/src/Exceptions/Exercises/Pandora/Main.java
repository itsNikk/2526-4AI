package Exceptions.Exercises.Pandora;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Arma arma = new Arma("arco", 540);

        for (int i = 0; i < 20; i++) {
            try {
                Coordinata c = new Coordinata(50, 50);
                Avatar jake = new Avatar("Jake", arma, 123);
                jake.attaccaPostazione(new PostazioneRDA());
                System.out.println("attacco riuscito");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArmaMalfunzionanteException armaMalfunzionanteException) {
                System.out.println(armaMalfunzionanteException.getMessage());
            } catch (AttaccoFallitoException e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
