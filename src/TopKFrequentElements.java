import java.util.*;
import java.util.Map.*;
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> res = new HashMap<>();

        for (int num : nums) {
            // difficulty 1: updating the frequency
            res.put(num, res.getOrDefault(num, 0) + 1);
        }

        // difficulty 2: converting map into a list so that we can sort the entries
        // by value in descending order
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(res.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        int[] resArray = new int[k];
        for (int i = 0; i < k; i++) {
            resArray[i] = entryList.get(i).getKey();
        }

        return resArray;

        // Optimized solution: bucket sort

    }

    public static void main(String[] args) {
        TopKFrequentElements fe = new TopKFrequentElements();
        int[] nums = {1,2,3,3,3,3,3,};
        int[] res = fe.topKFrequent(nums, 1);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
