package interview_camp.subarrays;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {

    /**
     * [2,4,-2,1,-3,5,-3]
     * 
     * [2,6,4,5,2,7,4]
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int[] prefixSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int sum = 0;
        Map<Integer, Integer> sumPosMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == target) {
                return new int[] { 0, i };
            }
            
            if (sumPosMap.containsKey(sum - target)) {
                return new int[] { sumPosMap.get(sum - target) + 1, i };
            }
            sumPosMap.put(sum, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = prefixSum(new int[] { 2, 4, -2, 1, -3, 5, -3 }, 5);
        System.out.println(result[0] + " , " + result[1]);
    }
}
