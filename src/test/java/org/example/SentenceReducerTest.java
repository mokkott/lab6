package org.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SentenceReducerTest {
    @Test
    public void testReduce_withConnectedSentences() {
        String text = "Java is great. Programming in Java is fun. I love programming.";
        List<String> result = SentenceReducer.reduce(text);

        // Ожидаем, что все предложения связаны через слова "java", "programming"
        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(s -> s.toLowerCase().contains("java is great")));
        assertTrue(result.stream().anyMatch(s -> s.toLowerCase().contains("programming in java")));
        assertTrue(result.stream().anyMatch(s -> s.toLowerCase().contains("i love programming")));
    }

    @Test
    public void testReduce_withDisconnectedSentences() {
        String text = "Cats are cute. Dogs are loyal. Java is powerful.";
        List<String> result = SentenceReducer.reduce(text);

        assertEquals(1, result.size());

        assertTrue(
                result.get(0).toLowerCase().contains("cats are cute") ||
                        result.get(0).toLowerCase().contains("dogs are loyal") ||
                        result.get(0).toLowerCase().contains("java is powerful")
        );
    }

    @Test
    public void testReduce_withPartialOverlap() {
        String text = "I like apples. Apples are tasty. Dogs bark loudly. I like dogs.";
        List<String> result = SentenceReducer.reduce(text);

        assertEquals(2, result.size());

        boolean group1 = result.stream().anyMatch(s -> s.toLowerCase().contains("i like apples")) &&
                result.stream().anyMatch(s -> s.toLowerCase().contains("apples are tasty"));
        boolean group2 = result.stream().anyMatch(s -> s.toLowerCase().contains("dogs bark loudly")) &&
                result.stream().anyMatch(s -> s.toLowerCase().contains("i like dogs"));

        assertTrue(group1 || group2);
    }

    @Test
    public void testReduce_emptyText() {
        String text = "";
        List<String> result = SentenceReducer.reduce(text);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testReduce_nullText() {
        List<String> result = SentenceReducer.reduce(null);
        assertTrue(result.isEmpty());
    }
}
