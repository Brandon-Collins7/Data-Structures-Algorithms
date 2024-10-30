package CompFund2.Module1.Assignment1;


import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Brandon Collins (blc0063@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  8/24/2023
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {

        //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        
        int min = a[0];
        for(int val : a){
            if(val < min)
                min = val;
        }
        return min;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {

        //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }

       int max = a[0];
        for(int val : a){
            if(val > max)
                max = val;
        }
        return max;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {

    //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        
        //create new array so a won't be sorted for other methods
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        Arrays.sort(b);
        
        
        int i = 0;
        int prev = b[b.length-1]+1;

        while(i < b.length && k > 0){

            //to skip duplicates
            if(b[i] != prev){
                k-=1;
                prev = b[i];
            }
            if(k==0){
                return b[i];
            }
            i++;
        }
        
        //if this is reached, there is no kth min
        //k is larger than the number of distinct values in the array
        throw new IllegalArgumentException();
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {

        //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
        
        //create new array so a won't be sorted for other methods
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        Arrays.sort(b);
        
        
        int i = b.length-1;
        int prev = b[0]-1;

        while(i >= 0 && k > 0){

            //to skip duplicates
            if(b[i] != prev){
                k-=1;
                prev = b[i];
            }
            if(k==0){
                return b[i];
            }
            i--;
        }
        
        //if this is reached, there is no kth max
        //k is larger than the number of distinct values in the array
        throw new IllegalArgumentException();
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {

        //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }

        //counts how many elements are in the range and will be in the array
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] >= low && a[i] <= high)
                count++;
        }
        
        //makes the array
        int[] b = new int[count];
        int index = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] >= low && a[i] <= high){
                b[index] = a[i];
                index++;
            }
        }

        return b;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {


        //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }
    

        //Fix if there is no min bigger than key by making sure that the initial minimum is greater or equal to the key
        int min = a[0];
        boolean validVal = false;
        for(int val : a){
            if(val >= key){
                min = val;
                validVal = true;
            }
        }

        //if no value is greater than or equal to the key
        if(!(validVal)){
            throw new IllegalArgumentException();
        }
            

        for(int val : a){
            if(val < min && val >= key)
                min = val;
        }
        return min;
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        
        //null or zero length throws exception
        if(a == null || a.length == 0){
            throw new IllegalArgumentException();
        }

        
        //Fix if the max isn't smaller than key by ensuring the initial max is less than or equal to the key

        int max = a[0];
        boolean validVal = false;
        for(int val : a){
            if(val <= key){
                max = val;
                validVal = true;
            }
        }


        //if no value is less than or equal to the key
        if(!(validVal)){
            throw new IllegalArgumentException();
        }
        
        for(int val : a){
            if(val > max && val <= key)
                max = val;
        }
        return max;
    }

}


