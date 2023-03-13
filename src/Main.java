import slidingWindow.maxSumOfContiguousSubArrayK;

public class Main {
    public static void main(String[] $args) {
        String input = "adcad";
        String pattern = "abc";
        String res = maxSumOfContiguousSubArrayK.minimumWindowSubstring(input, pattern);

        System.out.println(res);
    }
}
