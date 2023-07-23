package strategy;

public class Context {

    private SquareCalc squareCalc;

    public Context(SquareCalc squareCalc){
        setStrategy(squareCalc);
    }

    public void setStrategy(SquareCalc squareCalc){
        if(squareCalc != null)
            this.squareCalc = squareCalc;
    }

    public double calculateSquare(){

            return squareCalc.calculateSquare();
    }
}
