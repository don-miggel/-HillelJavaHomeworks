package mytest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;


public class SimpleMathLibraryTest {

    private SimpleMathLibrary simpleMathLib;

    @BeforeEach
    void setUp(){
        simpleMathLib = new SimpleMathLibrary();
    }

    @Nested
    public class AddTest{

        @BeforeAll
        static void infoBefore(){
            System.out.println("Starting testing add function...");
        }

        @Test
        public void addPositives(){
            double expected = 2.0;
            double actual = simpleMathLib.add(1,1);
            Assertions.assertEquals(expected,actual);

        }

        @Test
        public void addNegatives(){
            double expected = -5.0;
            double actual = simpleMathLib.add(-3,-2);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void addWithZero(){
            double expected = -1.0;
            double actual = simpleMathLib.add(-1,0);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void addBothZeros(){
            double expected = 0.0;
            double actual = simpleMathLib.add(0,0);
            Assertions.assertEquals(expected,actual);
        }

        @AfterAll
        static void infoAfter(){
            System.out.println("Finishing testing add function...");
        }

    }

    @Nested
    class MinusTest{

        @BeforeAll
        static void infoBefore(){
            System.out.println("Starting testing minus function...");
        }

        @Test
        public void minusAllPositives(){
            double expected = -1.0;
            double actual = simpleMathLib.minus(-5,-4);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        public void minusAllPositivesFailed(){
            double expected = -1.0;
            double actual = simpleMathLib.minus(-5,-4);
            Assertions.assertNotEquals(expected,actual);
        }

        @Test
        public void minusOnePositive(){
            double expected = -9.0;
            double actual = simpleMathLib.minus(-5,4);
            Assertions.assertEquals(expected,actual);

        }

        @Test
        public void minusZero(){
            double expected = -7.0;
            double actual = simpleMathLib.minus(-7,0);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        void minusBothZero(){
            double expected = 0.0;
            double actual = simpleMathLib.minus(0,0);
            Assertions.assertEquals(expected,actual);
        }

        @AfterAll
        static void infoAfter(){
            System.out.println("Finishing testing add function...");
        }
    }

    @AfterEach
    public void tearDown(){
        simpleMathLib = null;
    }


}
