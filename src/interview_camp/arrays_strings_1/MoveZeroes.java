package interview_camp.arrays_strings_1;

import java.util.Arrays;

public class MoveZeroes {

    private static void moveZeroes(int[] nums) {
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, zeroes);
                zeroes++;
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = new int[] { 4, 2, 0, 1, 0, 30 };
        moveZeroes(nums);

        Arrays.stream(nums).forEach(i -> System.out.print(i + ","));
        System.out.println();

    }
}
