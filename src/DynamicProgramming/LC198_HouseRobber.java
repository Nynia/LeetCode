package DynamicProgramming;

public class LC198_HouseRobber {
    /*
    dp0 为不抢劫当前
    dp1 为抢劫当前

    本题可以优化为O(1)空间复杂度
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp0 = new int[nums.length];
        int[] dp1 = new int[nums.length];
        dp0[0] = 0;
        dp1[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp0[i] = Math.max(dp0[i-1], dp1[i-1]);
            dp1[i] = dp0[i-1] + nums[i];

        }
        return Math.max(dp0[nums.length-1], dp1[nums.length-1]);
    }
}
