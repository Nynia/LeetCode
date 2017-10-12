package Unknown;

import java.util.ArrayList;
import java.util.List;

public class LC17_LetterCombinationsofaPhoneNumber {
    /*
    递归
     */
    public List<String> dg(String s, String[] map) {
        List<String> result = new ArrayList<>();
        char[] chs = s.toCharArray();
        if (chs.length == 1) {
            result.add("");
        }
        else {
            char first = chs[0];
            String ms = map[first-'0'];
            List<String> tr = dg(s.substring(1), map);
            for (int i = 0; i < ms.length(); i++) {
                for (int j = 0; j < tr.size(); j++) {
                    String ts = ms.charAt(i) + tr.get(j);
                    result.add(ts);
                }
            }
        }
        return result;
    }
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            if (digits.length() == 0)
                return new ArrayList<String>(){};
            return dg(digits, map);
    }
}
