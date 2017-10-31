package Unknown;

public class LC240_Searcha2DMatrixII {
    /*
    从右上角开始比较，每次减少一行或者一列，O(m+n)时间复杂度
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;

    }
}
