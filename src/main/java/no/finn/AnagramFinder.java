package no.finn;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class AnagramFinder {

    public static final String FILE_PATH = "src/main/resources/eventyr.txt";

    public static void main(String... args) throws IOException {
        final HashMap<String, List<String>> anagramMap = new HashMap<>();
        Files.lines(Paths.get(FILE_PATH)).forEach(word -> addToMap(word, anagramMap));
        anagramMap.values().stream()
                .filter(anagrams -> anagrams.size() > 1)
                .forEach(AnagramFinder::print);
    }

    private static void print(List<String> anagrams) {
        anagrams.stream().forEach(anagram -> System.out.print(anagram + " "));
        System.out.println("\n");
    }

    private static void addToMap(String word, HashMap<String, List<String>> anagramMap) {
        String key = sortWord(word);
        List<String> anagrams = anagramMap.get(key);
        if (anagrams == null) {
            anagramMap.put(key, new ArrayList<>(Arrays.asList(word)));
        } else {
            anagrams.add(word);
        }
    }

    public static String sortWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
