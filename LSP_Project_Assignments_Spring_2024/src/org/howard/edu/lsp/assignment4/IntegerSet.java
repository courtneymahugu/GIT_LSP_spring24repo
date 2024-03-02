/**
*  Name: Courtney Mahugu
*/
package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {

	// Store the set elements in an ArrayList
	private List<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	public IntegerSet() {
	}

	// Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	// Clears the internal representation of the set
	public void clear() {
		set.clear();
	};

	// Returns the length of the set
	public int length() {
		return set.size();
	}; // returns the length

	/*
	 * Returns true if the 2 sets are equal, false otherwise; Two sets are equal if
	 * they contain all of the same values in ANY order. This overrides the equal
	 * method from the Object class.
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

	// Returns true if the set contains the value, otherwise false
	public boolean contains(int value) {
		return set.contains(value);
	};

	// Returns the largest item in the set; Throws a IntegerSetException if the set
	// is empty
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

	// Returns the smallest item in the set; Throws a IntegerSetException if the set
	// is empty
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

	// Adds an item to the set or does nothing it already there
	public void add(int item) {

		if (!set.contains(item))
			set.add(item);

	}; // adds item to the set or does nothing if it is in set

	// Removes an item from the set or does nothing if not there
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	};

	// Set union
	public void union(IntegerSet intSetb) {

		for (Integer element : intSetb.set) {
			if (!this.contains(element))
				this.add(element);
		}
	};

	// Set intersection, all elements in s1 and s2
	public void intersect(IntegerSet intSetb) {
		this.set.retainAll(intSetb.set);
	};

	// Set difference, i.e., s1 –s2
	public void diff(IntegerSet intSetb) {

		for (int num : intSetb.set) {
			if (this.set.contains(num)) {
				int index = this.set.indexOf(num);
				this.set.remove(index);
			}
		}
	}; // set difference, i.e. s1 - s2

	// Set complement, all elements not in s1
	public void complement(IntegerSet intSetb) {

		IntegerSet temp = new IntegerSet();

		for (int num : intSetb.set) {
			if (!this.set.contains(num)) {
				temp.set.add(num);
			}
		}
		this.set = temp.set;
	};

	// Returns true if the set is empty, false otherwise
	boolean isEmpty() {
		return set.isEmpty();
	};

	// Return String representation of your set. This overrides the equal method
	// from
	// the Object class.

	public String toString() {
		return set.toString();
	}; // return String representation of your set

}

class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
