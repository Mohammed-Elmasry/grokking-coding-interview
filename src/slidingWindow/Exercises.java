package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            if (windowEnd - windowStart + 1 - onesFreq > k) {
                // need to shrink
                int leftNum = nums[windowStart++];
                if (leftNum == 1) onesFreq--;
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static boolean problemChallenge1(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char chr : pattern.toCharArray())
            map.put(chr, map.getOrDefault(chr, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) matched++;
            }

            if (matched == map.size()) return true;

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static List<Integer> problemChallenge2(String str, String pattern) {
        List<Integer> res = new ArrayList<>();
        int matched = 0;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char chr : pattern.toCharArray())
            map.put(chr, map.getOrDefault(chr, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) matched++;
            }

            if (matched == map.size()) res.add(windowStart);

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return res;
    }

    public static String problemChallenge3(String str, String pattern) {
        String res = ""; // needed if you're keeping the string
        int bestStartIndex = 0; // no need if you're keeping the string
        int matched = 0;
        int windowStart = 0;
        int bestLength = str.length() + 1;

        Map<Character, Integer> map = new HashMap<>();

        for (char chr : pattern.toCharArray())
            map.put(chr, map.getOrDefault(chr, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) matched++;
            }

            while (matched == map.size()) { // keep shrinking to optimize the length
                // found a good window
                if (bestLength > windowEnd - windowStart + 1) {
                    bestLength = windowEnd - windowStart + 1;
                    res = str.substring(windowStart, windowEnd + 1);
                    // or
                    bestStartIndex = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        if (bestLength > str.length()) return "";
        return res; // keep updating the string. or substring at the end once
//        return str.substring(bestStartIndex, bestStartIndex + bestLength);
    }

    public static List<Integer> problemChallenge4(String str, String[] words) {
        int wordCount = words.length;
        int wordLength = words[0].length();
        int windowSize = wordCount * wordLength;
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words)
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

        for (int i = 0; i < str.length() - windowSize + 1; i++) {
            Map<String, Integer> seenWords = new HashMap<>();

            for (int j = 0; j < words.length; j++) { // word by word
                int nextWordIndex = i + j * wordLength;
                String currentWord = str.substring(nextWordIndex, nextWordIndex + wordLength);

                if (!wordMap.containsKey(currentWord)) break;

                seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);

                if (seenWords.get(currentWord) > wordMap.get(currentWord)) break;
            }

            if (wordMap.size() == seenWords.size()) {
                result.add(i);
            }
        }

        return result;
    }
}
