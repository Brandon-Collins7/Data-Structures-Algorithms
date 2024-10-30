//import java.util.Arrays;
@SuppressWarnings("expected package not found")

/**
 * Autocomplete.
 */
public class Autocomplete {

	private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) {
		if(terms == null){
			throw new NullPointerException();
		}


        this.terms = terms;

		for(int i = 0; i < this.terms.length; i++){
			Term min = this.terms[i];
			int minIndex = i;

			int j = i + 1;
			for(j = i+1; j < this.terms.length; j++){
				if(this.terms[j].compareTo(min) < 0){
					min = this.terms[j];
					minIndex = j;
				}
			}

			Term temp = this.terms[i];
			this.terms[i] = min;
			this.terms[minIndex] = temp;
		}

    }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
	public Term[] allMatches(String prefix) {

		if(prefix == null)
			throw new NullPointerException();


		//Comparator<Term> comp = Term.<Term>byPrefixOrder(prefix.length());
		Term pre = new Term(prefix, 0);

		int first = BinarySearch.<Term>firstIndexOf(terms, pre, Term.byPrefixOrder(prefix.length()));
		int last = BinarySearch.<Term>lastIndexOf(terms, pre, Term.byPrefixOrder(prefix.length()));

		Term[] out = new Term[last-first+1];

	

		int index = 0;
		for(int i = first; i <= last; i++){
				out[index] = terms[i];
				index++;
			
		}


		
		for(int i = 0; i < out.length; i++){
			Term max = out[i];
			int maxIndex = i;

			int j = i + 1;
			for(j = i+1; j < out.length; j++){
				if(Term.byDescendingWeightOrder().compare(out[j], max) < 0){
					max = out[j];
					maxIndex = j;
				}
			}

			Term temp = out[i];
			out[i] = max;
			out[maxIndex] = temp;
		}

		return out;
	}

}



