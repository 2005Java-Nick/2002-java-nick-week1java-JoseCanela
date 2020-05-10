package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration

		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration

		char firstLetter = Character.toUpperCase(phrase.charAt(0)); // First letter in phrase
		String otherLetters = "";

		for (int i = 0; i < phrase.length()-2; i++) {
			// if BOTH the current char and the next char (in phrase) are either a space or a punctuation
			if(!(Character.isLetter(phrase.charAt(i))) && !(Character.isLetter(phrase.charAt(i+1)))) {
				otherLetters += Character.toString(phrase.charAt(i+2)).toUpperCase(); // add the char located 2 indices after the current char to otherLetters
			} // else if BOTH the current char and the previous char (in phrase) are either a space or a punctuation
			else if (!(Character.isLetter(phrase.charAt(i))) && !(Character.isLetter(phrase.charAt(i-1)))) {
				otherLetters += ""; // add nothing to otherLetters
			} // else if the current char (in phrase) is either a space or a punctuation
			else if (Character.isLetter(phrase.charAt(i)) == false) {
				otherLetters += Character.toString(phrase.charAt(i+1)).toUpperCase(); // add the char located 1 index after the current char to otherLetters
			}
		}

		// return the concatenation of the first letter in phrase and the other relevant letters (otherLetters)
		return firstLetter + otherLetters; 
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration

			boolean isEquil = false; // initializes the triangle as not equilateral
			// if all sides are equal sides are equal to each other
			if((this.sideOne == this.sideTwo) && (this.sideOne == this.sideThree)) {
				isEquil = true; // the triangle is equilateral
			}
			return isEquil; // returns false or true depending on the if statement
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration

			boolean isIsos = true;
			if((this.sideOne == this.sideTwo) && (this.sideOne == this.sideThree)) {
				isIsos = false;
			} else if((this.sideOne != this.sideTwo) && (this.sideOne != this.sideThree) && (this.sideTwo != this.sideThree)) {
				isIsos = false;
			}
			return isIsos;

		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration

			boolean isScal = false;
			if((this.sideOne != this.sideTwo) && (this.sideOne != this.sideThree) && (this.sideTwo != this.sideThree)) {
				isScal = true;
			}
			return isScal;
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		//Create HashMap (referred to as hm) with capital alphabet letters as keys and their values
		 
		Map< String,Integer> hm =  new HashMap< String,Integer>(); 
		hm.put("A", new Integer(1)); 
		hm.put("B", new Integer(3)); 
		hm.put("C", new Integer(3)); 
		hm.put("D", new Integer(2));
		hm.put("E", new Integer(1));
		hm.put("F", new Integer(4));
		hm.put("G", new Integer(2));
		hm.put("H", new Integer(4));
		hm.put("I", new Integer(1));
		hm.put("J", new Integer(8));
		hm.put("K", new Integer(5));
		hm.put("L", new Integer(1));
		hm.put("M", new Integer(3));
		hm.put("N", new Integer(1));
		hm.put("O", new Integer(1));
		hm.put("P", new Integer(3));
		hm.put("Q", new Integer(10));
		hm.put("R", new Integer(1));
		hm.put("S", new Integer(1));
		hm.put("T", new Integer(1));
		hm.put("U", new Integer(1));
		hm.put("V", new Integer(4));
		hm.put("W", new Integer(4));
		hm.put("X", new Integer(8));
		hm.put("Y", new Integer(4));
		hm.put("Z", new Integer(10));

		//convert every character in string to uppercase 
		String s = string.toUpperCase();
		int score = 0;
		for(int i = 0; i < string.length(); i++) {
			score += hm.get(Character.toString(s.charAt(i)));
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String cleanNum = "";
		int numCount = 0;

		List<String> str = new ArrayList<>();
		str.add("(");
		str.add(")");
		str.add(" ");
		str.add("-");
		str.add(".");
		str.add("+");

		for(int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				cleanNum += Character.toString(string.charAt(i));
				numCount += 1;

				if(numCount > 11) {
					throw new IllegalArgumentException();
				}

			} else if(!(str.contains(Character.toString(string.charAt(i))))) {
				throw new IllegalArgumentException();
			}
		} 

		return cleanNum;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		String[] words = string.split("\\W+");
		Map<String, Integer> mp = new HashMap<String,Integer>(); 

		for(String word:words) {
			if(!mp.containsKey(word)) {
				mp.put(word, new Integer(1));
			} else {
				mp.put(word, mp.get(word) + 1);
			}
		}

		return mp;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int size = sortedList.size();
			int leftIndex = 0;
			int rightIndex = size - 1;
			int midIndex = 0;

			while(leftIndex <= rightIndex) {
				midIndex = (rightIndex + leftIndex)/2; //used to account for odd and even
				T midValue = sortedList.get(midIndex);

				int result = t.compareTo(midValue);
				if(result == 0) {
					return midIndex;
				} else if(result < 0) {
					rightIndex = midIndex - 1;
				} else{
					leftIndex = midIndex + 1;
				}

			}
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration

		String pigString = ""; 
		ArrayList<String> words = new ArrayList<String>();

		for(String word : string.split(" ")) {
			words.add(word);
		}

		if(words.size() == 1) {
			pigString = toPigLatinAlg(string);
		} 
		else{
			for(int i = 0; i < words.size(); i++) {
				pigString += toPigLatinAlg(words.get(i)) + " ";
			}

			pigString = pigString.trim(); // removes whitespace from both ends of the string
		}

		return pigString;
	}

	//Method that executes an algorithm that turns an english word into Pig Latin
	public String toPigLatinAlg(String string) {
		// TODO Write an implementation for this method declaration
		ArrayList<Character> vowels = new ArrayList<Character>(Arrays.asList('a','e','i','o','u'));
		StringBuilder str = new StringBuilder(string);

		for (int i = 0; i < str.length()-1; i++) {
			if((vowels.contains(str.charAt(0)))) {
				str.append("ay");
				break;

			}
			if((str.charAt(0) == 'q') &&  (str.charAt(1) == 'u')) {
				str.append(Character.toString(str.charAt(0)));
				str.append(Character.toString(str.charAt(1)));
				str.deleteCharAt(0);
				str.deleteCharAt(0);
				str.append("ay");
				break;
			}
			if(!(vowels.contains(str.charAt(i)))) {
				if(!(vowels.contains(str.charAt(i+1)))) {
					str.append(Character.toString(str.charAt(i)));
					str.append(Character.toString(str.charAt(i+1)));
					str.deleteCharAt(i);
					str.deleteCharAt(i);
				}
				if(!(vowels.contains(str.charAt(i))) && vowels.contains(str.charAt(i+1))) {
					str.append(Character.toString(str.charAt(i)));
					str.deleteCharAt(i);
					str.append("ay");
					break;
				}
				else if(vowels.contains(str.charAt(i+1))) {
					str.append("ay");
					break;
				} 
				//str.append(Character.toString(str.charAt(i)));
				//str.deleteCharAt(i);

			} 
		}
		return str.toString();
	}



	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration

		boolean isArm = false;
		String num = Integer.toString(input);
		int numDigits = num.length();
		int sum = 0;

		if(numDigits == 1) {
			isArm = true; //single digit nums are automatically ArgNums
		} else if(numDigits > 1) {
			for(int i = 0; i < numDigits; i++) {
				int digit= Integer.parseInt(String.valueOf(num.charAt(i)));
				sum += Math.pow(digit, numDigits);
			}
			//check if our sum is an ArgNum
			if(sum == input) {
				isArm = true;
			}
		}

		return isArm;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration

		List<Long> primeFactors = new ArrayList<Long>();

		for(long i = 2; i<= l; i++) {
			while(l % i == 0) {
				primeFactors.add(i);
				l /= i;
			}
		}

		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration


			// Map consisting of (1, a) -> (26, z)
			BidiMap<Integer, Character> hm =  new DualHashBidiMap<Integer, Character>(); 

			//Map<Integer, String> hm =  new HashMap<Integer, String>(); 
			hm.put(1, 'a'); 
			hm.put(2, 'b'); 
			hm.put(3, 'c'); 
			hm.put(4, 'd');
			hm.put(5, 'e');
			hm.put(6, 'f');
			hm.put(7, 'g');
			hm.put(8, 'h');
			hm.put(9, 'i');
			hm.put(10, 'j');
			hm.put(11, 'k');
			hm.put(12, 'l');
			hm.put(13, 'm');
			hm.put(14, 'n');
			hm.put(15, 'o');
			hm.put(16, 'p');
			hm.put(17, 'q');
			hm.put(18, 'r');
			hm.put(19, 's');
			hm.put(20, 't');
			hm.put(21, 'u');
			hm.put(22, 'v');
			hm.put(23, 'w');
			hm.put(24, 'x');
			hm.put(25, 'y');
			hm.put(26, 'z');

			StringBuilder str = new StringBuilder(string);


			for(int i= 0; i < string.length(); i++) {
				char stringChar = string.charAt(i);
				char lowStringChar = Character.toLowerCase(stringChar);
				if(!Character.isAlphabetic(stringChar)) {
					str.append("");
				}else {

					int charLocation = hm.getKey(lowStringChar);	

					if(hm.containsValue(stringChar) || hm.containsValue(lowStringChar) ) { 

						if(charLocation + key <= 26) {
							if(stringChar ==  lowStringChar) {
								str.setCharAt(i, hm.get(charLocation + key) );
							} else{
								str.setCharAt(i, Character.toUpperCase(hm.get(charLocation + key)) );
							}


						} else if(charLocation + key > 26) {
							if(stringChar ==  lowStringChar) {
								str.setCharAt(i, hm.get(charLocation + key - 26) );
							} else{
								str.setCharAt(i, Character.toUpperCase(hm.get(charLocation + key - 26)) );
							}

						}

					}

				}

			}

			return str.toString();
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration

		int primeN = 0; // initialize Nth Prime 
		int count = 0; //initialize a counter to track N

		if(i < 1) {
			throw new IllegalArgumentException();
		}
		
		for(int j = 1; j >= 1; j++) {
		    if(isPrime(j)){
		    	count += 1;
		    }
		       

		    if(count == i) {
		        primeN = j;
		        break;
		    }
		}
		

		return primeN;
	}

private boolean isPrime(int k) {
    if(k < 2)
        return false;

    for (int j = 2; j * j <= k; j++) {
        if (k % j == 0)
            return false;
    }
    return true;
}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding "test" gives "gvhg" Decoding "gvhg" gives "test" 
	 * Decoding "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt" gives "thequickbrownfoxjumpsoverthelazydog"
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.replaceAll("[^a-zA-Z0-9]+", "");
			string = string.toLowerCase();
			
			StringBuilder str = new StringBuilder();

			// Map consisting of (1, a) -> (26, z)
			BidiMap<Integer, Character> hm =  new DualHashBidiMap<Integer, Character>(); 
			//Map<Integer, String> hm =  new HashMap<Integer, String>(); 
			hm.put(1, 'a'); 
			hm.put(2, 'b'); 
			hm.put(3, 'c'); 
			hm.put(4, 'd');
			hm.put(5, 'e');
			hm.put(6, 'f');
			hm.put(7, 'g');
			hm.put(8, 'h');
			hm.put(9, 'i');
			hm.put(10, 'j');
			hm.put(11, 'k');
			hm.put(12, 'l');
			hm.put(13, 'm');
			hm.put(14, 'n');
			hm.put(15, 'o');
			hm.put(16, 'p');
			hm.put(17, 'q');
			hm.put(18, 'r');
			hm.put(19, 's');
			hm.put(20, 't');
			hm.put(21, 'u');
			hm.put(22, 'v');
			hm.put(23, 'w');
			hm.put(24, 'x');
			hm.put(25, 'y');
			hm.put(26, 'z');
			
			for(int i= 0; i < string.length(); i++) {
				char stringChar = string.charAt(i);

				if(!Character.isAlphabetic(stringChar)) {
					str.append(stringChar);
				}else {

					int charLocation = hm.getKey(stringChar);	

					if(hm.containsValue(stringChar)) { 
						str.append( hm.get(27 - charLocation) );

					}

				}

			}
			
			String s = str.toString().replaceAll(".....", "$0 ");
			
			return s.trim();
		}


		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration

			string = string.replaceAll(" ", "");

			StringBuilder str = new StringBuilder();

			// Map consisting of (1, a) -> (26, z)
			BidiMap<Integer, Character> hm =  new DualHashBidiMap<Integer, Character>(); 

			//Map<Integer, String> hm =  new HashMap<Integer, String>(); 
			hm.put(1, 'a'); 
			hm.put(2, 'b'); 
			hm.put(3, 'c'); 
			hm.put(4, 'd');
			hm.put(5, 'e');
			hm.put(6, 'f');
			hm.put(7, 'g');
			hm.put(8, 'h');
			hm.put(9, 'i');
			hm.put(10, 'j');
			hm.put(11, 'k');
			hm.put(12, 'l');
			hm.put(13, 'm');
			hm.put(14, 'n');
			hm.put(15, 'o');
			hm.put(16, 'p');
			hm.put(17, 'q');
			hm.put(18, 'r');
			hm.put(19, 's');
			hm.put(20, 't');
			hm.put(21, 'u');
			hm.put(22, 'v');
			hm.put(23, 'w');
			hm.put(24, 'x');
			hm.put(25, 'y');
			hm.put(26, 'z');


			for(int i= 0; i < string.length(); i++) {
				char stringChar = string.charAt(i);

				if(!Character.isAlphabetic(stringChar)) {
					str.append(stringChar);
				}else {

					int charLocation = hm.getKey(stringChar);	

					if(hm.containsValue(stringChar)) { 
						str.append( hm.get(27 - charLocation) );

					}

				}

			}

			return str.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		boolean isI = true;
		string = string.replaceAll("[^a-zA-Z0-9]+", "");
		int len = string.length();
		int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2,1};
		int sum = 0;
		

		
		for(int i = 0; i<len; i++) {
			char stringChar = string.charAt(i);
			if(!Character.isAlphabetic(stringChar)) {
				
				sum += Character.getNumericValue(stringChar) * arr[i];
				
			} else if(Character.isAlphabetic(stringChar) && (i < (len - 1))) {
				isI = false;
				break;
				
			}  else if((i == len - 1) && !(stringChar == 'X')) {
				isI = false;
				break;
				
			} else if(stringChar == 'X' && (i == (len - 1))){
				sum += 10;
		}
				
		}
		if(sum % 11 != 0) {
			isI = false;
		}
		return isI;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replaceAll(" ", "");
		char[] chars = string.toCharArray();
		Map<Character, Integer> mp = new HashMap<Character,Integer>(); 
		
		
		for(char c: chars){
			if(!mp.containsKey(c)) {
				mp.put(c, new Integer(1));
			} else {
				mp.put(c, mp.get(c) + 1);
			}
		}
		

		return mp.size() == 26;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration

		// Test: LocalDate.of(2011, Month.APRIL, 25) = LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40)
		LocalDate birth;
		LocalDateTime moment;
		final long seconds = 1000000000;


		if(given.getClass() == LocalDate.class) {

			birth = (LocalDate) given;
			moment = birth.atStartOfDay();
			return moment.plusSeconds(seconds); 

		} 

		moment = (LocalDateTime) given;
		return moment.plusSeconds(seconds);

	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		int sum = 0;
		
        for (int num = 1; num < i; num++) {
            for (int multiple : set) {
                if (num % multiple == 0) {
                    sum += num;
                    break;
                }
            }
        }
        return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		boolean isLuhn = true;
		
		String invalids = string.replaceAll("[0-9\\s+]","");
		
		int sum = 0;
		
		if(invalids.length() > 0) {
			isLuhn = false;
		} else {
			string = string.replaceAll("[^0-9]", "");
			StringBuilder str = new StringBuilder(string);
			for(int i = 1; i <string.length(); i += 2) {
				char charToDouble = string.charAt(i); // char representation of the digit that  needs to double
				int doubleDig = Integer.parseInt(Character.toString(charToDouble))* 2; // double every other digit (starting from the second digit)
				
				if(doubleDig > 9) {
					int diff = doubleDig - 9;
					char dubChar = Integer.toString(diff).charAt(0); // converted doubled digit to a char
					str.setCharAt(i, dubChar);
				} else {
					char dubChar = Integer.toString(doubleDig).charAt(0);
					str.setCharAt(i, dubChar);
				}
				
			}
			String[] valids = str.toString().split("");
			for(String valid: valids) {
				int digit = Integer.valueOf(valid);
				sum += digit;
			
			}
			if((sum % 10) != 0) {
				isLuhn = false;
			}
			
		}
		
		
		return isLuhn;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		int sol =0;
		String s = string;
		String[] sp = s.split(" ");
		
		if(sp[3].matches("[a-zA-Z]+")) {
			s = s.replace(sp[3], ",");
		}
		
		s = s.replaceAll("[^\\d-,]", "");
		List<String> in = new ArrayList<String>(Arrays.asList(s.split(",")));
		
		if (string.contains("plus")) {
			sol += Integer.valueOf(in.get(0)) + Integer.valueOf(in.get(1));
		}
		
		if (string.contains("minus")) {
			sol += Integer.valueOf(in.get(0)) - Integer.valueOf(in.get(1));
		}
		
		if (string.contains("multiplied by")) {
			sol += Integer.valueOf(in.get(0)) * Integer.valueOf(in.get(1));
		}
		
		if (string.contains("divided by")) {
			sol += Integer.valueOf(in.get(0)) / Integer.valueOf(in.get(1));
		}

		//System.out.println(sol);
		
		
		return sol;
	}

}
