package DynamicProgramming;

public class LC300_LongestIncreasingSubsequence {
    /*
    还有O(nlgn) 的算法
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i=1; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
