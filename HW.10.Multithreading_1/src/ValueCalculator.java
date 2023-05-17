import java.util.Arrays;

public class ValueCalculator {

    private static final int MIN_ARRAY_SIZE = 1_000_000;

    private float[] numbers;
    private int arrSize;
    private int halfSize;

    public ValueCalculator(int arrSize) throws MinimumArrayValueException {
        if (arrSize < MIN_ARRAY_SIZE) throw new MinimumArrayValueException(arrSize, MIN_ARRAY_SIZE);
        if (arrSize % 2 != 0)
            this.arrSize = arrSize + 1;
        else
            this.arrSize = arrSize;
        halfSize = this.arrSize / 2;
        numbers = new float[this.arrSize];


    }

    public void launch() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrSize; i++) {
            numbers[i] = 1.0f;
        }

        float[] halfArr1 = new float[halfSize];
        float[] halfArr2 = new float[halfSize];

        System.arraycopy(numbers, 0, halfArr1, 0, halfSize);
        System.arraycopy(numbers, halfSize, halfArr2, 0, halfSize);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {

                halfArr1[i] = (float) (numbers[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = halfSize; i < arrSize; i++) {
                halfArr2[i - halfSize] = (float) (numbers[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        combineArrays(halfArr1, halfArr2);
//        System.out.println(Arrays.toString(numbers));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start) + " milliseconds");

    }

    private void combineArrays(float[] arr1, float[] arr2) {
        int combinedLength = arr1.length + arr2.length;
        float[] combinedArray = new float[combinedLength];
        for (int i = 0; i < arr1.length; i++)
            combinedArray[i] = arr1[i];
        for (int i = arr2.length; i < combinedLength; i++) {
            combinedArray[i] = arr2[i - arr2.length];
        }
        numbers = combinedArray;
    }
}
