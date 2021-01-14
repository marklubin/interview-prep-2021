package interview_camp.binary_search;

public class PeakSearch {


    /*
     * Find an element where adjacent elements are smaller
     * Edges of the array are consider to be -inf
     * No duplicates

     * [1,3,4,5,2]
     * At each stage go in the direction of the larger the element, since it guarentees that there must be a peak on
     * that side, since either that adjacent element is the largest element in that subarray(peak), or there is a larger
     * that will be the peak
     *
     *
     * [5,3,1]
     *
     * # Iter 1
     *
     * start =0
     * end = 2
     *
     * mid = 1
     * num[mid] = 3
     *
     * end = mid - 1 = 0
     *
     * # Iter 2
     *
     * start = 0
     * end = 0
     * mid = 0
     * nums[mid] = 5
     */
    private static int peak(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (mid == 0 || nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(peak(new int[]{1, 3, 4, 5, 2}));
        System.out.println(peak(new int[]{5, 3, 1}));
        System.out.println(peak(new int[]{1, 3, 5}));

    }
}
