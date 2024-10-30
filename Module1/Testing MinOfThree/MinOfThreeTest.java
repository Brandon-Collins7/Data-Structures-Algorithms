import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOfThreeTest {  
    
/**
 * MinOfThreeTest.java
 * Illustrates JUnit tests for the LinearSearch2 class.
 */


    ///////////////////
    // Typical cases //
    ///////////////////

    /** Test with a.length > 2, target found at front */
    @Test
    public void testMinTypical1() {
        int a = 2;
        int b = 3;
        int c = 4;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Test with a.length > 2, target found at rear */
    @Test
    public void testMinTypical2() {
        int a = 5;
        int b = -9;
        int c = -854;
        int expected = -854;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    


    ////////////////////
    // Special cases //
    ////////////////////

    /** Test with a.length = 1, target found */
    @Test
    public void testMinSpecial1() {
        int a = 2;
        int b = 2;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Test with a.length = 1, target not found */
    @Test
    public void testMinSpecial2() {
        int a = 1;
        int b = 2;
        int c = 1;
        int expected = 1;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }


    /** Test with a.length = 2, target found at front */
    @Test
    public void testMinSpecial3() {
        int a = 2;
        int b = 2;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /////////////////////
    // Boundary cases ///
    /////////////////////

    /** Test with a.length = 2, target found at rear 
    @Test
    public void testSearchBoundary4() {
        int[] a = {2, 4};
        int target = 4;
        int expected = 1;
        int actual = LinearSearch2.search(a, target);
        assertEquals(expected, actual);
    }
    */

   

}


