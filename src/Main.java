import twoPointers.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {1, 0, 1, 1};
        int target = 100;
        int res = TwoPointers.tripleSumCloseToTarget(nums, target);

        System.out.println(res);
    }
}
