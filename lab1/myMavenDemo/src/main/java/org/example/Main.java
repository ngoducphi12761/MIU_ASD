package org.example;

import java.util.Scanner;

public class Main {

    // Decipher function to decode the encrypted message using a known word in the original text
    public static String decipher(String ciphertext, String knownWord) {
        // Split the ciphertext into words
        String[] cipherWords = ciphertext.split(" ");

        // Initialize an empty string to store the decrypted text
        String originalText = "";

        // Check each word in the ciphertext to find a possible match for the known word
        for (String cipherWord : cipherWords) {
            // If the current word length matches the known word length, it could be a match
            if (cipherWord.length() == knownWord.length()) {
                // Calculate the shift by comparing the first letters of the known word and cipher word
                int shift = (cipherWord.charAt(0) - knownWord.charAt(0) + 26) % 26;

                // Apply this shift to the entire ciphertext to decode it
                originalText = decodeWithShift(ciphertext, shift);

                // Check if the decoded text contains the known word; if yes, we found the answer
                if (originalText.contains(knownWord)) {
                    return originalText;
                }
            }
        }

        // If no valid shift produces the known word in the plaintext, return "Invalid"
        return "Invalid";
    }

    // Helper function to decode the entire string with a given shift value
    public static String decodeWithShift(String text, int shift) {
        StringBuilder decodedText = new StringBuilder();

        // Loop through each character in the text
        for (char ch : text.toCharArray()) {
            // Check if the character is an uppercase letter
            if (ch >= 'A' && ch <= 'Z') {
                // Shift within uppercase range, wrapping around if necessary
                char decodedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                decodedText.append(decodedChar);
            }
            // Check if the character is a lowercase letter
            else if (ch >= 'a' && ch <= 'z') {
                // Shift within lowercase range, wrapping around if necessary
                char decodedChar = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                decodedText.append(decodedChar);
            }
            // If it's not a letter, just add the character as is
            else {
                decodedText.append(ch);
            }
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: ciphertext and known word
        String ciphertext = scanner.nextLine();
        String knownWord = scanner.nextLine();

        // Get the result from the decipher function
        String result = decipher(ciphertext, knownWord);

        // Output the result
        System.out.println(result);
    }
}