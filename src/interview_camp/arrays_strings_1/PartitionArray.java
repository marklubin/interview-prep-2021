package interview_camp.arrays_strings_1;

import java.util.Arrays;

import interview_camp.Utils;

public class PartitionArray {

    private static void partition(int[] nums) {

        int zeroes = 0;
        int twos = nums.length - 1;

        int i = 0;

        while (i <= twos) {
            if (nums[i] == 0) {
                Utils.swap(nums, zeroes, i);
                zeroes++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                Utils.swap(nums, i, twos);
                twos--;

            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, 1, 2, 1, 0, 1, 2 };
        partition(nums);
        Arrays.stream(nums).forEach(i -> System.out.println(i));
    }

}
