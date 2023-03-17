package twoPointers;

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
}
