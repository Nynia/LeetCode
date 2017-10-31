package DynamicProgramming;

public class LC279_PerfectSquares {
    /*
    内层循环可以优化
     */
    public int numSquares(int n) {
        int[] dp =  new int[n+1];
        dp[1] =1;
        int k = 2;
        for (int i=2; i<n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i == k*k) {
                dp[i] = 1;
                k++;
            }
            for (int j=1; j<=i/2; j++) {
                if (dp[j] + dp[i-j] < dp[i]) {
                    dp[i] = dp[j] + dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
