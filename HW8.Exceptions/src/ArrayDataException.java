

public class ArrayDataException extends Exception {
    public ArrayDataException(String wrongArg, int i, int j) {
        super("Value: " + "'" + wrongArg + "'" + " at row: " + i + ",column: " + j + " cannot be cast to Integer! ");
    }
}
