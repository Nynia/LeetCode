package Greedy;

public class LC55_JumpGame {
    /*
    此题是典型的动态规划算法，但是O(n2)会超时

    采用贪心法，O(n)时间复杂度
     */
    public boolean canJump(int[] nums) {
        int maxreach = 0;
        int index = 0;
        for (; index < nums.length && index <= maxreach; index++) {
            maxreach = Math.max(nums[index] + index, maxreach);
        }
        return maxreach >= nums.length - 1;
    }
}
