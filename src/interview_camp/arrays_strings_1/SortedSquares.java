package interview_camp.arrays_strings_1;

import java.util.Arrays;

public class SortedSquares {

    /**
     * * Have pointer at start and end and put in the number with the greater
     * absolute value, decrement the the other pointer * need to fill the target
     * array from right to left stop once start > end
     * 
     * [-2,0,3]
     *  
     * start = 0
     * end = 5
     * 
     * [-4, -2, -1, 0, 3 ,5]
     * 
     * 
     * 
     * 
     */
    private static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;
        int i = nums.length - 1;

        while (start <= end) {
            if ((nums[start] * nums[start]) >= (nums[end] * nums[end])) {
                result[i--] = nums[start] * nums[start];
                start++;
            } else {
                result[i--] = nums[end] * nums[end];
                end--;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Arrays.stream(sortedSquares(new int[] { -4, -2, -1, 0, 3, 5, 7 })).forEach(i -> System.out.println(i));
    }

}