import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // 2 task
        printThreeWords();
        // 3 task
        checkSumSign();
        // 4 task
        printColor();
        //5 task
        compareNumbers();
        // 6 task
        System.out.println("is 15 between 10 and 20: "+isNumberInRange(10,5));
        // 7 task
        defineNumberSign(-5);
        // 8 task
        System.out.println(isNegative(-3));
        // 9 task
        printNTimes("Java", 5);
        // 10 * task
        System.out.println("is 2020 leap: "+isYearLeapYear(2020)); // true
        System.out.println("is 1900 leap: "+isYearLeapYear(1900)); // false
        System.out.println("is 1800 leap: "+isYearLeapYear(1800)); // false
        System.out.println("is 2018 leap: "+isYearLeapYear(2018)); // false
        System.out.println("is 2016 leap: "+isYearLeapYear(2016)); // true
        System.out.println("is 2011 leap: "+isYearLeapYear(2011)); // false
        System.out.println("is 2004 leap: "+isYearLeapYear(2004)); // true
    }

    public static void printThreeWords(){
        String fruits = "Orange\nBanana\nApple";
        System.out.println(fruits);
    }

    public static void checkSumSign(){
        int a = 3;
        int b = -5;
        String res = getSumValue(a ,b);
        System.out.println("a = "+a+" b = "+b+". "+res);
        a = 3;
        b = -1;
        res = getSumValue(a, b);
        System.out.println("a = "+a+" b = "+b+". "+res);
     }

     private static String getSumValue(int a, int b){
        return a+b >= 0 ? "Sum is positive" : "Sum is negative";
     }

     public static void printColor(){
        int a = 32;
        if (a <= 0)
            System.out.println("Red");
        else if (a > 0 && a <=100)
            System.out.println("Yellow");
        else
            System.out.println("Green");
     }

     public static void compareNumbers(){
        int a = 15;
        int b = -12;
        String res = a >= b ? "a >= b" : "a < b";
        System.out.println(res);
     }

     public static boolean isNumberInRange(int a, int b){

        int sum = a + b;
        return sum >= 10 && sum <= 20;
     }

     public static void defineNumberSign(int a){
         System.out.println( a >= 0 ? "Positive" : "Negative");
     }

     public static boolean isNegative(int a){
        return a < 0;
     }

     public static void printNTimes(String str, int amount){
        for (int i = 0; i < amount; i++)
            System.out.println(str);
      }

      public static boolean isYearLeapYear(int year){

        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
      }

}
