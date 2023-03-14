import slidingWindow.maxSumOfContiguousSubArrayK;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
        String input = "catfoxcat";
        String[] words = {"cat", "fox"};

        List<Integer> res = maxSumOfContiguousSubArrayK.findWordConcatenation(input, words);

        System.out.println(res);
    }
}
