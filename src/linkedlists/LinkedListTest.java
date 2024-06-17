package linkedlists;

public class LinkedListTest {

    public static Node findMiddle(Node head) {
        int length = 0;
        Node tempNode = head;
        while (tempNode != null) {
            length++;
            tempNode = tempNode.next;
        }
        int half = length % 2 == 1 ? length / 2 : (length + 1) / 2;
        Node resultNode = head;
        while (half-- > 0) {
            resultNode = resultNode.next;
        }
        return resultNode;
    }

    public static Node reverseLinkedList(Node head) {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

}
