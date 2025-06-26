package org.example;

import java.util.*;

public class SentenceWordAnalyzer {

    public static int maxSentencesWithSameWord(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] sentences = text.split("[.!?]+");

        Map<String, Set<Integer>> wordSentenceMap = new HashMap<>();

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].toLowerCase();

            String[] words = sentence.split("\\W+");

            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

            for (String word : uniqueWords) {
                if (word.isEmpty()) continue;

                wordSentenceMap
                        .computeIfAbsent(word, k -> new HashSet<>())
                        .add(i);
            }
        }

        int maxCount = 0;
        for (Set<Integer> sentenceSet : wordSentenceMap.values()) {
            if (sentenceSet.size() > maxCount) {
                maxCount = sentenceSet.size();
            }
        }

        return maxCount;
    }
}