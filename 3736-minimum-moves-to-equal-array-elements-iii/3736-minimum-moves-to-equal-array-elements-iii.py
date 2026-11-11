class Solution:
    def minMoves(self, nums: List[int]) -> int:
        target = max(nums)
        return sum(target-x for x in nums)