package Math;

public class LC31_NextPermutation {

    /*
    next_permutation 算法
    http://blog.csdn.net/qq575787460/article/details/41215475
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
                        reverse(nums, i);
                        break;
                    }
                }
                break;
            }
        }
        if (i == 0)
            reverse(nums, 0);

    }
}
