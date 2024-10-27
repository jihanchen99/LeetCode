import java.util.Arrays;
import java.util.Collections;
public class StringDay2 {
    /*
    LeetCode 151: Reverse Words in a String
    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters. The words in s will be separated
    by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        chars = removeExtraSpaces(chars);
        reverse(chars, 0, chars.length - 1);
        reverseEachWord(chars);
        return new String(chars);
    }


    private char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // When this if statement evaluates to true, it signals
            // entering a new word
            if (chars[fast] != ' ') {
                // When this if statement evaluates to true; it adds
                // a space in front of each new word. This "if" is
                // evaluated once every new word.
                if (slow != 0) {
                    chars[slow] = ' ';
                    slow++;
                }
                // this while loop will copy non-space chars read by
                // the fast pointer into the space at index slow until
                // fast goes out of bound or fast hits a space, aka the
                // end of a word.
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        // create newChars of the size slow: this eliminates any trailing
        // spaces at the end of the original char array
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private void reverseEachWord(char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        String res2 = Arrays.toString(arr);
        System.out.println(res2);
        String str = "1, 2, 3, 4, 5";
        System.out.println(res2 == str);
    }
}
