import java.util.*;
public class BinarySearch {
    /*
    leetcode 704:

    Given an array of integers nums which is sorted in ascending order,
    and an integer target, write a function to search target in nums.
    If target exists, then return its index. Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity.
     */

    public int search(int[] nums, int target) {
        int left_ptr = 0;
        int right_ptr = nums.length - 1;

        while (left_ptr <= right_ptr) {
            int mid = left_ptr + ((right_ptr - left_ptr) / 2);
            if (nums[mid] > target) {
                right_ptr = mid - 1;
            } else if (nums[mid] < target) {
                left_ptr = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
