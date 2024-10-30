import java.util.Comparator;
@SuppressWarnings("expected package not found")
/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {
    
    private String query;
    private long weight;
    
    
    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) {
        
        if (query == null)
            throw new NullPointerException();
        if (weight < 0)
            throw new IllegalArgumentException();
            
        this.query = query;
        this.weight = weight;
         
        
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term t, Term t2) {
                return Long.compare(t2.weight, t.weight);
            }
        };
   }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) {
        if(length <= 0){
            throw new IllegalArgumentException();
        }


        return new Comparator<Term>() {
            public int compare(Term t, Term t2){
                String tpre = "";
                String t2pre = "";

                if(length > t.query.length())
                    tpre = t.query;
                else
                    tpre = t.query.substring(0,length);
                
                if(length > t2.query.length())
                    t2pre = t2.query;
                else
                    t2pre = t2.query.substring(0,length);
           
                return (tpre).compareTo(t2pre);
            }
        };
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
        return query.compareTo(other.query);
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
        return query + "\t" + weight;
    }

}

