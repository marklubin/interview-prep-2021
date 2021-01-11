package interview_camp.arrays_strings_1;

public class UnsortedSubarray {

    /**
     * Q: What form should the output take? Pair of indicies
     * 
     * Example
     * 
     * [1,2,4,5,3,5,6,7] -> [4,5,3]
     * 
     * [1,2,4,5,3,5,6,7]
     * 
     * 
     * * Scan forward, find first dip * Scan backwards, find first bump * take the
     * min and max the numbers between the bump and expand
     * 
     */

    private static int[] unsortedSubarray(int nums[]) {
        int start = 0;

        // find the first dip
        while (start + 1 < nums.length && nums[start] <= nums[start + 1]) {
            start++;
        }

        // already sorted
        if (start == nums.length - 1) {
            return new int[] { -1, -1 };
        }

        int end = nums.length - 1;

        // find the first bump
        while (start - 1 > 0 && nums[end] >= nums[end - 1]) {
            end--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        while (start - 1 > 0 && nums[start - 1] >= min) {
            start--;
        }

        while (end + 1 <= nums.length && nums[end + 1] <= max) {
            end++;
        }

        return new int[] { start, end };

    }

    public static void main(String[] args) {
        int[] result = unsortedSubarray(new int[] { 0, 2, 3, 1, 8, 6, 9 });
        System.out.println(result[0] + " , " + result[1]);

        result = unsortedSubarray(new int[] { 1, 2, 3 });
        System.out.println(result[0] + " , " + result[1]);

        result = unsortedSubarray(new int[] { 1, 2, 4, 5, 3, 7, 5, 6, 8 });
        System.out.println(result[0] + " , " + result[1]);

    }

}
