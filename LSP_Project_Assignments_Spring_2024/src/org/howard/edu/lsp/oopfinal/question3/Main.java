package org.howard.edu.lsp.oopfinal.question3;

public class Main {
	
	public static Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}

		return null;
	}
}
