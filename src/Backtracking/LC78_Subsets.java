package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78_Subsets {
    /*
    回溯法和位操作
     */
    public void dfs(int[] nums, int idx, List<Integer> tmp, List<List<Integer>> re) {
        if (idx == nums.length) {
            re.add(new ArrayList<Integer>(tmp));
            return;
        }
        dfs(nums, idx+1, tmp, re);
        tmp.add(nums[idx]);
        dfs(nums, idx+1, tmp, re);
        tmp.remove(tmp.size()-1);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        dfs(nums, 0, new LinkedList<Integer>(),re);
        return re;
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> re = new ArrayList<>();
        for (int i=0; i<(1<<n); i++) {
            List<Integer> tmplist = new ArrayList<>();
            for (int j=0; j<n; j++) {
                if (((1<<j) & i) > 0) {
                    tmplist.add(nums[j]);
                }
            }
            re.add(tmplist);
        }
        return re;
    }
}
