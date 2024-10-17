public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        /*
        LeetCode 209
        Given an array of positive integers nums and a positive integer target
        return the minimal length of a subarray whose sum is greater than or
        equal to target. If there is no such subarray, return 0 instead.

        Example:
        Input: target = 7, nums = [2, 3, 1, 2, 4, 3]
        Output: 2, because of subarray [4, 3]
         */
        int i = 0, sum = 0, subL = 0, result = Integer.MAX_VALUE;
        for (int j = 0; j <= nums.length - 1; j++) {
            sum += nums[j];
            while (sum >= target) {
                subL = j - i + 1;
                result = Integer.min(result, subL);
                sum -= nums[i];
                i++;
            }
        }
        if (result < Integer.MAX_VALUE) {
            return result;
        } return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int res = minSubArrayLen(4, nums);
        System.out.println(res);
    }
}
