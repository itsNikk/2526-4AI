package Exercises.ElaborationChain.v1;

public class MultiplierProcessor extends BaseChainProcessor {

    private final int factor;

    public MultiplierProcessor(int index, Buffer in, Buffer out, int iterations, int factor) {
        super(index, in, out, iterations);
        this.factor = factor;
    }

    @Override
    int transform(int valueToTransform) {
        return valueToTransform * factor;
    }
}
