package Exercises.ElaborationChain.v2;

public class ChainProcessor extends Thread {
    private final int index;
    private final Buffer inBuffer;
    private final Buffer outBuffer;
    private final int iterations;
    private final TransformType transformType;
    private final int parameter;

    //MMMMEH...
    public ChainProcessor(int index, Buffer inBuffer, Buffer outBuffer, int iterations, TransformType transformType, int parameter) {
        super("Elavoratore-" + index);
        this.index = index;
        this.inBuffer = inBuffer;
        this.outBuffer = outBuffer;
        this.iterations = iterations;
        this.transformType = transformType;
        this.parameter = parameter;
    }

    private int transform(int valueToTransform) {
        switch (transformType) {
            case SUM:
                return valueToTransform + parameter;
            case MULTIPLY:
                return valueToTransform * parameter;
            case ABS_DIFF:
                return Math.abs(valueToTransform - parameter);
            default:
                return valueToTransform;
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                int inValue = inBuffer.retrieveValue();
                int outValue = transform(inValue);
                System.out.println("[" + getName() + "] " + inValue + " -> " + outValue);
                outBuffer.insertValue(outValue);
            }
        } catch (InterruptedException exception) {
            currentThread().interrupt();
        }
    }
}
