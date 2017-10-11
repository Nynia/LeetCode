package DynamicProgramming;

public class LC5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int[][] dp = new int[1000][1000];
        int max = 1;
        int index = 0;
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i=0; i<s.length()-1; i++) {
            if (chs[i] == chs[i+1]) {
                dp[i][i+1] = 2;
                index = i;
                max = 2;
            }
            else
                dp[i][i+1] = 1;
        }
        for (int i=2; i<=s.length(); i++) {
            for (int j=0; j<=s.length()-i; j++) {
                int k = j + i -1;
                if (chs[j] == chs[k] && dp[j+1][k-1] == i-2) {
                    dp[j][k] = dp[j+1][k-1] + 2;
                    if (i > max) {
                        max = i;
                        index = j;
                    }
                }
                else
                    dp[j][k] = dp[j+1][k-1];

            }
        }
        return s.substring(index, index+max);
    }
}
