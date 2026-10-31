package p0001

import (
	"slices"
	"testing"
)

func TestTwoSum(t *testing.T) {
	solutions := []struct {
		name  string
		solve func([]int, int) []int
	}{
		{"brute_force", twoSumBruteForce},
		{"hash_map", twoSumHashMap},
	}
	cases := []struct {
		name   string
		nums   []int
		target int
	}{
		{"example_1", []int{2, 7, 11, 15}, 9},
		{"example_2", []int{3, 2, 4}, 6},
		{"duplicates", []int{3, 3}, 6},
		{"negative", []int{-3, 4, 3, 90}, 0},
		{"zeros", []int{0, 4, 3, 0}, 0},
		{"later_pair", []int{5, 1, 2, 9}, 10},
		{"large_values", []int{1_000_000_000, -1_000_000_000, 7}, 0},
	}

	for _, solution := range solutions {
		t.Run(solution.name, func(t *testing.T) {
			for _, tc := range cases {
				t.Run(tc.name, func(t *testing.T) {
					input := slices.Clone(tc.nums)
					indices := solution.solve(input, tc.target)
					if len(indices) != 2 {
						t.Fatalf("expected two indices, got %v", indices)
					}
					i, j := indices[0], indices[1]
					if i < 0 || i >= len(tc.nums) || j < 0 || j >= len(tc.nums) || i == j {
						t.Fatalf("invalid indices: %v", indices)
					}
					if tc.nums[i]+tc.nums[j] != tc.target {
						t.Fatalf("indices %v do not sum to target %d", indices, tc.target)
					}
					if !slices.Equal(input, tc.nums) {
						t.Fatalf("input was modified: got %v, want %v", input, tc.nums)
					}
				})
			}
		})
	}
}
