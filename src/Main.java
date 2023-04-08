import fastAndSlowPointers.FastAndSlowPointers;
import fastAndSlowPointers.Node;
import twoPointers.Exercises;

import java.util.List;

public class Main {
    public static void main(String[] $args) {

        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        Node res = FastAndSlowPointers.findMiddle(head);
        System.out.println(res.val);

        head.next.next.next.next = new Node(6);
        res = FastAndSlowPointers.findMiddle(head);
        System.out.println(res.val);

        head.next.next.next.next.next = new Node(7);
        res = FastAndSlowPointers.findMiddle(head);
        System.out.println(res.val);
    }
}
