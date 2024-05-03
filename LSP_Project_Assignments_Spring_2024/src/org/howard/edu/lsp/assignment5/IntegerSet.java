package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet class
 * 
 * @author Courtney Mahugu
 */
public class IntegerSet {

	// Store the set elements in an ArrayList
	private List<Integer> set = new ArrayList<Integer>();

	/**
	 * Default Constructor of IntegerSet
	 */
	public IntegerSet() {
	}

	/**
	 * Constructor that initializes the set with a given list of integers.
	 * 
	 * @param set An ArrayList of integers to initialize the set.
	 */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	/**
	 * Clears all elements from the set.
	 */
	public void clear() {
		set.clear();
	};

	/**
	 * Retrieves the number of elements in the set.
	 * 
	 * @return The size of the set.
	 */
	public int length() {
		return set.size();
	}; // returns the length

	/**
	 * Compares the current set with another object for equality.
	 * 
	 * @param o An object to be compared for equality.
	 * @return True if the object is an IntegerSet with the same elements, false
	 *         otherwise.
	 */
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (o == null)
			return false;

		IntegerSet that = (IntegerSet) o;
		if (this.set.size() != that.set.size())
			return false;
		return this.set.containsAll(that.set);
	};

	/**
	 * Determines if the set contains a specific integer.
	 * 
	 * @param value The integer to check for within the set.
	 * @return True if the value is found, false otherwise.
	 */
	public boolean contains(int value) {
		return set.contains(value);
	};

	/**
	 * Retrieves the largest element in the set.
	 * 
	 * @return The largest integer in the set.
	 * @throws IntegerSetException if the set is empty.
	 */
	public int largest() throws IntegerSetException {
		if (set.isEmpty())
			throw new IntegerSetException("The set is empty.");

		int large = set.get(0);
		for (int current : set) {
			if (current > large) {
				large = current;
			}
		}
		return large;
	};

	/**
	 * Retrieves the smallest element in the set.
	 * 
	 * @return The smallest integer in the set.
	 * @throws IntegerSetException if the set is empty.
	 */
	public int smallest() throws IntegerSetException {

		if (set.isEmpty())
			throw new IntegerSetException("The set is empty.");

		int small = set.get(0);
		for (int current : set) {
			if (current < small) {
				small = current;
			}
		}
		return small;
	};

	/**
	 * Adds an integer to the set if it's not already present.
	 * 
	 * @param item The integer to add to the set.
	 */
	public void add(int item) {

		if (!set.contains(item))
			set.add(item);

	}; // adds item to the set or does nothing if it is in set

	/**
	 * Removes an integer from the set if it is present.
	 * 
	 * @param item The integer to remove from the set.
	 */
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	};

	/**
	 * Performs the union of this set with another set.
	 * 
	 * @param intSetb Another IntegerSet to perform the union with.
	 */
	public void union(IntegerSet intSetb) {

		for (Integer element : intSetb.set) {
			if (!this.contains(element))
				this.add(element);
		}
	};

	/**
	 * Performs the intersection of this set with another set.
	 * 
	 * @param intSetb Another IntegerSet to perform the intersection with.
	 */
	public void intersect(IntegerSet intSetb) {
		this.set.retainAll(intSetb.set);
	};

	/**
	 * Performs the difference of this set with another set.
	 * 
	 * @param intSetb Another IntegerSet to perform the difference with.
	 */
	public void diff(IntegerSet intSetb) {

		for (int num : intSetb.set) {
			if (this.set.contains(num)) {
				int index = this.set.indexOf(num);
				this.set.remove(index);
			}
		}
	}; // set difference, i.e. s1 - s2

	/**
	 * Computes the complement of this set against another set.
	 * 
	 * @param intSetb Another IntegerSet to compute the complement with.
	 */
	public void complement(IntegerSet intSetb) {

		IntegerSet temp = new IntegerSet();

		for (int num : intSetb.set) {
			if (!this.set.contains(num)) {
				temp.set.add(num);
			}
		}
		this.set = temp.set;
	};

	/**
	 * Checks if the set is empty.
	 * 
	 * @return True if the set has no elements, false otherwise.
	 */
	boolean isEmpty() {
		return set.isEmpty();
	};

	/**
	 * Provides a string representation of the integer set. Overrides the equal
	 * method from the Object class.
	 * 
	 * @return A string that lists all elements of the set.
	 */
	public String toString() {
		return set.toString();
	}; // return String representation of your set

}

class IntegerSetException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IntegerSetException(String message) {
		super(message);
	}
}
