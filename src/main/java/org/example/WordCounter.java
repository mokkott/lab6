package org.example;

public class WordCounter {
    public static int countWordOccurrences(String text, String word) {
        if (text == null || word == null || word.isEmpty()) {
            return 0;
        }

        int count = 0;
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();

        int index = 0;
        while ((index = lowerText.indexOf(lowerWord, index)) != -1) {
            count++;
            index += lowerWord.length();
        }

        return count;
    }
}
