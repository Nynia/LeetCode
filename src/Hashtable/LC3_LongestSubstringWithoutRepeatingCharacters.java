package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC3_LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map = new HashMap<Character, Integer>();
            char[] chs = s.toCharArray();
            int j = 0;
            int max = 0;
            for (int i=0; i<chs.length; i++) {
                if (map.containsKey(chs[i]) && map.get(chs[i]) >= j) {
                    j = map.get(chs[i]) + 1;
                }
                if (i+1-j > max) {
                    max = i+1-j;
                }
                map.put(chs[i],i);
            }
            return max;
        }
    }
}
