import java.util.Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        /*
        LeetCode 977

        Given an integer array nums sorted in non-decreasing order, return an
        array of the squares of each number sorted in non-decreasing order.

        Example:
        Input: nums = [-4, -1, 0, 3, 10]
        Output: [0, 1, 9, 16, 100]
         */

        int[] squared_nums = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int position = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                squared_nums[position] = leftSquare;
                left++;
            } else {
                squared_nums[position] = rightSquare;
                right--;
            }
            position--;
        }

        return squared_nums;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] squared = sortedSquares(nums);
        for (int num : squared) {
            System.out.println(num);
        }
    }
}
