/**
*  Name: Courtney Mahugu
*/
package org.howard.edu.lsp.assignment2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	public static void main(String[] args) {

		try {

			Map<String, Integer> tracker = new HashMap<>(); // was going to use a HashSet but wanted value pairs

			List<String> lines = Files.readAllLines(Paths.get("src/org/howard/edu/lsp/assignment2/words.txt")); // takes
																												// all
																												// the
																												// lines
																												// and
																												// stores
																												// line
																												// as a
																												// value
																												// in a
																												// list

			for (String line : lines) {

				String[] lineToWords = line.split("[' ]+"); // splits the line into words, separates by space AND
															// apostrophes (to separate contractions)

				for (String word : lineToWords) {

					word = word.replaceAll("[^a-zA-Z']", ""); // Removes anything that's not in the alphabet (aka.
																// numbers)
					word = word.toLowerCase(); // to avoid case-sensitivity

					if (word.isEmpty() || word.length() < 4) {
						continue;

					} else if (!tracker.containsKey(word)) { // if not already counted, start counter

						tracker.put(word, 1);

					} else { // add to count

						int currentValue = tracker.getOrDefault(word, 0); // would set value to 0 if no value
						tracker.put(word, currentValue + 1);
					}
				}
			}

			for (Map.Entry<String, Integer> entry : tracker.entrySet()) {
				System.out.println(entry.getKey() + "  " + entry.getValue());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}