import twoPointers.TwoPointers;

import java.util.Arrays;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {2, 3, 3, 3, 6, 9, 9};
        int target = 2;
        int res = TwoPointers.removeTarget(nums, target);

        System.out.println(res);
    }
}
