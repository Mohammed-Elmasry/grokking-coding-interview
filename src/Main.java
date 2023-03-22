import twoPointers.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {1, 0, 1, 2, 1, 0};
//        int target = 50;
        System.out.println(Arrays.toString(nums));
        TwoPointers.sort(nums);

        System.out.println(Arrays.toString(nums));

    }
}
