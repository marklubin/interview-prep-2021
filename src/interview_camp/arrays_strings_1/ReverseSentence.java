package interview_camp.arrays_strings_1;

public class ReverseSentence {

    private static int getWordLength(String s, int start) {
        int wordLength = 0;
        int i = start;

        while (i < s.length() && s.charAt(i) != ' ') {
            wordLength++;
            i++;
        }

        return wordLength;
    }

    /**
     * "i live in a house" -> "house a in live i"
     * 
     * Keep a pointer a the end of where to put next char Keep pointer to currently
     * processing if char is space, then insert space at end, decrement end,
     * increment processing if char is not space scan forward to end of word(until
     * not space), insert chars backwards, decrement end, scan forward past all
     * chars
     * 
     */
    private static String reverseSentence(String s) {

        char[] reversed = new char[s.length()];
        int cursor = 0;
        int end = s.length() - 1;

        while (cursor <= s.length() - 1) {
            if (s.charAt(cursor) == ' ') {
                reversed[end] = ' ';
                end--;
                cursor++;
            } else {
                int wordLength = getWordLength(s, cursor);

                for (int i = cursor + wordLength - 1; i >= cursor; i--) {
                    reversed[end] = s.charAt(i);
                    end--;
                }
                cursor += wordLength;
            }

        }

        return new String(reversed);
    }

    public static void main(String[] args) {

        System.out.println(reverseSentence("i live in a house"));

    }

}
