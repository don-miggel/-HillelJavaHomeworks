package math;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MathClassTest {

    private MathClass mathClass; 
    
    @BeforeEach
    void setUp(){
        mathClass = new MathClass();
    }
    
    @Nested
    class SqrtTesting{
        
        @Test
        void testAboveZeroNum(){
            
            double expected = 3.0;
            double actual = mathClass.sqrt(9);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testZeroNum(){

            double expected = 0.0;
            double actual = mathClass.sqrt(0);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testBelowZero(){
            Assertions.assertThrows(ArithmeticException.class,
                    ()->mathClass.sqrt(-1)

                    );
        }

        @Test
        void testWithFloatingPoint(){
            double expected = 9.2;
            double actual = mathClass.sqrt(84.64);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class TestAbs{

        @Test
        void testAboveZeroInt(){

            double expected = 7.0;
            double actual = mathClass.abs(-7);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testZero(){

            double expected = 0.0;
            double actual = mathClass.abs(0);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testBelowZeroDecimal(){

            double expected = 7.35;
            double actual = mathClass.abs(-7.35);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class  TestFactMethod{

        @Test
        void testZeroAndOne(){
            int expected = 1;
            int actual = mathClass.fact(0);
            Assertions.assertEquals(expected, actual);
            actual = mathClass.fact(1);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testBelowZero(){

            Assertions.assertThrows(ArithmeticException.class ,
                            ()->mathClass.fact(-5)
                        );
        }

        @Test
        void testFiveValue(){
            int expected = 120;
            int actual = mathClass.fact(5);
            Assertions.assertEquals(expected, actual);

        }
    }

    @Nested
    class TestPowMethod{

        @Test
        void testZeroPowZero(){
            double expected = 1.0;
            double actual = mathClass.pow(0,0);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testZeroPowOne(){
            double expected = 0.0;
            double actual = mathClass.pow(0,1);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testOnePowZero(){
            double expected = 1.0;
            double actual = mathClass.pow(1,0);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testOnePowMinusFourAndMinusThree(){
            double expected = 1.0;
            double actual = mathClass.pow(1,-4);
            Assertions.assertEquals(expected, actual);
            actual = mathClass.pow(1,-3);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testFivePowZero(){
            double expected = 1.0;
            double actual = mathClass.pow(5,0);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testTwoPowMinusThree(){
            double expected = 0.125;
            double actual = mathClass.pow(2,-3);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testFivePowThree(){
            double expected = 125.0;
            double actual = mathClass.pow(5,3);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testMinusFivePowThree(){
            double expected = -125.0;
            double actual = mathClass.pow(-5,3);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testMinusFivePowMinusThree(){
            double expected = -0.008;
            double actual = mathClass.pow(-5,-3);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testDecimalNum(){
            double expected = 15.625;
            double actual = mathClass.pow(2.5,3);

            Assertions.assertEquals(expected, actual);
        }




    }


}
