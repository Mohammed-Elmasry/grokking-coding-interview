import slidingWindow.maxSumOfContiguousSubArrayK;

public class Main {
    public static void main(String[] $args) {
//        String input = "aabccbb";
        int[] input = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int res = maxSumOfContiguousSubArrayK.longestSubarrayWithOnesAfterReplacement(input, 3);

        System.out.println(res);
    }
}
