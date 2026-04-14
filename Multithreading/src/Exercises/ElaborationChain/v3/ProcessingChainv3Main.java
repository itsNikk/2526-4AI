package Exercises.ElaborationChain.v3;

import Exercises.ElaborationChain.v2.Buffer;
import Exercises.ElaborationChain.v2.Collector;
import Exercises.ElaborationChain.v2.Generator;

public class ProcessingChainv3Main {
    public static void main(String[] args) {
        final int K = 10;
        
        Buffer b1 = new Buffer();
        Buffer b2 = new Buffer();
        Buffer b3 = new Buffer();
        Buffer b4 = new Buffer();

        Generator gen = new Generator(b1, K);

        ChainProcessor c1 = new ChainProcessor(1, b1, b2, K, new Transformable() {
            @Override
            public int apply(int value) {
                return value + 10;
            }
        });
        ChainProcessor c2 = new ChainProcessor(1, b2, b3, K, value -> value * 2);
        ChainProcessor c3 = new ChainProcessor(1, b3, b4, K, value -> Math.abs(value - 50));

        Collector c = new Collector(b4, K);

        gen.start();
        c1.start();
        c2.start();
        c3.start();
        c.start();
    }
}
