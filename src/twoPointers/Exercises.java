package twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}
