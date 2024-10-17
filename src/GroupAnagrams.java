import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//        Map<String, List<String>> intermediate = new HashMap<>();
//
//        for (String str : strs) {
//            char[] charArray = str.toCharArray();
//            Arrays.sort(charArray);
//            String sortedStr = new String(charArray);
//
//            if (!intermediate.containsKey(sortedStr)) {
//                intermediate.put(sortedStr, new ArrayList<>());
//            }
//
//            intermediate.get(sortedStr).add(str);
//        }
//
//        for (Map.Entry<String, List<String>> entry : intermediate.entrySet()) {
//            res.add(entry.getValue());
//        }
//
//        return res;

        // Optimized Code
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ag = new GroupAnagrams();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = ag.groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }

}
