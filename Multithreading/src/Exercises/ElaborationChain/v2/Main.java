package Exercises.ElaborationChain.v2;

public class Main {
    public static void main(String[] args) {
        final int K = 10;

        Buffer b1 = new Buffer();
        Buffer b2 = new Buffer();
        Buffer b3 = new Buffer();
        Buffer b4 = new Buffer();

        Generator generator = new Generator(b1, K);

        ChainProcessor cp1 = new ChainProcessor(1, b1, b2, K, TransformType.SUM, 10);
        ChainProcessor cp2 = new ChainProcessor(2, b2, b3, K, TransformType.MULTIPLY, 2);
        ChainProcessor cp3 = new ChainProcessor(3, b3, b4, K, TransformType.ABS_DIFF, 50);

        Collector collector = new Collector(b4, K);

        generator.start();
        cp1.start();
        cp2.start();
        cp3.start();
        collector.start();
    }
}
