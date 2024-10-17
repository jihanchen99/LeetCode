import java.util.*;

public class StringEncodeDecode {
    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            int len = str.length();       // Get the length of the string
            res.append(len).append("#").append(str);  // Append length, delimiter, and string
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> original = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiterIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiterIndex));
            i = delimiterIndex + 1;
            String word = str.substring(i, i + length);
            original.add(word);
            i += length;
        }
        return original;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("my", "name","is", "Jihan");
        System.out.println(strs.toString());
        String encodedString = encode(strs);
        System.out.println(encodedString);
        System.out.println(decode(encodedString));
    }
}
