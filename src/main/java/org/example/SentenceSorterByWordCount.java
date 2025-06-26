package org.example;

import java.util.*;

public class SentenceSorterByWordCount {
    public static List<String> sortSentencesByWordCount(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }

        String[] sentences = text.split("(?<=[.!?])\\s*");

        List<String> sentenceList = new ArrayList<>(Arrays.asList(sentences));

        sentenceList.sort(Comparator.comparingInt(s -> countWords(s)));

        return sentenceList;
    }

    private static int countWords(String sentence) {
        String[] words = sentence.trim().split("\\W+");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
