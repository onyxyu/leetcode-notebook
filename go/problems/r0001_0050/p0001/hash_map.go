package p0001

// twoSumHashMap 用已访问的数值和下标查找补数，平均时间 O(n)，额外空间 O(n)。
func twoSumHashMap(nums []int, target int) []int {
	seen := make(map[int]int)
	for i, value := range nums {
		// ok 区分“键不存在”和“补数下标恰好为 0”。
		if previous, ok := seen[target-value]; ok {
			return []int{previous, i}
		}
		// 先查后存，保证配对位置来自当前下标之前，不会复用当前位置。
		seen[value] = i
	}
	// 原题保证有解；只有不符合该前提的输入才会走到这里。
	panic("input must contain a valid pair")
}
