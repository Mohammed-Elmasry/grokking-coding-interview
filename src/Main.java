import twoPointers.Exercises;
import twoPointers.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {1, 2, 3, 4, 6};
        int target = 6;
        int[] res = Exercises.twoSumWithHashMap(nums, target);

        System.out.println(Arrays.toString(res));

    }
}
