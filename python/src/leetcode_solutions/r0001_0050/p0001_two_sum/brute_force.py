def two_sum(nums: list[int], target: int) -> list[int]:
    """枚举每对不同下标，时间 O(n²)，额外空间 O(1)。"""
    for i in range(len(nums)):
        # 从 i + 1 开始，既不复用同一位置，也不重复检查同一对下标。
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]
    # 原题保证有解；只有不符合该前提的输入才会走到这里。
    raise ValueError("Input must contain a valid pair")
