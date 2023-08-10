package mytest.array_analyzer;

import org.junit.jupiter.api.*;

import java.util.Arrays;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayAnalyzerTest {

    private ArrayAnalyzer ar;

    @BeforeEach
    void setUp(){
        ar = new ArrayAnalyzer();
    }

    @Nested
    public class AnalyzeArrayTest{

        @Test
        void testEmptyArray(){
            int[] expected = new int[]{};

            int[] actual = ar.analyzeArray(new int[]{});
            Assertions.assertArrayEquals(expected, actual);

        }

        @Test
        void testFourFirstPos(){

            int[] expected = new int[] {6,3};
            int[] actual = ar.analyzeArray(new int[]{4,6,3});
   //         System.out.println(Arrays.toString(actual));
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void testFourPreLastPos(){

            int[] expected = new int[]{1};
            int[] actual = ar.analyzeArray(new int[]{1,2,5,2,4,1});
 //           System.out.println(Arrays.toString(actual));
            Assertions.assertArrayEquals(expected, actual);

        }

        @Test
        void testWithCoupleOfFours(){

            int[] expected = new int[]{1,9};
            int[] actual  = ar.analyzeArray(new int[]{5,4,3,4,2,1,3,4,1,9});
            System.out.println(Arrays.toString(actual));
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void testNullInput(){
            int[] expected = new int[]{};

            int[] actual = ar.analyzeArray(null);
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void testFourAtLastPos(){
            int[] expected = new int[]{};
            int[] actual  = ar.analyzeArray(new int[]{5,4,3,4,2,1,3,4,1,9,4});
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void testArrWithOneElem(){
            int[] expected = new int[]{};
            int[] actual  = ar.analyzeArray(new int[]{4});
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void testArrWithOneElemNotFour(){
            Assertions.assertThrows(RuntimeException.class,
                    ()->ar.analyzeArray(new int[]{5})
                    );
        }

        @Test
        void testArrWithoutFours(){
            Assertions.assertThrows(RuntimeException.class,
                    ()->ar.analyzeArray(new int[]{5,2,1,3})
            );
        }

    }

    @Nested
    public class testOneFourAnalyzer{

        @Test
        void testOne1One4(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,4});
            Assertions.assertTrue(actual);

        }

        @Test
        void testCoupleOnesOneFour(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,1,1,1,4});
            Assertions.assertTrue( actual);

        }

        @Test
        void testCoupleFours1One(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,4,4,4});
            Assertions.assertTrue( actual);
        }

        @Test
        void testContainingOtherDigits(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,1,1,4,4,3});
            Assertions.assertFalse( actual);
        }

        @Test
        void testOneElemArrayWithOne(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1});
            Assertions.assertFalse( actual);
        }

        @Test
        void testOneElemArrayWithFour(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{4});
            Assertions.assertFalse( actual);
        }

        @Test
        void testEmptyArray(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{});
            Assertions.assertFalse( actual);
        }

        @Test
        void testNullValuePassed(){

            boolean actual = ar.analyzeFoursOnesArray(null);
            Assertions.assertFalse( actual);
        }

        @Test
        void testTwoOtherDigitsWithoutFourAndOne(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{3,5});
            Assertions.assertFalse( actual);
        }

        @Test
        void testCoupleOtherDigitsWithoutFourAndOne(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{3,5,3,3,5,5,3});
            Assertions.assertFalse( actual);
        }

        @Test
        void testWithOnlyOnes(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,1,1,1,1});
            Assertions.assertFalse( actual);
        }

        @Test
        void testWithOnlyFours(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{4,4,4,4,4});
            Assertions.assertFalse( actual);
        }

        @Test
        void testCoupleOnesCoupleFours(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,1,1,1,1,4,4,4,4,4,4,4,4});
            Assertions.assertTrue( actual);
        }

        @Test
        void testCoupleOnesCoupleFours1(){

            boolean actual = ar.analyzeFoursOnesArray(new int[]{1,1,1,1,1,4,4,4,4,4,4,4,4});
            Assertions.assertFalse( actual);
        }
    }

    @AfterEach
    void tearDown(){
        ar = new ArrayAnalyzer();
    }


}
