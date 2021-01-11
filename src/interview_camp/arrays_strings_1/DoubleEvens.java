package interview_camp.arrays_strings_1;

import java.util.Arrays;

public class DoubleEvens {

    /**
     * [2,4,1,0,3,0,0,0] -> [2,2,4,4,1,0,3]
     * 
     * @param nums
     */

    private static void doubleEvens(int[] nums, int numsEnd) {
        int end = nums.length;

        for (int i = numsEnd; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                nums[end - 1] = nums[i];
                nums[end - 2] = nums[i];
                end -= 2;
            } else {
                nums[end - 1] = nums[i];
                end--;
            }
        }
    }

    public static void main(String[] Strings) {
        int[] nums = new int[] { 2, 4, 1, 0, 3, 0, 0, 0 };
        doubleEvens(nums, 4);

        Arrays.stream(nums).forEach(i -> System.out.print(i));
        System.out.println();

    }
}
