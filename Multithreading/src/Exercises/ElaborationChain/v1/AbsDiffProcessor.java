package Exercises.ElaborationChain.v1;

public class AbsDiffProcessor extends BaseChainProcessor {

    private final int ref;

    public AbsDiffProcessor(int index, Buffer in, Buffer out, int iterations, int ref) {
        super(index, in, out, iterations);
        this.ref = ref;
    }

    @Override
    int transform(int valueToTransform) {
        return Math.abs(valueToTransform - ref);
    }
}
