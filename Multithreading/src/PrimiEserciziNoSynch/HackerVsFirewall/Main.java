package PrimiEserciziNoSynch.HackerVsFirewall;

public class Main {
    public static void main(String[] args) {
        Hacker hacker = new Hacker("Kevin Mitnick");
        Firewall firewall = new Firewall("Firewall L1", hacker);

        hacker.start();
        firewall.start();
    }
}
