import twoPointers.Exercises;
import twoPointers.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {2, 5, 9, 11};
        int target = 11;
        int[] res = Exercises.twoSum(nums, target);

        System.out.println(Arrays.toString(res));

    }
}
