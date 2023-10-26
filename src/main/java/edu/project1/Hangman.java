package edu.project1;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static Scanner input;

    public static void hangman() {
        input = new Scanner(System.in);

        String[] words = {"engine", "system", "advertising",
            "department", "activity", "food", "control",
            "recipe", "emotion", "bathroom", "version"};

        Random random = new Random();
        int rand = random.nextInt(words.length);

        String word = (words[rand]);
        word = word.toLowerCase();

        String starWord = word.replaceAll("[a-z]", "*");

        System.out.println("The word: " + starWord + "\n");

        startGame(word, starWord);
    }

    public static void startGame(String word, String starWord) {
        int mistakes = 0;
        String guess;
        char letter;
        boolean alreadyGuess = false;
        StringBuilder guesses = new StringBuilder();
        boolean letterInWord;

        while (mistakes < 5 && starWord.contains("*")) {
            System.out.print("Guess a letter: ");
            guess = input.nextLine().toLowerCase();
            if (guess.length() > 1) {
                System.out.println("Letter more than 1 symbol");
                continue;
            }

            letter = guess.charAt(0);
            alreadyGuess = (guesses.toString().indexOf(letter)) != -1;
            guesses.append(letter);
            System.out.println();

            if (alreadyGuess) {
                System.out.println("You ALREADY guessed " + letter + ". \n");
                continue;
            }
            if (letter == '0') {
                System.out.println("END GAME");
                System.out.println("The word was " + word);
                return;
            }

            letterInWord = (word.indexOf(letter)) != -1;

            if (letterInWord) {
                System.out.println("Hit!");
                System.out.print("\n");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter && starWord.charAt(i) != letter) {
                        starWord = starWord.substring(0, i) + letter + starWord.substring(i + 1);
                    }
                }
            } else {
                mistakes++;
                System.out.println("Missed, mistake " + mistakes + " out of 5.\n");
            }
            System.out.println("The word: " + starWord + "\n");
        }

        if (mistakes == 5) {
            System.out.println("YOU LOST!");
        } else {
            System.out.print("YOU WON!");
        }
    }

    public static void main(String[] args) {
        hangman();
    }
}
