public class StringDay1 {
    /*
    LeetCode 344: Reverse String
    Write a function that reverses a string. The input string is given as an array of characters s.
    Do this by modifying the input array in-place with o(1) extra memory.
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /*
    LeetCode 541: Reverse String II
    Given a string s and an integer k, reverse the first k characters for every 2k characters counting
    from the start of the string. If there are fewer than k characters left, reverse all of them. If
    there are less than 2k but greater than or equal to k characters, then reverse the first k characters
    and leve the other as original.
     */
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        // for循环以2k为单位进行迭代，就不需要单独统计总共有多少个长度为2k的子字符串了
        for (int i = 0; i < ch.length; i += 2*k) {
            int start = i;
            // 判断结尾处是否还有超过k个字符可以反转；若没有，则以整个字符串结尾为结尾
            int end = Math.min(ch.length - 1, i + k - 1);
            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }

    /*
    Additional Practice: Replace Number
     */
    public static String replaceNumber(String s){
        // Step 1: 统计s中数字的个数
        int count = 0;
        int sOldSize = s.length();
        for (int i = 0; i < sOldSize; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        // Step 2: 扩充s的大小
        int sNewSize = s.length() + count * 5;
        char[] newS = new char[sNewSize];
        // Step 3: 将s的内容填入新数组newS
        System.arraycopy(s.toCharArray(), 0, newS, 0, sOldSize);
        // Step 4: 利用双指针，从后向前将字母和替换数字的"number"填进新数组
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; i--, j--) {
            if (!Character.isDigit(newS[j])) {
                newS[i] = newS[j];
            } else {
                newS[i] = 'r';
                newS[i - 1] = 'e';
                newS[i - 2] = 'b';
                newS[i - 3] = 'm';
                newS[i - 4] = 'u';
                newS[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newS);
    }

    public static void main(String[] args) {
        String s = "a1b2c3";
        System.out.println(s);
        System.out.println(replaceNumber(s));
    }
}
