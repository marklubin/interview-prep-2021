package interview_camp.binary_search;

public class BinarySearch {


    /**
     * [1,2,4,7,8,9]
     * <p>
     * start = 0
     * end = 5
     * mid = 2
     */
    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 4, 7, 8, 9}, 3));
    }
}
