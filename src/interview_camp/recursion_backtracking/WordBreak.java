package interview_camp.recursion_backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {

    private static final Set<String> WORDS = Set.of("i", "like", "mango", "tango", "man", "go", "tan");

    /**
     * * Find a word starting at the current char
     * * Put that word into list, and try to find word starting on next character
     * * If reach end of input string we know we have successful filled array, otherwise try next char up to end and move on
     */
    private static final boolean wordBreakAux(int startChar, LinkedList<String> words, String s) {
        if (startChar == s.length()) {
            return true;
        }


        for (int i = startChar; i < s.length(); i++) {
            String word = s.substring(startChar, i + 1);
            if (WORDS.contains(word)) {
                words.addLast(word);

                boolean isResult = wordBreakAux(i + 1, words, s);

                if (isResult) {
                    return true;
                }
                words.removeLast();
            }
        }
        return false;

    }

    private static final List<String> wordBreak(String s) {
        LinkedList<String> words = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        if (wordBreakAux(0, words, s)) {
            return words;
        }

        return null;
    }


    public static void main(String[] args) {
        List<String> result = wordBreak("ilikemangotango");

        if (result == null) {
            System.out.println("No solution");
            return;
        }
        result.forEach(System.out::println);
    }
}
