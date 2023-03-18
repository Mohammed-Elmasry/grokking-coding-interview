import twoPointers.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {-3, 0, 1, 2, -1, 1, -2};
//        int[] nums = {-5, 2, 2, -1, -2, 3};
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = TwoPointers.findTriplet(nums);

        System.out.println(res);
    }
}
