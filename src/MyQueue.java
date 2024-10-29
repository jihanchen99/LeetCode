// LeetCode 232: Implement Queue using Stacks
import java.util.Stack;
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    private void dumpStackIn() {
        if (!stackOut.empty()) return;
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
