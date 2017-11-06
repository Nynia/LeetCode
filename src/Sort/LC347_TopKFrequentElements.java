package Sort;

import java.util.*;

public class LC347_TopKFrequentElements {
    /*
    桶排序
    List<Integer>[] bucket = new List[nums.length + 1];
    这种写法
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (bucket[value] == null) {
                bucket[value] = new LinkedList<>();
            }
            bucket[value].add(key);
        }
        List<Integer> res = new ArrayList<>();
        int i = nums.length;
        while (k!= 0 && i>=0) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
            i--;
        }
        return res;
    }
}
