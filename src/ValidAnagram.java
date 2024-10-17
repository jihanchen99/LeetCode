import java.util.*;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // count occurrences
//        if (s.length() != t.length()) return false;
//        int[] store = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            store[s.charAt(i) - 'a']++;
//            store[t.charAt(i) - 'a']--;
//        }
//        for (int n : store) {
//            if (n != 0) return false;
//        }
//        return true;

        // sort and compare
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
