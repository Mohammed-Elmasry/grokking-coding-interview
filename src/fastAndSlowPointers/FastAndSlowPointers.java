package fastAndSlowPointers;

import java.util.HashMap;
import java.util.Map;

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

//    public static boolean isHappyNumber(int number) {
//        int fast = number;
//        int slow = number;
//
//        do {
//            fast = findSquareSum(findSquareSum(fast));
//            slow = findSquareSum(slow);
//        } while (fast != slow);
//
//        return slow == 1;
//    }

    public static boolean isHappyNumber(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum;
        while (!map.containsKey(number)) {
            currentSum = findSquareSum(number);
            map.put(number, currentSum);
            number = currentSum;
        }

        return map.get(number) == 1;
    }

    private static int findSquareSum(int number) {
        int digit;
        int sum = 0;
        while (number > 0) {
            digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
}
