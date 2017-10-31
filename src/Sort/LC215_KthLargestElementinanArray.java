package Sort;

public class LC215_KthLargestElementinanArray {
    /*
    快速排序，提供了两种select方法
     */
    private void fast_select2(int[] v, int left, int right, int k) {
        if(left < right){
            int pivot= v[right];
            int i = left - 1;

            for (int j = left; j<right; j++) {
                if (v[j] >= pivot ) {
                    swap(v, ++i, j);
                }
            }
            swap(v, ++i, right);
            if (i == k -1)
                return;
            else if (i < k-1) {
                fast_select(v, i+1, right, k);
            }
            else
                fast_select(v, left, i-1, k);
        }
    }
    private void fast_select(int[] v, int left, int right, int k) {
        if(left < right){
            int key = v[left];
            int low = left;
            int high = right;
            while(low < high){
                while(low < high && v[high] <= key){
                    high--;
                }
                v[low] = v[high];
                while(low < high && v[low] >= key){
                    low++;
                }
                v[high] = v[low];
            }
            v[low] = key;
            if (low == k-1) {
                return;
            }
            else if (low < k-1) {
                fast_select(v, low+1, right, k);
            }
            else
                fast_select(v, left, low-1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        fast_select(nums, 0, nums.length-1, k);
        return nums[k-1];
    }
}
