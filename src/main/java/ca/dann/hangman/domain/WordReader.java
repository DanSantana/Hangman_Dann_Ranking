package ca.dann.hangman.domain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Dann - Dangelo Santana
 * @professor Lounis Zaidi
 * @subject OPJE - v11-Project2005-0902
 *
 */

public class WordReader {

	private static final String fileName = "/res/words.txt";
	private ArrayList<String> words = new ArrayList<String>();

	public WordReader() {

		try (InputStream in = getClass().getResourceAsStream(fileName);
				BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {

			String line = "";
			while ((line = bf.readLine()) != null) {
				words.add(line);
			}
		} catch (Exception e) {
			System.out.println("Couldnt find or read the file: " + fileName);
			System.out.println(" Error messsage: " + e.getMessage());
		}
	}

	public String getRandomWord() {
		if (words.isEmpty())
			return "No Data";
		return words.get((int) (Math.random() * words.size()));
	}

	/*
	 * public static void main(String[] args) { WordReader w1 = new
	 * WordReader(); String word = w1.getRandomWord(); System.out.println(word);
	 * 
	 * }
	 */
}
