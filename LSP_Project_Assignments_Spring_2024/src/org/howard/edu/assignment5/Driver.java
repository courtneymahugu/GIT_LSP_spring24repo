package org.howard.edu.assignment5;

public class Driver {

	public static void main(String[] args) {
		try {
			// Create the first IntegerSet and add elements
			IntegerSet set1 = new IntegerSet();
			set1.add(1);
			set1.add(2);
			set1.add(3);

			// Display the values and smallest/largest elements in set1
			System.out.println("Value of Set1 is: " + set1.toString());
			System.out.println("Smallest value in Set1 is: " + set1.smallest());
			System.out.println("Largest value in Set1 is: " + set1.largest());

			// Create the second IntegerSet and add elements
			IntegerSet set2 = new IntegerSet();
			set2.add(3);
			set2.add(4);
			set2.add(5);

			// Display the values in set2
			System.out.println("Value of Set2 is: " + set2.toString());

			// Perform the union operation on set1 and set2
			System.out.println("Union of Set1 and Set2");
			set1.union(set2);

			// Display the result of the union
			System.out.println("Result of union of Set1 and Set2: " + set1.toString());
		} catch (IntegerSetException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

}
