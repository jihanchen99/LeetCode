import java.util.HashSet;
import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // linear search
        // Time complexity: O(n^2)

//        for (int i = 0; i < nums.length; i++) {
//            int current = nums[i];
//            for (int j = i+1; j < nums.length; j++) {
//                if (current == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;

        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}
