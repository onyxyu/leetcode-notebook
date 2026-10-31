package p0001

// twoSumBruteForce 枚举每对不同下标，时间 O(n²)，额外空间 O(1)。
func twoSumBruteForce(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		// 从 i + 1 开始，既不复用同一位置，也不重复检查同一对下标。
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	// 原题保证有解；只有不符合该前提的输入才会走到这里。
	panic("input must contain a valid pair")
}
