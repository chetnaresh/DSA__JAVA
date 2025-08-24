package LinkedList;



class LinkElement {
    int data;
    LinkElement next;
    LinkElement(int data) {
        this.data = data;
        this.next = null;
    }
}

class SortLinkedList {
    public static LinkElement sortList(LinkElement head) {
        if (head == null || head.next == null) {
            return head;
        }


        LinkElement mid = getMiddle(head);
        LinkElement rightHead = mid.next;
        mid.next = null;


        LinkElement left = sortList(head);
        LinkElement right = sortList(rightHead);


        return merge(left, right);
    }

    private static LinkElement getMiddle(LinkElement head) {
        LinkElement slow = head;
        LinkElement fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static LinkElement merge(LinkElement l1, LinkElement l2) {
        LinkElement dummy = new LinkElement(0);
        LinkElement tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    public static void printList(LinkElement head) {
        while (head != null) {
            System.out.print(head.data + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkElement head = new LinkElement(4);
        head.next = new LinkElement(2);
        head.next.next = new LinkElement(1);
        head.next.next.next = new LinkElement(3);

        System.out.println("Original List:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
