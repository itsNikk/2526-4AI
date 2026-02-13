package IntroSynch;

public class Counter {
    private long counter;

    public void add(long value) {
        //this.counter+=value;
        long tmp = this.counter;
        tmp = tmp + value;
        this.counter = tmp;
    }


}
