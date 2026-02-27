package Exceptions.verifica27022026.TombRaider;

public class Explorer {
    private String name;
    private int torches;

    public Explorer(String name, int torches) {
        this.name = name;
        this.torches = torches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTorches() {
        return torches;
    }

    public void setTorches(int torches) {
        this.torches = torches;
    }

    public boolean hasNoTorches() {
        return torches <= 0;
    }
}
