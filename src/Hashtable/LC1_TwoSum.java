package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSum {
    public static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            int[] res = new int[2];
            for (int i=0; i<numbers.length; i++) {
                int val = target - numbers[i];
                if (map.containsKey(val)) {
                    res[0] = map.get(val);
                    res[1] = i;
                }
                else
                    map.put(numbers[i],i);
            }
            return res;
        }
    };
}
