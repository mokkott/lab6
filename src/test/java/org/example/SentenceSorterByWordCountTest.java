package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SentenceSorterByWordCountTest {
    @Test
    public void testSimpleText() {
        String text = "Hi there. This is a longer sentence. Short one!";
        List<String> result = SentenceSorterByWordCount.sortSentencesByWordCount(text);
        assertEquals("Hi there.", result.get(0));
        assertEquals("Short one!", result.get(1));
        assertEquals("This is a longer sentence.", result.get(2));
    }

    @Test
    public void testEmpty() {
        assertTrue(SentenceSorterByWordCount.sortSentencesByWordCount("").isEmpty());
        assertTrue(SentenceSorterByWordCount.sortSentencesByWordCount(null).isEmpty());
    }

    @Test
    public void testSameLength() {
        String text = "One two three. Four five six. Seven eight nine.";
        List<String> result = SentenceSorterByWordCount.sortSentencesByWordCount(text);
        assertEquals(3, result.size());
    }
}
