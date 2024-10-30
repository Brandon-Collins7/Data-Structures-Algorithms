package CompFund2.Module4.Assignment4;
//import java.util.Iterator;

public class LinkedSetTest<T extends Comparable<T>>{
    public static void main(String[] args) {

        LinkedSet<Integer> test3 = new LinkedSet<Integer>();
        Set<Integer> test4 = new LinkedSet<Integer>();
        
        test3.add(1);
        test3.add(2);
        test3.add(3);
        System.out.println(test3);

        //test4.add(2);
        ///test4.add(3);
       //test4.add(4);
        System.out.println(test4);
        
        System.out.println(test3.complement(test4));
        
        //LinkedSet<Integer> test2 = new LinkedSet<Integer>();
        
        
        /*Iterator<Set<Integer>> i2 = test2.powerSetIterator();
        System.out.println(i2.hasNext());
        System.out.println(i2.next());
        System.out.println(i2.hasNext());
        
        Iterator<Integer> ni2 = test2.iterator();
        System.out.println(ni2.hasNext());
        //System.out.println(ni2.next());
        System.out.println(ni2.hasNext());

        Iterator<Integer> di2 = test2.descendingIterator();
        System.out.println(di2.hasNext());
        System.out.println(di2.next());
        System.out.println(di2.hasNext());

        */

        /*LinkedSet<Integer> test = new LinkedSet<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        System.out.println(test);
        Iterator<Set<Integer>> i = test.powerSetIterator();
        
        int times = 0;
        while(times<33){
        Set<Integer> e = i.next();
        System.out.println(e);
        times++;
        }
        
        */
    


    }
    

}
