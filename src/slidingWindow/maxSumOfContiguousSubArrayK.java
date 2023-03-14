package slidingWindow;

import java.io.CharArrayReader;
import java.util.*;

public class maxSumOfContiguousSubArrayK {
    public static int calculateContiguousSubArrayMaxSum(int[] input, int k) {
        int bestSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int left = 0;
        for (int right = 0; right < input.length; right++) {
            windowSum += input[right];

            if (right >= k - 1) {
                bestSum = Math.max(bestSum, windowSum);
                windowSum -= input[left++];
            }
        }
        return bestSum;
    }

    public static int smallestSubarrayWithGivenSum(int[] input, int s) {
        int bestSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            // expanding the window
            windowSum += input[windowEnd];

            while (windowSum >= s) { // found window that applies the condition
                bestSize = Math.min(bestSize, windowEnd - windowStart + 1);
                windowSum -= input[windowStart++];
            }
        }
        return bestSize;
    }

    public static int longestSubstringWithKDistinctCharacters(String input, int k) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightCharacter = input.charAt(windowEnd);
            map.put(rightCharacter, map.getOrDefault(rightCharacter, 0) + 1);

            while (map.size() > k) {
                char leftCharacter = input.charAt(windowStart);
                map.put(leftCharacter, map.get(leftCharacter) - 1);
                map.remove(leftCharacter, 0);
                windowStart++;
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int fruitsIntoBaskets(char[] trees) {
        int k = 2;
        int windowStart = 0;
        int bestLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < trees.length; windowEnd++) {
            char rightTree = trees[windowEnd];
            map.put(rightTree, map.getOrDefault(rightTree, 0) + 1);

            while (map.size() > k) {
                char leftTree = trees[windowStart];
                map.put(leftTree, map.get(leftTree) - 1);
                map.remove(leftTree, 0);
                windowStart++;
            }
            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int noRepeatSubstring(String str) {
        int windowStart = 0;
        int bestLength = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>(); // map of character to its index [not frequency]

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (map.containsKey(rightChar))
                windowStart = Math.max(windowStart, map.get(rightChar) + 1); // plus 1 because I want to start after the first occurrence
            // or I will still end up with repeated right char
            map.put(rightChar, windowEnd); // override the first occurrence's index

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int longestSubstringWithSameLettersAfterReplacements(String str, int k) {
        int windowStart = 0;
        int bestLength = Integer.MIN_VALUE; // 5
        int mostFrequentCharacterSize = 0; // 3 // Notice the freq is not tied to any particular identity. It is tied
        // to the most freq element in current window whatever it was.

        Map<Character, Integer> freqMap = new HashMap<>();
        // "aabccbb"     freqMap = { b:3, c:2 }
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            mostFrequentCharacterSize = Math.max(mostFrequentCharacterSize, freqMap.get(rightChar));

            // the most freq element is the natural thing. We're making exceptions for the non freq elements.
            // the difference between window size and most freq element is the number of elements we'll need
            // exceptions for.
            if (windowEnd - windowStart + 1 - mostFrequentCharacterSize > k) {
                char leftChar = str.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                windowStart++;
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int k) {
        int bestLength = Integer.MIN_VALUE;
        int windowStart = 0;
        int onesCount = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 1)
                onesCount++;

            if (windowEnd - windowStart + 1 - onesCount > k) { // you need to shrink
                if (nums[windowStart] == 1) onesCount--;
                windowStart++;
            }

            bestLength = Math.max(bestLength, windowEnd - windowStart + 1);
        }

        return bestLength;
    }

    public static boolean permutationInString(String str, String pattern) {
        int matched = 0;
        int windowStart = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);


        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
                if (map.get(rightChar) == 0) matched++;
            }

            if (matched == map.size()) return true;

            if (windowEnd >= pattern.length() - 1) { // need to shrink from the left
                char leftChar = str.charAt(windowStart);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        matched--;
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                }
                windowStart++;
            }
        }

        return false;
    }

    public static List<Integer> findAllAnagramsOfPatternWithinString(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
                if (map.get(rightChar) == 0) matched++;
            }

            if (matched == map.size()) {
                res.add(windowStart);
            }

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

//    public static String minimumWindowSubstring(String str, String pattern) {
//        int windowStart = 0;
//        int matched = 0;
//        int minLength = str.length() + 1;
//        int subStrStart = 0;
//
//        Map<Character, Integer> charFreqMap = new HashMap<>();
//
//        for (char chr : pattern.toCharArray())
//            charFreqMap.put(chr, charFreqMap.getOrDefault(chr, 0) + 1);
//
//        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
//            char rightChar = str.charAt(windowEnd);
//            if (charFreqMap.containsKey(rightChar)) {
//                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
//                if (charFreqMap.get(rightChar) == 0)
//                    matched++;
//            }
//
//            while (matched == pattern.length()) {
//                if (minLength > windowEnd - windowStart + 1) {
//                    minLength = windowEnd - windowStart + 1;
//                    subStrStart = windowStart; // start index of the new best window
//                }
//
//                char leftChar = str.charAt(windowStart++);
//                if (charFreqMap.containsKey(leftChar)) {
//                    if (charFreqMap.get(leftChar) == 0)
//                        matched--;
//                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
//                }
//            }
//        }
//
//        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
//    }

    public static String minimumWindowSubstring(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        String res = str;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0)
                    matched++;
            }

            while (matched == map.size()) {
                // a match was found
                String currentWindow = str.substring(windowStart, windowEnd + 1);
                if (res.length() > currentWindow.length())
                    res = currentWindow;

                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        return res.length() < str.length() ? res : "";
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {

        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words)
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);

        List<Integer> res = new ArrayList<Integer>();
        int wordCount = words.length;
        int wordLength = words[0].length();

        int windowSize = wordCount * wordLength;
        for (int i = 0; i < str.length() - windowSize + 1; i++) { // while there is enough string to contain a whole window [number of words X word length]
            Map<String, Integer> wordsSeen = new HashMap<>();

            for (int j = 0; j < words.length; j++) { // for every word
                int nextWordIndex = i + j * wordLength;

                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);

                if (!wordFreqMap.containsKey(word)) break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (wordsSeen.get(word) > wordFreqMap.get(word)) break;

                if (j + 1 == wordCount) { // perfect window
                    res.add(i); // add beginning of the window that contains the right concatenated string
                }
            }
        }

        return res;
    }
}
