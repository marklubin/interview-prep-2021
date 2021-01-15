package interview_camp.recursion_backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

    private static void printPermutationsAux(int[] nums, int[] buffer, Set<Integer> used, int index) {
        if (index >= buffer.length) {
            printBuffer(buffer);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                buffer[index] = nums[i];
                printPermutationsAux(nums, buffer, used, index + 1);
                used.remove(i);
            }
        }
    }

    private static void printBuffer(int[] buffer) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(buffer).forEach(i -> sb.append(i + ","));
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }

    private static void printPermutations(int[] nums, int length) {
        int[] buffer = new int[length];
        Set<Integer> used = new HashSet<>();

        printPermutationsAux(nums, buffer, used, 0);
    }


    public static void main(String[] args) {
        printPermutations(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

    }
}
