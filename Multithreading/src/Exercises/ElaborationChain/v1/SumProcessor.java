package Exercises.ElaborationChain.v1;

public class SumProcessor extends BaseChainProcessor {

    private final int addend;

    public SumProcessor(int index, Buffer in, Buffer out, int iterations, int addend) {
        super(index, in, out, iterations);
        this.addend = addend;
    }

    @Override
    int transform(int valueToTransform) {
        return valueToTransform + addend;
    }
}
