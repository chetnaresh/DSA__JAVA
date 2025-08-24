package Stack;

import java.util.*;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            while (!temp.isEmpty() && temp.peek() > val) {
                stack.push(temp.pop());
            }
            temp.push(val);
        }
        return temp;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        Stack<Integer> sorted = sortStack(stack);
        System.out.println(sorted);
    }
}
