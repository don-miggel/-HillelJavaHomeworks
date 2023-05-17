
public class Main {
    public static void main(String[] args) {
        ValueCalculator valueCalculator;
        try {
            valueCalculator= new ValueCalculator(1_000_000_5);
            valueCalculator.launch();
        }catch (MinimumArrayValueException e) {
            System.out.println(e);
        }
    }
}
