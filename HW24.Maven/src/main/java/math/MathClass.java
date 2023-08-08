package math;

public class MathClass {

    public double sqrt(double num){
        if(num <0) throw new ArithmeticException();
        return Math.sqrt(num);
    }

    public double abs(double num){
        if(num < 0)
            return num *(-1);
        return num;
    }

    public int fact(int val){
        if(val <0) throw new ArithmeticException();
        if(val == 0) return  1;
       int res = 1;
        for (int i = 2; i <= val; i++) {
            res = res * i;
        }
        return res;
    }

    public double pow(double val, int degree){
        if(degree == 0) return 1;
        int degreeChecked = (int) abs(degree);

        double res=1;
        for(int i = 1; i <= degreeChecked; i++)
            res *= val;
        return degree >= 0 ? res : 1 / res;
    }

}
