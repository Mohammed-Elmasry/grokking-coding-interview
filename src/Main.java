import fastAndSlowPointers.FastAndSlowPointers;
import fastAndSlowPointers.Node;
import twoPointers.Exercises;

import java.util.List;

public class Main {
    public static void main(String[] $args) {

        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
//        head.next.next.next.next.next = new Node(12);

        FastAndSlowPointers.rearrange(head);

        LinkedList.printList(head);
    }
}
