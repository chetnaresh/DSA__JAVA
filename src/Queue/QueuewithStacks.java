package Queue;

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // constructor
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // push an element
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    // pop an element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // peek top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

// Queue using two Stacks
class QueueUsingStacks {
    private Stack stack1;
    private Stack stack2;

    public QueueUsingStacks(int size) {
        stack1 = new Stack(size);
        stack2 = new Stack(size);
    }

    // Enqueue (push into stack1)
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " element added");
    }

    // Dequeue (transfer elements if stack2 is empty)
    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek front element
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueuewithStacks {
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks(10);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Peek: " + q.peek());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Queue is Empty? " + q.isEmpty());
    }
}
