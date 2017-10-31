package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC39_CombinationSum {

    /*
    简单回溯
     */
    public void dfs(int[] candidates, int target, int sum, Stack<Integer> st, List<List<Integer>> res, int last) {
        for (int c:candidates) {
            if (c < last)
                continue;
            if (c+sum == target) {
                st.add(c);
                List<Integer> integerList = new ArrayList<>(st);
                res.add(integerList);
                st.pop();
                break;
            }
            else if (c+sum < target) {
                st.add(c);
                dfs(candidates, target, c+sum, st, res, c);
                st.pop();
            }
            else
                break;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new Stack<Integer>(), res, 0);
        return res;
    }
}
