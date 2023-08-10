package mytest.one.two;

import mytest.SimpleMathLibrary;
import org.junit.jupiter.api.*;


public class SimpleMathLibrary2Test {

    private SimpleMathLibrary simpleMathLib;

    @BeforeEach
    void setUp2(){
        simpleMathLib = new SimpleMathLibrary();
    }

    @Nested
    public class AddTest{

        @BeforeAll
        static void infoBefore2(){
            System.out.println("Starting testing add function...");
        }

        @Test
        public void addPositives2(){
            double expected = 2.0;
            double actual = simpleMathLib.add(1,1);
            Assertions.assertEquals(expected,actual);

        }

        @Test
        public void addNegatives2(){
            double expected = -5.0;
            double actual = simpleMathLib.add(-3,-2);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void addNegatives2Failed(){
            double expected = -5.0;
            double actual = simpleMathLib.add(-3,-2);
            Assertions.assertNotEquals(expected,actual);
        }

        @Test
        public void addWithZero2(){
            double expected = -1.0;
            double actual = simpleMathLib.add(-1,0);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void addBothZeros2(){
            double expected = 0.0;
            double actual = simpleMathLib.add(0,0);
            Assertions.assertEquals(expected,actual);
        }

        @AfterAll
        static void infoAfter2(){
            System.out.println("Finishing testing add function...");
        }

    }

    @Nested
    class MinusTest{

        @BeforeAll
        static void infoBefore2(){
            System.out.println("Starting testing minus function...");
        }

        @Test
        public void minusAllPositives2(){
            double expected = -1.0;
            double actual = simpleMathLib.minus(-5,-4);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void minusOnePositive2(){
            double expected = -9.0;
            double actual = simpleMathLib.minus(-5,4);
            Assertions.assertEquals(expected,actual);

        }

        @Test
        public void minusZero2(){
            double expected = -7.0;
            double actual = simpleMathLib.minus(-7,0);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        void minusBothZero2(){
            double expected = 0.0;
            double actual = simpleMathLib.minus(0,0);
            Assertions.assertEquals(expected,actual);
        }

        @AfterAll
        static void infoAfter2(){
            System.out.println("Finishing testing add function...");
        }
    }

    @AfterEach
    public void tearDown2(){
        simpleMathLib = null;
    }


}
