package no.finn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnagramFinderTest {

    @Test
    public void sortedAlphabetically() throws Exception {
        String word = "aBc";
        assertEquals("abc", AnagramFinder.sortWord(word));
    }

    @Test
    public void sortFinalStringShouldNotAttemptToMutate() throws Exception {
        final String word = "daBc";
        assertEquals("abcd", AnagramFinder.sortWord(word));

    }
}
