package LinkedList;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    ListNode head;

    // Insert at end
    void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("None");
    }


    void search(int key) {
        ListNode temp = head;
        int pos=1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element " + key + "found at postion "+ pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element " + key + "found at position "+ pos);
    }
}

public class SearchElement {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Linked List:");
        list.display();

        // Searching elements
        list.search(30);
        list.search(50);
    }
}
