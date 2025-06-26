package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    @Test
    public void testBasic() {
        String text = "Java is Java. java JAVA!";
        int result = WordCounter.countWordOccurrences(text, "java");
        assertEquals(4, result);
    }

    @Test
    public void testNoOccurrences() {
        assertEquals(0, WordCounter.countWordOccurrences("Hello world", "python"));
    }

    @Test
    public void testEmptyInputs() {
        assertEquals(0, WordCounter.countWordOccurrences(null, "word"));
        assertEquals(0, WordCounter.countWordOccurrences("text", null));
        assertEquals(0, WordCounter.countWordOccurrences("text", ""));
    }
}
