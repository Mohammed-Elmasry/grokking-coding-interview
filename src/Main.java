import fastAndSlowPointers.FastAndSlowPointers;
import fastAndSlowPointers.Node;
import twoPointers.Exercises;

import java.util.List;

public class Main {
    public static void main(String[] $args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
//        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
//        head.next.next.next.next.next = new Node(6);

        boolean res = FastAndSlowPointers.isPalindromeLinkedList(head);

        System.out.println(res);
        LinkedList.printList(head);
    }
}
