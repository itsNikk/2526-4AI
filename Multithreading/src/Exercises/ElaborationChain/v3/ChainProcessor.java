package Exercises.ElaborationChain.v3;

import Exercises.ElaborationChain.v2.Buffer;

public class ChainProcessor extends Thread {
    private final int index;
    private Buffer inBuffer;
    private Buffer outBuffer;
    private final int iterations;
    private final Transformable transform;

    public ChainProcessor(int index, Buffer inBuffer, Buffer outBuffer, int iterations, Transformable transform) {
        this.index = index;
        this.inBuffer = inBuffer;
        this.outBuffer = outBuffer;
        this.iterations = iterations;
        this.transform = transform;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                int inValue = inBuffer.retrieveValue();
                int outValue = transform.apply(inValue);
                System.out.println("[" + getName() + "] " + inValue + " -> " + outValue);
                outBuffer.insertValue(outValue);
            }
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }
}
