import twoPointers.Exercises;
import twoPointers.TwoPointers;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {2, 0, -1, 1, -2, 2};
        int target = 2;
        List<List<Integer>> res = TwoPointers.fourSum(nums, target);

        System.out.println(res);

    }
}
