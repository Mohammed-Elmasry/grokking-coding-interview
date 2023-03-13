import slidingWindow.maxSumOfContiguousSubArrayK;

import java.util.List;

public class Main {
    public static void main(String[] $args) {
        String input = "ppqp";
        String pattern = "pq";
        List<Integer> res = maxSumOfContiguousSubArrayK.findAllAnagramsOfPatternWithinString(input, pattern);

        System.out.println(res);
    }
}
