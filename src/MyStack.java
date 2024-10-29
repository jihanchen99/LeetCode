// LeetCode 225: Implement Stack using Queue
import java.util.*;
class MyStack {
    Deque<Integer> que1;

    public MyStack() {
        que1 = new ArrayDeque<>();
    }

    public void push(int x) {
        que1.addLast(x);
    }

    public int pop() {
        int size = que1.size();
        size--;
        // 将位于queue末尾的元素前的所有元素弹出queue，再加入queue，直至末尾元素变成头元素
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }
        int res = que1.pollFirst();
        return res;
    }

    public int top() {
        return que1.peekLast();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */