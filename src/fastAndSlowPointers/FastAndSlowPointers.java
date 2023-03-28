package fastAndSlowPointers;

public class FastAndSlowPointers {

    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static int getCycleLength(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) { // cycle found
                Node current = slow.next;
                int cycleLength = 1;
                while (current != slow) {
                    current = current.next;
                    cycleLength++;
                }

                return cycleLength;
            }
        }

        return 0;
    }

    public static Node getCycleStart(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // cycle found
                Node newSlow = head;

                while (newSlow != slow) {
                    slow = slow.next;
                    newSlow = newSlow.next;
                }
                return newSlow;
            }
        }
        return null;
    }
}
