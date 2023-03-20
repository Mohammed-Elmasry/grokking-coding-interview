import twoPointers.TwoPointers;

public class Main {
    public static void main(String[] $args) {
        int[] nums = {-1, 0, 2, 3};
        int target = 3;
        int res = TwoPointers.tripletsWithSmallerSum(nums, target);

        System.out.println(res);
    }
}
