package org.howard.edu.lsp.midterm.question2;

/**
 * The RangeTester
 * 
 * @author Courtney Mahugu
 */
public class RangeTester {
    /**
     * The main method that executes tests on the IntegerRange class.
     */
    public static void main(String[] args) {
    	
    	//test ranges:
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(1, 10);

        System.out.println("Range1 contains 5 " + range1.contains(5)); // Should print true
        System.out.println("Range2 contains 20 " + range2.contains(20)); // Should print false
        
        System.out.println("Range1 overlaps with Range2 " + range1.overlaps(range2)); // Should print true
        System.out.println("Range2 overlaps with Range3 " + range2.overlaps(range3)); // Should print true
        
        System.out.println("Size of Range1 " + range1.size()); // Should print 10
        System.out.println("Size of Range2 " + range2.size()); // Should print 11
        
        System.out.println("Range1 is equal to Range3 " + range1.equals(range3)); // Should print false
        System.out.println("Range1 is equal to Range2 " + range1.equals(range2)); // Should print false
    }
}