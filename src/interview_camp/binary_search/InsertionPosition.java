package interview_camp.binary_search;

public class InsertionPosition {


    /*          0 1 2 3 4 5 6
        nums = [1,2,4,4,5,6,8] , target = 4

        start = 0
        end =  6

        # First Loop

        mid = 3


     */
    private static int insertionPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //Beginning of array
            if (mid == 0 && nums[mid] > target) {
                return 0;
            }

            //End of array
            if (mid == nums.length - 1 && nums[nums.length - 1] <= target) {
                return nums.length;
            }

            if (mid > 0 && nums[mid] > target && nums[mid - 1] <= target) {
                return mid;
            }

            if (nums[mid] <= target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(insertionPosition(new int[]{1, 2, 4, 4, 5, 6, 8}, 4));
        System.out.println(insertionPosition(new int[]{1, 2, 4, 4, 5, 6, 8}, 3));
        System.out.println(insertionPosition(new int[]{1, 2, 4, 4, 5, 6, 8}, 0));

    }
}
