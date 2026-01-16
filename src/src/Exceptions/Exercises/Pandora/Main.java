package Exceptions.Exercises.Pandora;

public class Main {
    public static void main(String[] args) {

        Arma arma = new Arma("arco", 540);

        try {
            Coordinata c = new Coordinata(564564645, 156561);
            Avatar jake = new Avatar("Jake", arma, 123);
            jake.attaccaPostazione(new PostazioneRDA());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArmaMalfunzionanteException armaMalfunzionanteException){
            return;
        }
    }
}
