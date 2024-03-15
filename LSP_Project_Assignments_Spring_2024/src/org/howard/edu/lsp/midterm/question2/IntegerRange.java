package org.howard.edu.lsp.midterm.question2;

/**
 * IntegerRange class implements the Range interface 
 * 
 * @author Courtney Mahugu
 */
public class IntegerRange implements Range {

	private int lowerbound; // Lower bound of the range.
    private int upperbound; // Upper bound of the range.

    /**
     * Constructor to create an IntegerRange with specific bounds.
     *
     * @param lowerbound The lower bound of the range.
     * @param upperbound The upper bound of the range.
     */
    public IntegerRange(int lowerbound, int upperbound) {
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    /**
     * Checks if the given value is within the range.
     *
     * @param value The value to check.
     * @return true if the value is within the bounds, false otherwise.
     */
    public boolean contains(int value) {
        return value >= lowerbound && value <= upperbound;
    }

    /**
     * Determines whether this range overlaps with another range.
     *
     * @param other The range to check for overlap.
     * @return true if there is any overlap, false otherwise.
     */
    public boolean overlaps(Range other) {
    	IntegerRange otherRange = (IntegerRange) other;
    	
    	return this.lowerbound <= otherRange.upperbound && this.upperbound >= otherRange.lowerbound;
    }

    /**
     * Calculates the size of the range.
     *
     * @return The total count of numbers within the range.
     */
    public int size() {
        return upperbound - lowerbound + 1;
    }

    /**
     * Compares this range to another range to determine equality.
     *
     * @param other The range to compare to.
     * @return true if both ranges have the same lower and upper bounds, false otherwise.
     */
    @Override
    public boolean equals(Range other) {
    	
    	IntegerRange otherRange = (IntegerRange) other;
    	return this.lowerbound == otherRange.upperbound && this.upperbound == otherRange.lowerbound;
    }
    
}
