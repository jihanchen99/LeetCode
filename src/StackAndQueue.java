import java.util.*;
public class StackAndQueue {
    /**
     * LeetCode 20: Valid Parentheses
     *
     * 三种invalid的情况：
     * 1. 左括号没有相应的有括号匹配 --> 遍历字符串后，栈不为空
     * 2. 左括号遇到了不同类型的有括号
     * 3. 多余的右括号没有遇到对应的左括号 --> 字符串未遍历完，栈已为空
     *
     * 全部匹配的情况：字符串遍历完，栈也为空。
     */
    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                // If we encounter a closing bracket, check if the stack is empty,
                // which indicates an unmatched closing bracket, and then check if
                // the top element does not match the current char, indicating a
                // mismatched bracket.
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{()}[}";
        System.out.println(isValid(s));
    }

    /**
     * LeetCode 1047: Remove All Adjacent Duplicates in String
     */

    /**
     * LeetCode 150: Evaluate Reverse Polish Notation
     */
}
