package Exercises.ElaborationChain.v1;

public class ChainMainv1 {
    public static void main(String[] args) {
        final int K = 10;

        Buffer b1 = new Buffer();
        Buffer b2 = new Buffer();
        Buffer b3 = new Buffer();
        Buffer b4 = new Buffer();

        Generator gen = new Generator(b1, K);

        BaseChainProcessor p1 = new SumProcessor(1, b1, b2, K, 10);
        BaseChainProcessor p2 = new MultiplierProcessor(2, b2, b3, K, 2);
        BaseChainProcessor p3 = new AbsDiffProcessor(3, b3, b4, K, 50);

        Collector collector = new Collector(b4, K);

        gen.start();

        p1.start();
        p2.start();
        p3.start();

        collector.start();

    }
}
