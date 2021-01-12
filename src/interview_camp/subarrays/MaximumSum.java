package interview_camp.subarrays;

public class MaximumSum {

    /**
     * [-2,-3,4,-1,-2,1,5,-1]
     * 
     * * at every point need to consider whether it would be better to try to extend
     * the existing subarray or start new here * Keep track of max sum seen and
     * start and end
     * 
     * [-2]
     * 
     * [-3]
     * 
     * [4]
     * 
     * [4,-1]
     * 
     */
    private static int[] maximumSum(int[] nums) {
        int maxStart = 0;
        int maxEnd = 0;
        int maxSum = nums[0];

        int currentStart = 0;
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxSum + nums[i]) {
                currentSum = nums[i];
                currentStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxStart = currentStart;
                maxEnd = i;
                maxSum = currentSum;
            }
        }

        return new int[] { maxStart, maxEnd, maxSum };

    }

    public static void main(String[] args) {
        int[] result = maximumSum(new int[] { 1, 2, -1, 2, -3, 2, -5 });

        System.out.println("Sum start index: " + result[0]);
        System.out.println("Sum end index: " + result[1]);
        System.out.println("Sum: " + result[2]);

    }

}
