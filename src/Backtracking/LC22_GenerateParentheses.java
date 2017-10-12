package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParentheses {
    /*
    回溯问题
    left 记录左括号数量
    right 记录右括号数量
     */
    public void dfs(String str, List<String> res, int left, int right, int n) {
        if (left < right || left > n || right > n)
            return;
        if (right == n) {
            res.add(str);
        }
        dfs(str+"(", res, left+1, right, n);
        dfs(str+")", res, left,right+1, n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, 0, 0, n);
        return res;
    }
}
