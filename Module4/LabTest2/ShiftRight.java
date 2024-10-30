package CompFund2.Module4.LabTest2;

/**
 * Implements shift-right behavior in an array.
 *
 */

 public class ShiftRight {


    /**
     * Shifts the elements at a[index] through a[a.length - 2] one
     * position to the right. 
     */
    public static void shiftRight(Object[] array, int index) {
        int i = array.length-2;
        while(i>=index){
            array[i+1] = array[i];
            i--;
        }

        //i+1 will be index
        array[i+1] = null;
        // FILL IN THE BODY OF THIS METHOD



        //System.out.println(array);
        //FOR TESTING
    }


    
    //FOR TESTING
    public static void main(String[] args) {
        //Object[] array = new Object[10];
    }
}

