package slidingWindow;

import java.util.HashMap;
import java.util.Map;

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

    public static int longestSubstringWithKDistinctCharacters(String str, int k) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);


            while (map.size() > k) { // more than k distinct characters
                char leftChar = str.charAt(windowStart++);
                map.put(leftChar, map.get(leftChar) - 1);
                map.remove(leftChar, 0);
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int fruitProblem(char[] trees) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < trees.length; windowEnd++) {
            char rightChar = trees[windowEnd];
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);


            while (map.size() > 2) { // more than k distinct characters
                char leftChar = trees[windowStart++];
                map.put(leftChar, map.get(leftChar) - 1);
                map.remove(leftChar, 0);
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int noRepeatSubstring(String str) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (indexMap.containsKey(rightChar))
                windowStart = Math.max(windowStart, indexMap.get(rightChar) + 1);

            indexMap.put(rightChar, windowEnd);

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int longestSubstringWithSameLettersAfterReplacement(String str, int k) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        int mostFreqElementFrequency = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            mostFreqElementFrequency = Math.max(mostFreqElementFrequency, freqMap.get(rightChar));

            if (windowEnd - windowStart + 1 - mostFreqElementFrequency > k) {
                char leftChar = str.charAt(windowStart++);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }


        return bestLength;
    }

    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int k) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        int onesFreq = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {

            if (nums[windowEnd] == 1)
                onesFreq++;

            if (windowEnd - windowStart + 1 - onesFreq > k){
                // need to shrink
                int leftNum = nums[windowStart++];
                if (leftNum == 1) onesFreq--;
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }
}
