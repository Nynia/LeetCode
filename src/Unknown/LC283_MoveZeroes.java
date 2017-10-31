package Unknown;

public class LC283_MoveZeroes {
    /*
    类似快速排序的部分算法
     */
    private void swap(int[] n, int i, int j) {
        if (i != j) {
            int tmp = n[i];
            n[i] = n[j];
            n[j] = tmp;
        }
    }

    public void moveZeroes(int[] nums) {
        int i = -1;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, ++i, j);
            }
        }
    }
}
