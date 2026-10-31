package leetcode.r0001_0050.p0001;

/**
 * 枚举每对不同下标，时间 O(n²)，额外空间 O(1)。
 */
public class BruteForceSolution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 从 i + 1 开始，既不复用同一位置，也不重复检查同一对下标。
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // 原题保证有解；只有不符合该前提的输入才会走到这里。
        throw new IllegalArgumentException("Input must contain a valid pair");
    }
}
