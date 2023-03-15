import slidingWindow.Exercises;
import slidingWindow.maxSumOfContiguousSubArrayK;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
        // problem 1
//        int[] input = {2, 1, 5, 1, 3, 2};
//        int k = 3;

//        int res = Exercises.maxSubarrayOfSizeK(input, k);


        // problem 2
        int[] input = {3, 4, 1, 1, 6};
        int sum = 8;

        int res = Exercises.smallestSubarrayWithGivenSum(input, sum);
        System.out.println(res);
    }
}
