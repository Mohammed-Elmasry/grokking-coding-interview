package fastAndSlowPointers;

public class Node {
    public int val = 0;
    public Node next;

    public Node(int value) {
        val = value;
    }

    public Node(int value, Node next) {
        val = value;
        this.next = next;
    }
}
