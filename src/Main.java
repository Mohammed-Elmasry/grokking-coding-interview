import twoPointers.TwoPointers;

import java.util.Arrays;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {-3, -1, 0, 1, 2};
        int[] res = TwoPointers.getSquares(nums);

        System.out.println(Arrays.toString(res));
    }
}
