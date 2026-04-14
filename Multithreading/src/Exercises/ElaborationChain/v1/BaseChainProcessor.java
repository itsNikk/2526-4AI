package Exercises.ElaborationChain.v1;

public abstract class BaseChainProcessor extends Thread {
    /*
     * Sfrutto l'ereditarietà per gestire i metodi di elaborazione della pipeline.
     * Ogni sottoclasse definirà la sua personale trasformazione numerica.
     */

    private final int index;
    //Da chi prendo dati
    private final Buffer inBuffer;
    //A chi invierò dati
    private final Buffer outBuffer;
    private final int iterations;

    public BaseChainProcessor(int index, Buffer in, Buffer out, int iterations) {
        super("Elaboratore-" + index);
        this.index = index;
        this.inBuffer = in;
        this.outBuffer = out;
        this.iterations = iterations;
    }

    //Questo metodo verrà implementato nelle sottoclassi concrete con la trasformazione richiesta
    abstract int transform(int valueToTransform);

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                int inValue = inBuffer.retrieveValue();
                int outValue = transform(inValue);
                System.out.println("[" + getName() + "] " + inValue + " -> " + outValue);
                outBuffer.insertValue(outValue);
            }
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }
}
