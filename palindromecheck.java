import java.util.Scanner;

public class palindromecheck {
    public static void main(String[] args) {
        // Create a new Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Loop until the user enters the exit command
        while (true) {
            // Prompt the user to enter a string
            System.out.println("Enter a word, phrase or sentence to check if it's a palindrome (type 'exit' to quit):");

            // Read the user's input as a string
            String input = scanner.nextLine();

            // If the user types "exit", break the loop and end the program
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Clean the input string by removing non-alphanumeric characters and converting to lowercase
            String cleanedInput = cleanInput(input);

            // Check if the cleaned input is a palindrome using the recursive function isPalindrome
            if (isPalindrome(cleanedInput, 0, cleanedInput.length() - 1)) {
                // If it is a palindrome, print the message
                System.out.println("\"" + input + "\" is a palindrome.");
            } else {
                // If it is not a palindrome, print the message
                System.out.println("\"" + input + "\" is not a palindrome.");
            }
        }

        // Close the scanner object to prevent resource leaks
        scanner.close();
    }

    // This function removes all non-alphanumeric characters from the input string and converts it to lowercase
    public static String cleanInput(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // This recursive function checks if the input string is a palindrome
    public static boolean isPalindrome(String input, int start, int end) {
        // Base case: If start and end pointers cross or are equal, the string is a palindrome
        if (start >= end) {
            return true;
        }

        // If the characters at the start and end pointers are not equal, the string is not a palindrome
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursively call isPalindrome with updated start and end pointers (increment start, decrement end)
        return isPalindrome(input, start + 1, end - 1);
    }
}


