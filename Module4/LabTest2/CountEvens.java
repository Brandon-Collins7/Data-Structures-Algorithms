package CompFund2.Module4.LabTest2;

/**
 * Count the number of even values in a chain of linked nodes.
 *
 */
public class CountEvens {

    //  C O M P L E T E   T H I S    M E T H O D 

    /**
     * Returns the number of even values in the paramter.
     */
    public int countEvens(Node firstNode) {
        int count = 0;
        if(firstNode != null){
            if(firstNode.value % 2 == 0){
                count++;
            }
        }
        else{
            return 0;
        }

        while(firstNode.next != null){
            firstNode = firstNode.next;
            if(firstNode.value % 2 == 0){
                count++;
            }
        }

        return count;
    }

    class Node {
        int value;
        Node prev;
        Node next;

        public Node(int val) {
            value = val;
            prev = null;
            next = null;
        }
    }


    public static void main(String[] args) {
        ;
        //for testing
    }
}

    