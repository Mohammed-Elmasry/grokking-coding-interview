import twoPointers.TwoPointers;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {8, 2, 6, 5};
        int target = 50;
        List<List<Integer>> res = TwoPointers.subArraysWithProductLessThanTarget(nums, target);

        System.out.println(res);
    }
}
