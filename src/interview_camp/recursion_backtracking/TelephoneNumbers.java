package interview_camp.recursion_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class TelephoneNumbers {

    static Map<Integer, Character[]> NUM_MAP = Map.of(
            0, new Character[]{},
            1, new Character[]{},
            2, new Character[]{'A', 'B', 'C'},
            3, new Character[]{'D', 'E', 'F'},
            4, new Character[]{'G', 'H', 'I'},
            5, new Character[]{'J', 'K', 'L'},
            6, new Character[]{'M', 'N', 'O'},
            7, new Character[]{'P', 'Q', 'R', 'S'},
            8, new Character[]{'T', 'U', 'V'},
            9, new Character[]{'W', 'X', 'Y', 'Z'}
    );

    /*

        At each position:
        * Base case is that the index is equal to the buffer length
        * Find the digit at that position
         * Look up the corresponding character array
         * For each character in that array insert
         * Recurse on the next index
     */
    private static void telephoneNumbersAux(int[] number, char[] buffer, int numberIndex, int bufferIndex) {
        if (numberIndex >= number.length) {
            System.out.println(buffer);
            return;
        }

        int digit = number[numberIndex];

        Character[] characters = NUM_MAP.get(digit);

        //If no mapping character, go to next digit w/o incrementing buffer
        if (characters.length == 0) {
            telephoneNumbersAux(number, buffer, numberIndex + 1, bufferIndex);
            return;
        }

        for (Character c : characters) {
            buffer[bufferIndex] = c;
            telephoneNumbersAux(number, buffer, numberIndex + 1, bufferIndex + 1);
        }
    }

    private static int[] numberAsArray(int number) {
        LinkedList<Integer> numberList = new LinkedList<>();

        int next_num = number;

        while (next_num != 0) {
            int digit = next_num % 10;
            numberList.addFirst(digit);
            next_num /= 10;
        }

        return numberList.stream().mapToInt(Integer::intValue).toArray();

    }

    private static void telephoneNumbers(int number) {
        int[] number_array = numberAsArray(number);
        char[] buffer = new char[number_array.length];
        telephoneNumbersAux(number_array, buffer, 0, 0);
    }


    public static void main(String[] args) {
        telephoneNumbers(120);


    }
}
