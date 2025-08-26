package Queue;
class MyCircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Enqueue: add element
    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    // Dequeue: remove element
    public boolean deQueue() {
        if (isEmpty()) return false;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }

    // Get front element
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    // Get rear element
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }
}
public class CircularQueue {
    public static void main(String[] args) {
        MyCircularQueue cq = new MyCircularQueue(3);

        System.out.println(cq.enQueue(1));
        System.out.println(cq.enQueue(2));
        System.out.println(cq.enQueue(3));
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());
        System.out.println(cq.isFull());
        System.out.println(cq.deQueue());
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());
    }
}
