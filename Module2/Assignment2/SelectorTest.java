package CompFund2.Module2.Assignment2;

//import java.util.Arrays;
import java.util.Comparator;
//import java.util.List;
import java.util.Collection;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SelectorTest {
    static Comparator<Integer> comp =
        new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        };



    @Test
    public void test(){
        Collection<Integer> a = new ArrayList<>(); 
        a.add(8);
        a.add(2);
        a.add(8);
        a.add(7);
        a.add(3);
        a.add(3);
        a.add(4);
        int expected = 2;
        int actual = Selector.<Integer>min(a, comp);
        assertEquals(expected, actual);

        expected = 8;
        actual = Selector.<Integer>max(a, comp);
        assertEquals(expected, actual);

        expected = 7;
        actual = Selector.<Integer>kmin(a, 4, comp);
        assertEquals(expected, actual);

        expected = 3;
        actual = Selector.<Integer>kmax(a, 4, comp);
        assertEquals(expected, actual);
    
        Collection<Integer> expectedList = new ArrayList<>();
        expectedList.add(7);
        expectedList.add(3);
        expectedList.add(3);
        expectedList.add(4);
        Collection<Integer> actualList = Selector.<Integer>range(a, 3, 7, comp);
        assertEquals(expectedList, actualList);

        expected = 7;
        actual = Selector.<Integer>ceiling(a, 5, comp);
        assertEquals(expected, actual);

        expected = 4;
        actual = Selector.<Integer>floor(a, 5, comp);
        assertEquals(expected, actual);
        
    }



    @Test
    public void test2(){
    
        Collection<Integer> b = new ArrayList<>(); 
        b.add(2);
        b.add(3);
        b.add(3);
        b.add(3);
        b.add(3);
        b.add(5);
        int expected = 2;
        int actual = Selector.<Integer>min(b, comp);
        assertEquals(expected, actual);

        expected = 5;
        actual = Selector.<Integer>max(b, comp);
        assertEquals(expected, actual);

        expected = 5;
        actual = Selector.<Integer>kmin(b, 3, comp);
        assertEquals(expected, actual);

        expected = 3;
        actual = Selector.<Integer>kmax(b, 2, comp);
        assertEquals(expected, actual);

        //Collection<Integer> expectedList = new ArrayList<>();
        //Collection<Integer> actualList= Selector.<Integer>range(b, 7, 10, comp);
        //assertEquals(expectedList, actualList);
        //should get Exception

        expected = 5;
        actual = Selector.<Integer>ceiling(b, 4, comp);
        assertEquals(expected, actual);

        expected = 3;
        actual = Selector.<Integer>floor(b, 4, comp);
        assertEquals(expected, actual);


    }
    public static void main(String[] args) {

        Collection<Integer> a = new ArrayList<>(); 
        a.add(8);
        a.add(2);
        a.add(8);
        a.add(7);
        a.add(3);
        a.add(3);
        a.add(4);

        Collection<Integer> b = new ArrayList<>(); 
        b.add(2);
        b.add(3);
        b.add(3);
        b.add(3);
        b.add(3);
        b.add(5);

        Collection<Integer> c = new ArrayList<>();


        //IllegalArgumentException or NoSuchElementException all the way down 
        System.out.println("kMin: " + Selector.<Integer>kmin(b, 4, comp));
        
        System.out.println("kMax: " + Selector.<Integer>kmax(b, 0, comp));
        System.out.println("kMax: " + Selector.<Integer>kmax(a, -5, comp));

        System.out.println("range: " + (Selector.<Integer>range(c, 0, 9, comp)));
        
        System.out.println("ceiling: " + Selector.<Integer>ceiling(b, 6, comp));

        System.out.println("floor: " + Selector.<Integer>floor(b, 1, comp));


    }
   
}

