package CompFund2.Module4.Assignment4;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Brandon Collins (blc0063@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */


    public boolean add(T element) {
        if (element == null){
            throw new NullPointerException();
        }

        Node p = front;
        int index = 0;

        while(index < size && element.compareTo(p.element) > 0){
            index++;
            if(index != size)
                p = p.next;
        }
        
    
        if(index <= size && size!= 0 && element.compareTo(p.element)==0){
            return false;
        }

        size++;

        if (index==0){
            Node n = new Node(element);
            if(p != null){
                n.next = p;
                p.prev = n;
            }
            else{
                rear = n;
            }
            front = n;
            return true;
        }
        //index+1 due to size being increased earlier
        if (index+1==size){
            Node n = new Node(element);
            
            n.prev = p;
            p.next = n;
           
            rear = n;
            return true;
        }

        Node n = new Node(element);
        n.next = p;
        n.prev = p.prev;
        p.prev.next = n;
        p.prev = n;

        return true;
    }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */


    public boolean remove(T element) {
        
        if (element == null){
            throw new NullPointerException();
        }

        if (size == 0){
            return false;
        }


        //update front and rear nodes 
        int index = 0;
        if (front.element != null && element.equals(front.element)){
            front = front.next;
            if(front != null)
                front.prev = null;
            size--;
            if (size == 0){
                rear = null;
            }
            return true;
        }

        if (rear.element != null && element.equals(rear.element)){
            rear = rear.prev;
            rear.next = null;
            size--;
            return true;
        }


        Node p = front;
        while (index<size){
            if(element.equals(p.element)){
                p.prev.next = p.next;
                
                if(p.next != null){
                    p.next.prev = p.prev;
                }
                
                p = null;
                size--;
                return true;
            }
            p = p.next;
            index++;
        }
        
        return false;
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */

    
    public boolean contains(T element) {
        if (element == null){
            throw new NullPointerException();
        }

        int index = 0;
        Node p = front;
        while (index<size){
            if(element.equals(p.element)){
                return true;
            }
            p = p.next;
            index++;
        }

        return false;

    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(Set<T> s) {
        if (this.size() != s.size()){
            return false;
        }

        for(T e : this){
            if (!s.contains(e)){
                return false;
            }
        }
        return true;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(LinkedSet<T> s) {
        if (this.size() != s.size()){
            return false;
        }

        Iterator<T> i2 = s.iterator();

        for(T e: this){
            if(!e.equals(i2.next())){
                return false;
            }
        }

        return true;

    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */

    
    public Set<T> union(Set<T> s){
        if(size == 0){
            return s;
        }
        if(s.size() == 0){
            return this;
        }

        Iterator<T> i1 = this.iterator();
        Iterator<T> i2 = s.iterator();

        
        Set<T> out = new LinkedSet<T>();

        while (i1.hasNext()){
            T s1 = i1.next();
            out.add(s1);
        
        }

        while (i2.hasNext()){
            T s2 = i2.next();
            out.add(s2);
        }

        return out;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */

    //FIXME COULD MADE THIS O(N) BY USING DESCENDING ITERATOR. This would make add O(1) every time since the new element would be
    //first every time 

    public Set<T> union(LinkedSet<T> s){

        if(size == 0){
            return s;
        }
        if(s.size == 0){
            return this;
        }

        Iterator<T> i1 = this.iterator();
        Iterator<T> i2 = s.iterator();

        T s1 = i1.next();
        T s2 = i2.next();
        Set<T> out = new LinkedSet<T>();

        while (i1.hasNext() && i2.hasNext()){
            if(s1.compareTo(s2) <= 0){
                out.add(s1);
                s1 = i1.next();
            }
            else{
                out.add(s2);
                s2 = i2.next();
            }
        }


        //account for last element in one of the sets
        if(s1.compareTo(s2) <= 0){
                out.add(s1);
        }
        else{
                out.add(s2);
        }


        boolean extra1 = false;
        boolean extra2 = false;

        while(i1.hasNext()){
            extra1 = true;
            out.add(s1);
            s1 = i1.next();
            
        }

        while(i2.hasNext()){
            extra2 = true;
            out.add(s2);
            s2 = i2.next();
        }
        
        //account for last element in other set
        if(extra1){
                out.add(s1);
        }
        else if(extra2){
                out.add(s2);
        }

        return out;
        
        

    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */


    public Set<T> intersection(Set<T> s) {
        if(size == 0){
            return this;
        }
        if(s.size() == 0){
            return s;
        }

        Iterator<T> i2 = s.iterator();

        T s2;
        Set<T> out = new LinkedSet<T>();

        while (i2.hasNext()){
            s2 = i2.next();
            if(this.contains(s2)){
                out.add(s2);
            }
        }
       
        return out;
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */

    //FIXME COULD MADE THIS O(N) BY USING DESCENDING ITERATOR. This would make add O(1) every time since the new element would be
    //first every time 
    public Set<T> intersection(LinkedSet<T> s) {
        
        if(size == 0){
            return this;
        }
        if(s.size == 0){
            return s;
        }


        Iterator<T> i1 = this.iterator();
        Iterator<T> i2 = s.iterator();

        T s1 = i1.next();
        T s2 = i2.next();
        Set<T> out = new LinkedSet<T>();

        while (i1.hasNext() && i2.hasNext()){
            if(s1.compareTo(s2) < 0){
                s1 = i1.next();
            }
            else if (s1.compareTo(s2) > 0){
                s2 = i2.next();
            }
            else{
                out.add(s1);
                s1 = i1.next();
                s2 = i2.next();
            }
        }


        //account for last element in one of the sets
        if(s1.equals(s2)){
                out.add(s1);
        }
       
        return out;
        
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */

    public Set<T> complement(Set<T> s) {
        if(size == 0 || s.size() == 0){
            return this;
        }
        

        Iterator<T> i1 = this.iterator();

        T s1;
        Set<T> out = new LinkedSet<T>();

        while (i1.hasNext()){
            s1 = i1.next();
            if(!s.contains(s1)){
                out.add(s1);
            }
        }
       
        return out;
        
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */

    //FIXME COULD MADE THIS O(N) BY USING DESCENDING ITERATOR. This would make add O(1) every time since the new element would be
    //first every time 
    public Set<T> complement(LinkedSet<T> s) {
        
        if(size == 0 || s.size== 0){
            return this;
        }
        

        Iterator<T> i1 = this.iterator();
        Iterator<T> i2 = s.iterator();

        T s1 = i1.next();
        T s2 = i2.next();
        Set<T> out = new LinkedSet<T>();

        while (i1.hasNext() && i2.hasNext()){
            if(s1.compareTo(s2) < 0){
                out.add(s1);
                s1 = i1.next();
            }
            else if (s1.compareTo(s2) > 0){
                out.add(s2);
                s2 = i2.next();
            }
            else{
                
                s1 = i1.next();
                s2 = i2.next();
            }
        }


        //account for last element in one of the sets
        if(!s1.equals(s2)){
            out.add(s1);
        }

        while(i1.hasNext()){
            s1 = i1.next();
            out.add(s1);
            
        }

       
        return out;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */


    public Iterator<T> iterator() {
        return new Iterator<T>(){

            boolean first = true;

            Node n = front;
            public boolean hasNext(){
                if (first){
                    return n != null;
                }
                return n.next != null;
            }
            
            //^^^^^ABOVE
            //Is there a better workaround for getting n to switch to n.next and return current n???
            //AND BELOW

            public T next(){
                if((first && n==null) || (!first && n.next == null)){
                    throw new NoSuchElementException();
                }

                if (first){
                first = false;
                return n.element;
                }
                n = n.next;
                return n.element;

            }
        };
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() {
        return new Iterator<T>(){

            boolean first = true;

            Node n = rear;
            public boolean hasNext(){
                if (first){
                    return n != null;
                }
                return n.prev != null;
            }
            
            //^^^^^ABOVE
            //Is there a better workaround for getting n to switch to n.prev and return current n???
            //AND BELOW

            public T next(){
                if((first && n==null) || (!first && n.prev == null)){
                    throw new NoSuchElementException();
                }

                if (first){
                first = false;
                return n.element;
                }
                n = n.prev;
                return n.element;

            }
        };
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() {
        return new Iterator<Set<T>>(){

            int bits = size;
            double powerLen = Math.pow(2, size);
            int powerCount = 0;


            public boolean hasNext(){
                return powerCount < powerLen;
            }
            
           

            public Set<T> next(){
                if (!(powerCount < powerLen)){
                    throw new NoSuchElementException();
                }


                Set<T> tempSet = new LinkedSet<T>();

                if(bits == 0){
                    powerCount++;
                    return tempSet;
                }

                Node p = front;
                
                
                for(int j = 0; j < bits; j++){
                    

                    if(((powerCount >> j) & 1) > 0){
                            
                        tempSet.add(p.element);
                    }

                    if(j!=bits-1)
                        p = p.next;
                }

                powerCount++;
                return tempSet;
                
            }
        };
    }



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.

    ////////////////////
    // Nested classes //
    ////////////////////

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

}

