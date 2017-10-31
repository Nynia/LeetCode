package Unknown;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    /*
    交换，然后递归
     */
    public void dg(int[] nums, int from, List<List<Integer>> res) {
        if (from == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int item: nums) {
                tmp.add(item);
            }
            res.add(tmp);
        }
        for (int i = from; i < nums.length; i++) {
            swap(nums, from, i);
            dg(nums, from + 1, res);
            swap(nums, from, i);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dg(nums, 0, res);
        return res;
    }
}
