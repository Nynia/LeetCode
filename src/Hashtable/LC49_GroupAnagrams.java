package Hashtable;

import java.util.*;

public class LC49_GroupAnagrams {
    /*

     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(key, stringList);
            }
            else {
                List<String> stringList = map.get(key);
                stringList.add(str);
                map.put(key, stringList);
            }
        }
        return new ArrayList(map.values());
    }
}
