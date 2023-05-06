import java.util.Arrays;

public class ArrayValueCalculator {

    public static int dimension;

    public void setDimension(int dim) {
        dimension = dim;
    }

    public int doCalc(String[][] str) throws ArraySizeException, ArrayDataException {

        validateArray(str, dimension);
        return castStringValueToInt(str);
    }

    private int castStringValueToInt(String[][] strValues) throws ArrayDataException {
        int total = 0;
        for (int i = 0; i < strValues.length; i++)
            for (int j = 0; j < strValues.length; j++) {
                try {
                    total += Integer.parseInt(strValues[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(strValues[i][j], i, j);
                }
            }
        return total;
    }

    private void validateArray(String[][] str, int dimension) throws ArraySizeException {
        if (str.length != dimension) throw new ArraySizeException(dimension, str.length);

        for (String[] strings : str) {
            if (strings.length != str.length)
                throw new ArraySizeException(str.length, strings.length, dimension);
        }
    }

    public void run(String[][] values) {
        System.out.println("Given array is: " + Arrays.deepToString(values));
        try {
            System.out.println("Total sum is: " + doCalc(values));
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        ArrayValueCalculator avCalc = new ArrayValueCalculator();
        avCalc.setDimension(4);
        String[][] str = {{"12", "13", "17", "1"}, {"5", "36", "77", "9"},
                {"83", "19", "71", "0"}};
        avCalc.run(str);

        String[][] str1 = {{"1", "17", "25", "10"}, {"12", "13", "17", "3"}, {"l", "36", "77", "1"},
                {"83", "19", "71", "0"}};
        avCalc.run(str1);
        String[][] str2 = {{"1", "17", "25", "10"}, {"12", "13", "17", "3"}, {"5", "36", "77", "1"},
                {"83", "19", "71", "0"}};
        avCalc.run(str2);
    }
}
