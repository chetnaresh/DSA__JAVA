package Stack;

import java.util.*;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class MinimumStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(3);
        ms.push(5);
        ms.push(2);
        ms.push(1);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
