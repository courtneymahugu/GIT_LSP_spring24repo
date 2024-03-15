package org.howard.edu.lsp.midterm.question2;

/**
 * Range interface
 * 
 * @author Courtney Mahugu
 */
public interface Range {
	
	// Returns true if v is ≥ lower bound and ≤ upper bound and false otherwise
	public boolean contains( int value ); 

	// Returns true if the receiver contains at least 
	// one value in common with other, and false otherwise
	public boolean overlaps( Range other );

	// // Returns the number of integers in the range
	public int size(); 
	
	// Returns true if two ranges are equal
	public boolean equals(Range other);
}
