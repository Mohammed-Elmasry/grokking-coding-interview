import slidingWindow.maxSumOfContiguousSubArrayK;

public class Main {
    public static void main(String[] $args) {
        String input = "aabccbb";

        int res = maxSumOfContiguousSubArrayK.longestSubstringWithSameLettersAfterReplacements(input, 2);

        System.out.println(res);
    }
}
