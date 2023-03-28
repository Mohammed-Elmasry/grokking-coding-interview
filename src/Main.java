import fastAndSlowPointers.FastAndSlowPointers;
import fastAndSlowPointers.Node;
import twoPointers.Exercises;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(6);
//
//        head.next.next.next.next.next = head.next.next;

        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        boolean res = FastAndSlowPointers.hasCycle(head);

        System.out.println(res);
    }
}
