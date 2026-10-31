from collections.abc import Callable

import pytest

from leetcode_solutions.r0001_0050.p0001_two_sum import brute_force, hash_map


@pytest.mark.parametrize(
    "solve", [brute_force.two_sum, hash_map.two_sum], ids=["brute_force", "hash_map"]
)
@pytest.mark.parametrize(
    "nums,target",
    [
        ([2, 7, 11, 15], 9),
        ([3, 2, 4], 6),
        ([3, 3], 6),
        ([-3, 4, 3, 90], 0),
        ([0, 4, 3, 0], 0),
        ([5, 1, 2, 9], 10),
        ([1_000_000_000, -1_000_000_000, 7], 0),
    ],
)
def test_two_sum_returns_distinct_valid_indices(
    solve: Callable[[list[int], int], list[int]], nums: list[int], target: int
) -> None:
    input_nums = nums.copy()
    indices = solve(input_nums, target)

    assert len(indices) == 2
    i, j = indices
    assert 0 <= i < len(nums)
    assert 0 <= j < len(nums)
    assert i != j
    assert nums[i] + nums[j] == target
    assert input_nums == nums
