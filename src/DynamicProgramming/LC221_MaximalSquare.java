package DynamicProgramming;

public class LC221_MaximalSquare {
    /*
    注释的部分是改进的写法，更加优雅
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            if (dp[i][0] > max)
                max = dp[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            if (dp[0][i] > max)
                max = dp[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    dp[i][j] = 1;
                    int k = 1;
                    while (k <= dp[i - 1][j - 1]) {
                        if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1') {
                            dp[i][j]++;
                        }
                        else
                            break;
                        k++;
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else
                    dp[i][j] = 0;
            }
        }
        return max * max;
    }
}
