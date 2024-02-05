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

			Map<String, Integer> tracker = new HashMap<>();

			List<String> lines = Files.readAllLines(Paths.get("src/org/howard/edu/lsp/assignment2/words.txt"));

			for (String line : lines) {
				
		
				String[] lineToWords = line.split("[' ]+");
				
				for (String word : lineToWords) {
					
					word = word.replaceAll("[^a-zA-Z']", ""); //Removes anything that's not in the alphabet
					word = word.toLowerCase();
					
					if(word.isEmpty() || word.length() < 4) {
				        continue;

				    } else if(!tracker.containsKey(word)) {
	
						tracker.put(word, 1);
	
					} else {
	
						int currentValue = tracker.getOrDefault(word, 0);
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