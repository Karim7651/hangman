package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) throws Exception {
        int lives = 5;
        boolean winCheck = false;
        Scanner scan = new Scanner(System.in);
        //randomly pick a word and add it to arraylist & get a random word , store it in hiddenWord
        File dictionary = new File("C:\\Users\\Kimo Store\\IdeaProjects\\hangman\\src\\com\\company\\dictionary.txt");
        Scanner wordScanner = new Scanner(dictionary);
        ArrayList<String> words = new ArrayList<>();
        while (wordScanner.hasNextLine()) {
            words.add(wordScanner.nextLine());
        }
        String hiddenWord = words.get((int) (Math.random() * words.size()));
        // convert word to an array of chars
        char[] charArray = hiddenWord.toCharArray(); // char array of word
        char[] userAnswers = new char[charArray.length];

        // assign every index in userAnswers to *
        for (int i = 0; i < userAnswers.length; i++) {
            userAnswers[i] = '*';
        }
        while (lives > 0) {
            boolean found = false;
            System.out.println("Enter a letter");
            String letter = scan.next();
            // check if the letter is in the word
            for (int i = 0; i < userAnswers.length; i++) {
                if (letter.charAt(0) == charArray[i]) {
                    userAnswers[i] = charArray[i];
                    found = true;
                }
            }
            if (!found) {
                lives = lives - 1;
                System.out.println("you Guessed the wrong letter!");
            } else {
                System.out.println("You guessed the right letter");
            }
            System.out.println("The number of remaining lives is " + lives);
            // win check
            winCheck = true;
            for (int i = 0; i < userAnswers.length; i++) {
                if (userAnswers[i] == '*') {
                    winCheck = false;
                    break;
                }
            }
            if (winCheck) {
                System.out.println();
                System.out.println("You Won!");
                System.out.println(new String(charArray));
                return;
            }
            // give user feed back (word)
            System.out.println(new String(userAnswers));
            System.out.println("\n_______________________________________________");

        }
        System.out.println("\nThe correct word is " + hiddenWord);
        System.out.println("You Lost!");
    }
}

