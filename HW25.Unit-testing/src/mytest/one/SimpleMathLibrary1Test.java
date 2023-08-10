package mytest.one;

import mytest.SimpleMathLibrary;
import org.junit.jupiter.api.*;


public class SimpleMathLibrary1Test {

    private SimpleMathLibrary simpleMathLib;

    @BeforeEach
    void setUp2(){
        simpleMathLib = new SimpleMathLibrary();
    }

    @Nested
    public class AddTest{

        @BeforeAll
        static void infoBefore1(){
            System.out.println("Starting testing add function...");
        }

        @Test
        public void addPositives1(){
            double expected = 2.0;
            double actual = simpleMathLib.add(1,1);
            Assertions.assertEquals(expected,actual);

        }

        @Test
        public void addNegatives1(){
            double expected = -5.0;
            double actual = simpleMathLib.add(-3,-2);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void addNegatives1Failed(){
            double expected = -5.0;
            double actual = simpleMathLib.add(-3,-2);
            Assertions.assertNotEquals(expected,actual);
        }

        @Test
        public void addWithZero1(){
            double expected = -1.0;
            double actual = simpleMathLib.add(-1,0);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void addBothZeros1(){
            double expected = 0.0;
            double actual = simpleMathLib.add(0,0);
            Assertions.assertEquals(expected,actual);
        }

        @AfterAll
        static void infoAfter1(){
            System.out.println("Finishing testing add function...");
        }

    }

    @Nested
    class MinusTest{

        @BeforeAll
        static void infoBefore1(){
            System.out.println("Starting testing minus function...");
        }

        @Test
        public void minusAllPositives1(){
            double expected = -1.0;
            double actual = simpleMathLib.minus(-5,-4);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void minusOnePositive1(){
            double expected = -9.0;
            double actual = simpleMathLib.minus(-5,4);
            Assertions.assertEquals(expected,actual);

        }

        @Test
        public void minusZero1(){
            double expected = -7.0;
            double actual = simpleMathLib.minus(-7,0);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        void minusBothZeros1(){
            double expected = 0.0;
            double actual = simpleMathLib.minus(0,0);
            Assertions.assertEquals(expected,actual);
        }

        @AfterAll
        static void infoAfter1(){
            System.out.println("Finishing testing add function...");
        }
    }

    @AfterEach
    public void tearDown1(){
        simpleMathLib = null;
    }


}
