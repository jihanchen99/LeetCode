import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashTableDay1 {
    /*
    关于哈希法：
    1. 何时使用哈希法？当需要快速判断一个元素是否出现在集合里的时候
    2. Tradeoff: 牺牲空间换取时间
    3. 数组 (array) 是一个简单的哈希表
     */

    /*
    LeetCode 242: Valid Anagram
    Given two strings s and t, return true if t is an anagram of s,
    and false otherwise. An Anagram is a word or phrase formed by
    rearranging the letters of a different word or phrase, using
    all the original letters exactly once.

    解题思路与关键：
    1. 利用数组下标来代表a-z，用数组元素代表每个字母出现的次数。
    2. 定义一个新数组alphabet，先遍历string s，记录每个字母出现的次数；接着
       遍历string t，每个字母出现一次，相对应的在数组中的值--。
    3. 结束后，如果alphabet中有非0的元素，说明s和t不是anagram。
    4. 时间复杂度：O(m+n)
    5. 空间复杂度：O(1)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            alphabet[i]++;
        }
        for (char ch : t.toCharArray()) {
            int j = ch - 'a';
            alphabet[j]--;
        }
        for (int elem : alphabet) {
            if (elem != 0) {
                return false;
            }
        }
        return true;
    }

    /*
    LeetCode 349: Intersection of Two Arrays
    Given two integer arrays nums1 and nums2, return an array of
    their intersection. Each element in the result must be unique,
    and you may return the result in any order. The intersection
    of two arrays is defined as the set of elements that are present
    in both arrays.

    解题思路与关键：
    1. 哈希表的三种数据结构：数组、set、map
    2. 哈希法最善于判断一个元素是否在集合里出现
    3. 将nums1转为哈希表来存储所有元素，然后遍历nums2，将重合的元素放进数组res
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        // The Java equivalence of unordered_set is HashSet
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        // Traverse nums1 and store all unique elements
        for (int i : nums1) {
            set1.add(i);
        }
        // Traverse nums2 and add intersecting elements to res set
        for (int j : nums2) {
            if (set1.contains(j)) {
                res.add(j);
            }
        }
        // Convert res set to an array
        int[] arr = new int[res.size()];
        int j = 0;
        for (int i : res) {
            arr[j++] = i;
        }

        return arr;
    }

    /*
    LeetCode 202: Happy Number
     */
    public boolean isHappy(int n) {
        // 使用hashset来存储已经出现过的sum
        Set<Integer> record = new HashSet<>();

        // 如果n=1，则返回true；如果record里包含n，说明进入无限循环，返回false
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            // 更新n为其每个位置上的数字的平方和
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            // 取最小数位的值
            int temp = n % 10;
            res += temp * temp;
            // 将原n的最小位去掉。例子：n = 19, 更新后n = 1
            n = n / 10;
        }
        return res;
    }

    /*
    LeetCode 1: Two Sum
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up
    to target.

    解题思路与关键：
    1. 为什么使用哈希法？为了遍历到每个元素时，判断是否已经遍历过对应的元素。
    2. 使用什么哈希结构？unordered_map (C++) / HashMap (Java) --> implemented using hash
    3. HashMap的作用是什么？存储已经遍历过的元素以及其下标
    4. HashMap的key, value分别是什么？key: 元素的值，value: 元素的下标。通过查找元素的值获取该元素的下标。
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> elements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int addend2 = target - nums[i];
            if (elements.containsKey(addend2)) {
                return new int[]{i, elements.get(addend2)};
            }
            elements.put(nums[i], i);
        }
        return new int[0];
    }


}