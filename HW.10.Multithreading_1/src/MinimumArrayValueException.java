public class MinimumArrayValueException extends Exception {

    public MinimumArrayValueException(int chosenSize, int leastPossibleSize){
        super("Array should have at least "+ leastPossibleSize+" elements, but your size is: "+ chosenSize);
    }
}
