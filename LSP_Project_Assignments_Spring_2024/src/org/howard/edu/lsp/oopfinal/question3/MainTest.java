package org.howard.edu.lsp.oopfinal.question3;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;


public class MainTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final String newline = System.lineSeparator();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    
	@Test
	public void testCreateCircle() {
		Shape shape = Main.getShape("Circle");
		assertNotNull(shape);
		shape.draw();
		assertEquals("I’m a Circle!!!" + newline, output.toString());
	}

	@Test
	public void testCreateRectangle() {
		Shape shape = Main.getShape("RECTANGLE");
		assertNotNull(shape);
		shape.draw();
        assertEquals("I’m a Rectangle!!!" + newline, output.toString());
	}
	
	@After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
