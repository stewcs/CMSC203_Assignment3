
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		boolean boundary = false; // initialize to false 

		for (int i = 0; i < plainText.length(); i++){ // loop through the string

		if (plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE) // check each char to be in ASCII bounds

		boundary = true; // if test passes, boundary true.

		}

		return boundary; // returns result

		}

	
	
	
	
	
	
	
	
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		String encryptedText = ""; // create string to hold the final result

		if (isStringInBounds(plainText)){ // make sure passed string is in bounds

		for (int i = 0; i < plainText.length(); i++){ // // cycle string

		char encryptChar = plainText.charAt(i); // hold current char to be encrypted

		int encryptCharDone = ((int)encryptChar + key); // offset

		while (encryptCharDone > UPPER_RANGE){

			encryptCharDone -= RANGE;

		}

		encryptedText += (char)encryptCharDone; // encrypted char added to final string

		}

		}
		
		else { 
			
			System.out.println("The selected string is not in bounds, Try again."); 
		
		}

		return encryptedText;

		}
	
	
	
	
	
	
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		
		String encryptedText = "";

		int bellasoStrLength = bellasoStr.length();

		for (int i = 0; i < plainText.length(); i++){ // loop through text

		char encryptChar = plainText.charAt(i);

		int encryptedCharDone = ((int)encryptChar + (int)bellasoStr.charAt(i%bellasoStrLength)); // key encrypt

		while (encryptedCharDone > (int)UPPER_RANGE){

		encryptedCharDone -= RANGE;

		}

		encryptedText += (char)encryptedCharDone;

		}

		return encryptedText;

		}
	
	
	
	
	
	
	
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		
		String decryptedText = "";

		for (int i = 0; i < encryptedText.length(); i++){ // loop through text

		char decryptChar = encryptedText.charAt(i);

		int decryptedCharDone = ((int)decryptChar - key); // key decrypt

		while (decryptedCharDone < LOWER_RANGE){

			decryptedCharDone += RANGE;

		}

		decryptedText += (char)decryptedCharDone;

		}

		return decryptedText;

		}
	
	
	
	
	
	
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		
		String decryptedText = "";

		int bellasoStrLength = bellasoStr.length();

		for (int i = 0; i < encryptedText.length(); i ++){ // loop through text

		char decryptChar = encryptedText.charAt(i);

		int decryptedCharDone = ((int)decryptChar - (int)bellasoStr.charAt(i%bellasoStrLength)); // key decrypt

		while (decryptedCharDone < (int)LOWER_RANGE){

			decryptedCharDone += RANGE;

		}

		decryptedText += (char)decryptedCharDone;

		}

		return decryptedText;
	}
	
	
	public static void main(String[] args) {
		String encode = caesarEncryption("Testing this cipher", 5);
		System.out.println(encode);
		String decode = caesarDecryption(encode, 5);
		System.out.println(decode);
	}
	
	
}
