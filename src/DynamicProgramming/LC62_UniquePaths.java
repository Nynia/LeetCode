package DynamicProgramming;

public class LC62_UniquePaths {
    /*
    代码写的比较丑陋，有机会再重写
     */
    public int uniquePaths(int m, int n) {
        if (m ==1 || n==1)
            return 1;
        int[][] mat = new int[101][101];
        for (int i=0; i<m; i++) {
            mat[i][n-1] = 1;
        }
        for (int i=1; i<=n; i++) {
            mat[m-1][i] = 1;
        }
        for (int i=m-2;i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                mat[i][j] = mat[i+1][j] + mat[i][j+1];
            }
        }
        return mat[0][0];
    }
}
