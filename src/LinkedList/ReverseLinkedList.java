package LinkedList;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    Node head;

    // Add node at end
    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();


        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original list:");
        list.printList();
        list.reverse();

        System.out.println("Reversed list:");
        list.printList();
    }
}
