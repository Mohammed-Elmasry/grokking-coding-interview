package twoPointers;

import java.lang.reflect.Array;
import java.util.*;

public class Exercises {
    public static int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;


        while (low < high) {
            int total = arr[low] + arr[high];
            if (total > target) {
                high--;
            } else if (total < target) {
                low++;
            } else {
                return new int[]{low, high};
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] twoSumWithHashMap(int[] arr, int target) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static int removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int nextToChange = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[nextToChange - 1]) {
                arr[nextToChange] = arr[i];
                nextToChange++;
            }
        }
        return nextToChange;
    }

    public static int[] squareSortedArray(int[] arr) {
        Arrays.sort(arr);
        int[] res = new int[arr.length];

        int resPointer = res.length - 1;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int leftSquare = (int) Math.pow(arr[left], 2);
            int rightSquare = (int) Math.pow(arr[right], 2);

            if (leftSquare <= rightSquare) {
                res[resPointer] = rightSquare;
                right--;
            } else {
                res[resPointer] = leftSquare;
                left++;
            }
            resPointer--;
        }

        return res;
    }

    public static List<List<Integer>> tripleSumToZero(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            Map<Integer, Integer> map = new HashMap<>();
            int complement = -arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                if (map.containsKey(complement - arr[j])) {
                    triplets.add(new ArrayList<>(Arrays.asList(arr[i], complement - arr[j], arr[j])));
                } else {
                    map.put(arr[j], j);
                }
            }
        }
        return new ArrayList<>(triplets);
    }

    public static List<List<Integer>> tripleSumToZeroWithTwoPointers(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int total = arr[i] + arr[left] + arr[right];
                if (total == 0) {
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

    public static int tripletSumClosestToTarget(int[] arr, int target) {
        Arrays.sort(arr);
        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int total = arr[i] + arr[left] + arr[right];

                if (total - target == 0) {
                    return total;
                } else if (total - target > 0) {
                    right--;
                } else {
                    left++;
                }

                if (bestDiff > Math.abs(target - total)) {
                    bestSum = total;
                }
                bestDiff = Math.min(bestDiff, Math.abs(target - total));
            }
        }
        return bestSum;
    }

    public static boolean problemChallenge2(String str1, String str2) {
        // setup
        int leftPtr = str1.length() - 1;
        int rightPtr = str2.length() - 1;

        int leftCounter = 0;
        int rightCounter = 0;

        while (leftPtr > -1 || rightPtr > -1) {
            while (leftPtr >= 0) {
                if (str1.charAt(leftPtr) == '#') {
                    leftCounter++;
                } else if (leftCounter > 0) {
                    leftCounter--;
                } else {
                    break;
                }
                leftPtr--;
            }

            while (rightPtr >= 0) {
                if (str2.charAt(rightPtr) == '#') {
                    rightCounter++;
                } else if (rightCounter > 0) {
                    rightCounter--;
                } else {
                    break;
                }
                rightPtr--;
            }

            // compare stable characters
            if (leftPtr < 0 && rightPtr < 0) return true;

            if (leftPtr < 0 || rightPtr < 0) return false;

            if (str1.charAt(leftPtr) != str2.charAt(rightPtr)) return false;

            leftPtr--;
            rightPtr--;
        }

        return true;
    }

    public static int problemChallenge3(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < arr.length - 1 && arr[left] <= arr[left + 1])
            left++;

        if (left == arr.length - 1) // array is already sorted
            return 0;

        while (right > 0 && arr[right] >= arr[right - 1])
            right--;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = left; k <= right; k++) {
            max = Math.max(max, arr[k]);
            min = Math.min(min, arr[k]);
        }

        while (left > 0 && arr[left - 1] > min)
            left--;

        while (right < arr.length - 1 && arr[right + 1] < max)
            right++;

        return right - left + 1;
    }
}