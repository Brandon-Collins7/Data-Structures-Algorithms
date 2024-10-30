package CompFund2.Module3.DynamicArrayResizing;

/**
 * ArrayBagClient.java
 * Provides a sample client of Bag behavior from
 * the ArrayBag class.
 *
 */
public class ArrayBagClient {
    /** Drives execution. */
    public static void main(String[] args) {
        Bag<Integer> bag = new ArrayBag<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
        }
        System.out.println(bag);
        
        for (int i = 9; i > 0; i--) {
            bag.remove(i);
        }
        System.out.println(bag);

    }
}
