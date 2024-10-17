import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Method 1
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    int[] result = {i, j};
//                    return result;
//                }
//            }
//        }
//        return new int[0];

        // Method 2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int addend2 = target - nums[i];
            if (map.containsKey(addend2)) {
                return new int[] {i, map.get(addend2)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
