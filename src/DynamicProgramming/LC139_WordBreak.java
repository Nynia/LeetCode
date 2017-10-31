package DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139_WordBreak {
    /*
    动态规划算法
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        Boolean[] dp = new Boolean[n+1];
        dp[0] = true;
        for (int i=1; i<=n; i++){
            dp[i] = false;
            for (int j=0; j<i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
