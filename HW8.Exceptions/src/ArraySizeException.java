
public class ArraySizeException extends Exception {

    public ArraySizeException(int properLength, int invalidLength) {
        super("Your array has invalid length: " + invalidLength + ". Proper length should be: " + properLength);
    }

    public ArraySizeException(int x, int y, int properSize) {
        super("Your array has invalid dimension: " + x + "x" + y + ". Proper size is: " + properSize + "x"
                + properSize);
    }
}
