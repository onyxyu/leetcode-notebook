package leetcode.r0001_0050.p0001;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoSumTest {
    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9),
                Arguments.of(new int[]{3, 2, 4}, 6),
                Arguments.of(new int[]{3, 3}, 6),
                Arguments.of(new int[]{-3, 4, 3, 90}, 0),
                Arguments.of(new int[]{0, 4, 3, 0}, 0),
                Arguments.of(new int[]{5, 1, 2, 9}, 10),
                Arguments.of(new int[]{1_000_000_000, -1_000_000_000, 7}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void bruteForceFindsDistinctIndices(int[] nums, int target) {
        assertValidPair(new BruteForceSolution()::twoSum, nums, target);
    }

    @ParameterizedTest
    @MethodSource("cases")
    void hashMapFindsDistinctIndices(int[] nums, int target) {
        assertValidPair(new HashMapSolution()::twoSum, nums, target);
    }

    private static void assertValidPair(
            BiFunction<int[], Integer, int[]> solve, int[] nums, int target) {
        int[] input = nums.clone();
        int[] indices = solve.apply(input, target);

        assertEquals(2, indices.length);
        assertTrue(indices[0] >= 0 && indices[0] < nums.length);
        assertTrue(indices[1] >= 0 && indices[1] < nums.length);
        assertNotEquals(indices[0], indices[1]);
        assertEquals(target, nums[indices[0]] + nums[indices[1]]);
        assertArrayEquals(nums, input, "The implementation must not modify the input");
    }
}
