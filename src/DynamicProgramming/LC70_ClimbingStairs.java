package DynamicProgramming;

public class LC70_ClimbingStairs {
    /*
    很简单的斐波那契数列问题
     */
    public int climbStairs(int n) {
        int[] re = new int[n+2];

        re[0] = 1;
        re[1] = 2;
        for (int i=2; i<n; i++) {
            re[i] = re[i-1] + re[i-2];
        }
        return re[n-1];
    }
}
