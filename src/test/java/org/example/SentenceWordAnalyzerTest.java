package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceWordAnalyzerTest {
    @Test
    public void testBasic() {
        String text = "Hello world. Hello there! World is big. Hello again?";
        int result = SentenceWordAnalyzer.maxSentencesWithSameWord(text);
        assertEquals(3, result);
    }

    @Test
    public void testEmptyText() {
        assertEquals(0, SentenceWordAnalyzer.maxSentencesWithSameWord(""));
        assertEquals(0, SentenceWordAnalyzer.maxSentencesWithSameWord(null));
    }

    @Test
    public void testSingleSentence() {
        String text = "Only one sentence here.";
        assertEquals(1, SentenceWordAnalyzer.maxSentencesWithSameWord(text));
    }
}
