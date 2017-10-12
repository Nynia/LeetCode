package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        List<String> group = new ArrayList<>();
        group.add("[{(");
        group.add("]})");
        for (char ch : chs) {
            if (ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            } else {
                if (!st.empty() && group.get(0).indexOf(st.peek()) == group.get(1).indexOf(ch)) {
                    st.pop();
                } else
                    return false;
            }
        }
        if (st.empty()) return true;
        else return false;
    }
}
