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
}