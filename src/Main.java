import twoPointers.Exercises;
import twoPointers.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> res = Exercises.tripleSumToZero(nums);

        System.out.println(res);

    }
}
