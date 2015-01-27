package no.finn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramFinder {

    public static final String FILE_PATH = "src/main/resources/eventyr.txt";
    private static HashMap<String, List<String>> anagramMap;

    public static void main(String... args) throws IOException {
        anagramMap = new HashMap<>();

        Files.lines(Paths.get(FILE_PATH)).forEach(AnagramFinder::addToMap);
        anagramMap.values().stream()
                .filter(anagrams -> anagrams.size() > 1)
                .forEach(AnagramFinder::print);
    }

    private static void print(List<String> anagrams) {
        anagrams.stream().forEach(anagram -> System.out.print(anagram + " "));
        System.out.println("\n");
    }

    private static void addToMap(String word) {
        String key = sortWord(word);
        List<String> strings = anagramMap.get(key);
        if (strings == null) {
            anagramMap.put(key, Arrays.asList(word));
        } else {
            ArrayList<String> copy = new ArrayList<>(strings);
            copy.add(word);
            anagramMap.put(key, copy);
        }
    }

    public static String sortWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
