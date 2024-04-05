package org.howard.edu.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * IntegerSet Tests
 * 
 * @author Courtney Mahugu
 */
public class IntegerSetTest {

	private IntegerSet testSet;

	@BeforeEach
	public void setUp() throws Exception {
		testSet = new IntegerSet();
	}

	@Test
	@DisplayName("Test case for clear")
	public void testClear() {
		testSet.add(1);
		testSet.clear(); //Clears all elements from the set.
		assertTrue(testSet.isEmpty()); 
	}

	@Test
	@DisplayName("Test case for length")
	public void testLength() {
		testSet.add(1);
		testSet.add(2); 
		assertEquals(2, testSet.length());
	}

	@Test
	@DisplayName("Test case for equals")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);

		IntegerSet set2 = new IntegerSet();
		set2.add(1);
		set2.add(2);

		assertTrue(set1.equals(set2));
	}

	@Test
	@DisplayName("Test case for contains")
	public void testContains() {
		testSet.add(1);
		assertTrue(testSet.contains(1));
		assertFalse(testSet.contains(2));
	}

	@Test
	@DisplayName("Test case for largest")
	public void testLargest() throws IntegerSetException {
		testSet.add(1);
		testSet.add(3);
		testSet.add(2);
		assertEquals(3, testSet.largest());
	}

	@Test
    @DisplayName("Test case for largest with exception")
    public void testLargestWithException() {
        IntegerSet testSet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> {
            testSet.largest();
        }, "Expected IntegerSetException to be thrown for largest on empty set");
    }


	@Test
	@DisplayName("Test case for smallest")
	public void testSmallest() throws IntegerSetException {
		testSet.add(1);
		testSet.add(3);
		testSet.add(2);
		assertEquals(1, testSet.smallest());
	}

	@Test
    @DisplayName("Test case for smallest with exception")
    public void testSmallestWithException() {
        IntegerSet testSet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> {
            testSet.smallest();
        }, "Expected IntegerSetException to be thrown for smallest on empty set");
    }

	@Test
	@DisplayName("Test case for add")
	public void testAdd() {
		testSet.add(1);
		assertTrue(testSet.contains(1));
	}

	@Test
	@DisplayName("Test case for remove")
	public void testRemove() {
		testSet.add(1);
		testSet.remove(1);
		assertFalse(testSet.contains(1));
	}

	@Test
	@DisplayName("Test case for union")
	public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);

		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);

		set1.union(set2);
		assertTrue(set1.contains(1));
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		assertTrue(set1.contains(4));
	}

	@Test
	@DisplayName("Test case for intersect")
	public void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		set2.add(4);

		set1.intersect(set2);
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		assertFalse(set1.contains(1));
		assertFalse(set1.contains(4));
	}

	@Test
	@DisplayName("Test case for diff")
	public void testDiff() {
		IntegerSet anotherSet = new IntegerSet();
		testSet.add(1);
		testSet.add(2);
		anotherSet.add(2);
		testSet.diff(anotherSet);
		assertTrue(testSet.contains(1) && !testSet.contains(2),
				"Set should only contain elements not in the other set after diff");
	}

	@Test
	@DisplayName("Test case for complement")
	public void testComplement() {
		IntegerSet anotherSet = new IntegerSet();
		testSet.add(1);
		testSet.add(2);
		anotherSet.add(2);
		anotherSet.add(3);
		testSet.complement(anotherSet);
		// Assuming complement is implemented as elements in the testSet that are not in
		// anotherSet
		assertTrue(testSet.contains(1) && !testSet.contains(2) && !testSet.contains(3),
				"Set should only contain elements not in the other set after complement");
	}

	@Test
	@DisplayName("Test case for isEmpty")
	public void testIsEmpty() {
		assertTrue(testSet.isEmpty(), "Newly created set should be empty");
		testSet.add(1);
		assertFalse(testSet.isEmpty(), "Set should not be empty after adding an element");
	}

	@Test
	@DisplayName("Test case for toString")
	public void testToString() {
		testSet.add(1);
		testSet.add(2);
		String expected = "[1, 2]";
		assertEquals(expected, testSet.toString(), "String representation of the set should match expected output");
	}
}
