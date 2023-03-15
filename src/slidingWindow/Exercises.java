package slidingWindow;

public class Exercises {
    public static int maxSubarrayOfSizeK(int[] nums, int k) {
        int windowStart = 0;
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentSum += nums[windowEnd];

            if (windowEnd >= k - 1) {
                bestSum = Math.max(bestSum, currentSum);
                currentSum -= nums[windowStart++];
            }
        }
        return bestSum;
    }

    public static int smallestSubarrayWithGivenSum(int[] input, int sum) {
        int bestLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentSum = 0;

        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            currentSum += input[windowEnd];

            while (currentSum >= sum) {
                bestLength = Math.min(bestLength, windowEnd - windowStart + 1);
                currentSum -= input[windowStart++];
            }
        }

        return bestLength;
    }
}
