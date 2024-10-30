package CompFund2.Module1.Assignment1;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SelectorTest {

    @Test
    public void test(){
        int[] a = {8,2,8,7,3,3,4};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);

        expected = 8;
        actual = Selector.max(a);
        assertEquals(expected, actual);

        expected = 4;
        actual = Selector.kmin(a, 3);
        assertEquals(expected, actual);

        expected = 4;
        actual = Selector.kmax(a, 3);
        assertEquals(expected, actual);

    
        //array in this order due to being sorted in kmin and kmax
        int[] expectedArr = {7,3,3,4};
        int[] actualArr = Selector.range(a, 3, 7);
        assertEquals(Arrays.toString(expectedArr), Arrays.toString(actualArr));

        expected = 7;
        actual = Selector.ceiling(a, 5);
        assertEquals(expected, actual);

        expected = 4;
        actual = Selector.floor(a, 5);
        assertEquals(expected, actual);
    }


    @Test
    public void test2(){
        int[] b = {2,3,3,3,3,5};
        int expected = 2;
        int actual = Selector.min(b);
        assertEquals(expected, actual);

        expected = 5;
        actual = Selector.max(b);
        assertEquals(expected, actual);

        expected = 5;
        actual = Selector.kmin(b, 3);
        assertEquals(expected, actual);

        expected = 3;
        actual = Selector.kmax(b, 2);
        assertEquals(expected, actual);

        int[] expectedArr = {};
        int[] actualArr = Selector.range(b, 7, 10);
        assertEquals(Arrays.toString(expectedArr), Arrays.toString(actualArr));

        expected = 5;
        actual = Selector.ceiling(b, 4);
        assertEquals(expected, actual);

        expected = 3;
        actual = Selector.floor(b, 4);
        assertEquals(expected, actual);
    }
    public static void main(String[] args) {
        int[] a = {8,2,8,7,3,3,4};
        int[] b = {2,3,3,3,3,5};
        int[] c = {};


        //IllegalArgumentException all the way down 
        System.out.println("kMin: " + Selector.kmin(b, 4));
        
        System.out.println("kMax: " + Selector.kmax(b, 0));
        System.out.println("kMax: " + Selector.kmax(a, -5));

        System.out.println("range: " + Arrays.toString(Selector.range(c, 0,9)));
        
        System.out.println("ceiling: " + Selector.ceiling(b, 6));

        System.out.println("floor: " + Selector.floor(b, 1));


    }
    
}
