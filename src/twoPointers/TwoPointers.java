package twoPointers;

import java.util.*;

public class TwoPointers {

//    public static int[] pairWithTargetSum(int[] nums, int target) {
//        int[] result = new int[2];
//
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (nums[left] + nums[right] != target) {
//            if (nums[left] + nums[right] > target) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//
//        result[0] = left;
//        result[1] = right;
//
//        return result;
//    }

    public static int[] pairWithTargetSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                return new int[]{left, right};
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }

//    public static int removeDuplicates(int[] nums) {
//        int nextToChange = 1;
//
//        for (int next = 0; next < nums.length; next++) {
//            if (nums[nextToChange - 1] != nums[next]) {
//                nums[nextToChange] = nums[next];
//                nextToChange++;
//            }
//        }
//
//        return nextToChange;
//    }

    public static int removeTarget(int[] nums, int target) {
        int nextToRemove = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[nextToRemove] = nums[i];
                nextToRemove++;
            }
        }

        return nextToRemove;
    }

    public static int[] getSquares(int[] nums) {
        int[] result = new int[nums.length];
        int resPtr = result.length - 1;

        int left = 0;
        int right = resPtr;

        while (left < right) {
            int leftVal = (int) Math.pow(nums[left], 2);
            int rightVal = (int) Math.pow(nums[right], 2);

            if (leftVal >= rightVal) {
                result[resPtr] = leftVal;
                left++;
            } else {
                result[resPtr] = rightVal;
                right--;
            }
            resPtr--;
        }

        return result;
    }

    public static List<List<Integer>> findTriplet(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> triplets = new HashSet<List<Integer>>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int total = arr[left] + arr[right] + arr[i];
                if (total == 0) { // triplet found
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                } else if (total < 0) {
                    left++;
                } else
                    right--;
            }
        }

        return new ArrayList<>(triplets);
    }


    public static int tripleSumCloseToTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int bestDifference = Integer.MAX_VALUE;
        int bestSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total - target == 0) {
                    return total;
                } else if (total - target > 0) {
                    right--;
                } else { // total - target < 0
                    left++;
                }
                if (bestDifference > Math.abs(total - target))
                    bestSum = total;
                bestDifference = Math.min(bestDifference, Math.abs(total - target));
            }
        }
        return bestSum;
    }

    public static int tripletsWithSmallerSum(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                int total = arr[i] + arr[left] + arr[right];
                if (total < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
