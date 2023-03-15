import slidingWindow.Exercises;
import slidingWindow.maxSumOfContiguousSubArrayK;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
        int[] input = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int res = Exercises.maxSubarrayOfSizeK(input, k);

        System.out.println(res);
    }
}
