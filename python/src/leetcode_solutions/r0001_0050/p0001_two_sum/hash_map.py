def two_sum(nums: list[int], target: int) -> list[int]:
    """用已访问的数值和下标查找补数，平均时间 O(n)，额外空间 O(n)。"""
    seen: dict[int, int] = {}
    for i, value in enumerate(nums):
        previous = seen.get(target - value)
        # 下标 0 也有效，不能用 if previous 判断是否找到。
        if previous is not None:
            return [previous, i]
        # 查找后才记录当前值，保证 seen 中的配对位置一定在 i 之前。
        seen[value] = i
    # 原题保证有解；只有不符合该前提的输入才会走到这里。
    raise ValueError("Input must contain a valid pair")
