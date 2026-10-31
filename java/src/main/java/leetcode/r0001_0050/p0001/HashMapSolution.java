package leetcode.r0001_0050.p0001;

import java.util.HashMap;
import java.util.Map;

/**
 * 一次遍历哈希表，平均时间 O(n)，额外空间 O(n)。
 */
public class HashMapSolution {

    public int[] twoSum(int[] nums, int target) {
        // 数值 -> 原下标；表中只记录当前下标之前访问过的元素。
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer previous = seen.get(target - nums[i]);
            // 下标 0 也有效，只有 null 表示补数尚未出现。
            if (previous != null) {
                return new int[]{previous, i};
            }
            // 先查后存，避免 target == 2 * nums[i] 时重复使用当前位置。
            seen.put(nums[i], i);
        }
        // 原题保证有解；只有不符合该前提的输入才会走到这里。
        throw new IllegalArgumentException("Input must contain a valid pair");
    }
}
