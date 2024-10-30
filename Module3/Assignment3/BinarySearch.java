//import java.util.Arrays;
//@SuppressWarning
import java.util.Comparator;
@SuppressWarnings("expected package not found")


/**
 * Binary search.
 */
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if(a == null || key == null || comparator == null){
            throw new NullPointerException();
        }
        
        int left = 0;
        int right = a.length-1;

        while(left <= right){
            int mid = (left+right)/2;
           

            if(comparator.compare(a[mid], key) == 0){
                while(mid >= 0 && comparator.compare(a[mid], key) == 0){
                    mid--;
                    //look left to find first index of an equal key
                }
                if(mid==-1){
                    return 0;
                }
                return mid+1;
            }

            else if(comparator.compare(a[mid], key)  < 0)
                left = mid+1;
            
            else{
                right = mid-1;
            }

        }

        return -1;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if(a == null || key == null || comparator == null){
            throw new NullPointerException();
        }
        
        int left = 0;
        int right = a.length-1;

        while(left <= right){
            int mid = (left+right)/2;


            if(comparator.compare(a[mid], key) == 0){
                while(mid < a.length && comparator.compare(a[mid], key) == 0){
                    mid++;
                    //look right to find last index of an equal key
                }
                if(mid==-1){
                    return 0;
                }
                return mid-1;
            }

            else if(comparator.compare(a[mid], key) < 0)
                left = mid+1;
            
            else{
                right = mid-1;
            }

        }

        return -1;
    }

}
