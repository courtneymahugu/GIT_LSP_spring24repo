package org.howard.edu.lsp.midterm.question1;

/**
 * SecurityOps Class
 * 
 * @author Courtney Mahugu
 */
public class SecurityOps {

	/**
     * This method encrypts the text given by concatenating the even-indexed characters
     * followed by the odd-indexed characters.
     *
     * @param text The string to encrypt.
     * @return The encrypted string.
     */
	public static String encrypt(String text) {
		
		//gets rid of all punctuation
		text = text.replaceAll("[\\W_]", ""); 
		
		StringBuilder evenChars = new StringBuilder(); //holds the even indexed characters
		StringBuilder oddChars = new StringBuilder(); //odd indexed characters
		
		for (int i = 0; i < text.length(); i++) {
	        if (i % 2 == 0) { //if index can be % by 2, its even
	            evenChars.append(text.charAt(i)); //move character to even strings
	        } else {
	            oddChars.append(text.charAt(i));
	        }
	    }
		
		return evenChars.toString() + oddChars.toString();
	}
}