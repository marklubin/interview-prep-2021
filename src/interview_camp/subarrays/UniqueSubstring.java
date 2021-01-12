package interview_camp.subarrays;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstring {

    /**
     * Move forward through the string Keep track of longest substring with all
     * unique chars ending at the current index Keep moving forward the beginning of
     * the current substring to accomodate the current character Check if the
     * current substring is the longest
     *
     */
    private static String longestSubstring(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int startLongest = 0;
        int endLongest = 0;
        int startCurrent = 0;
        Set<Character> currentChars = new HashSet<>();

        currentChars.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            Character character = s.charAt(i);

            if (currentChars.contains(character)) {
                while (currentChars.contains(character)) {
                    currentChars.remove(s.charAt(startCurrent));
                    startCurrent++;
                }
            }

            currentChars.add(character);

            if (i - startCurrent + 1 > endLongest - startLongest + 1) {
                startLongest = startCurrent;
                endLongest = i;
            }
        }

        return s.substring(startLongest, endLongest + 1);

    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("whatwhywhere"));

    }

}
