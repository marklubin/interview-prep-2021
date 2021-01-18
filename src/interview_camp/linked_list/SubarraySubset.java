package interview_camp.linked_list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubarraySubset {

    private static LinkedList<String> subarraySubset(Set<String> words, String[] document) {

        LinkedList<String> subset = new LinkedList<>();
        HashMap<String, Integer> wordCounts = new HashMap<>();
        LinkedList<String> result = null;
        int matchedWords = 0;

        for (String s : document) {
            subset.addLast(s);

            //Record that we have found this word
            if (words.contains(s)) {
                wordCounts.put(s, wordCounts.getOrDefault(s, 0) + 1);
                if (wordCounts.get(s) == 1) {
                    matchedWords++;
                }
            }

            //remove any extra words from beginning of list
            while (subset.size() > 0) {
                String firstWord = subset.getFirst();
                if (!words.contains(firstWord)) {
                    subset.removeFirst();
                } else if (wordCounts.get(firstWord) > 1) {
                    subset.removeFirst();
                    wordCounts.put(firstWord, wordCounts.get(firstWord) - 1);
                } else {
                    break;
                }
            }

            //See if this is best result which we have seen
            if (matchedWords == words.size() && (result == null || subset.size() < result.size())) {
                result = new LinkedList<>(subset);
            }
        }
        return result;

    }


    public static void main(String[] args) {
        Set<String> words = Set.of("and", "of", "one");
        String doc = "and consisting of a main clause and sometimes one or more subordinate clauses";
        LinkedList<String> result = subarraySubset(words, doc.split(" "));
        if (result == null) {
            System.out.println("No result.");
        } else {
            result.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }
}
