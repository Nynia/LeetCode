package BinarySearch;

public class LC34_SearchforaRange {

    /*
    二分法
    两次二分，分别找左右边界
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            }
            else if (target > nums[mid]) {
                l = mid + 1;
            }
            else {
                if (mid == l || nums[mid -1] != target) {
                    res[0] = mid;
                    break;
                }
                r = mid - 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            }
            else if (target > nums[mid]) {
                l = mid + 1;
            }
            else {
                if (mid == r || nums[mid+1] != target) {
                    res[1] = mid;
                    break;
                }
                l = mid + 1;
            }
        }
        return res;
    }
}
