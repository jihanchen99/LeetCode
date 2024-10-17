import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /*
    Pseudocode:
    1. Create empty array 'result' with default value of 1 of nums.length
    2. Traverse nums from index 0 to nums.length - 1, updating result with prefixes
    3. Traverse nums from nums.length - 1 to 0, updating result by timing prefixes
    with postfixes
    4. Return result
     */

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        int prefix = 1;
        int postfix = 1;

        for (int i = 0; i < nums.length; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        for (int j = nums.length - 1; j > -1; j--) {
            res[j] *= postfix;
            postfix *= nums[j];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] num = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(num)));
    }

}
