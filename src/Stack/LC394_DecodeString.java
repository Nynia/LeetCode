package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LC394_DecodeString {
    private String charListtoString(List<Character> lc) {
        String s = "";
        for (char ch : lc) {
            s += ch;
        }
        return s;
    }

    public String decodeString(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chs) {
            if (ch == ']') {
                List<Character> str = new ArrayList<>();
                List<Character> cnt = new ArrayList<>();
                while (stack.peek() != '[') {
                    str.add(stack.pop());
                }
                stack.pop();
                while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    cnt.add(stack.pop());
                }
                int count = 1;
                if (cnt.size() > 0) {
                    Collections.reverse(cnt);
                    count = Integer.valueOf(charListtoString(cnt));
                }
                for (int i = 0; i < count; i++) {
                    for (int j = str.size() - 1; j >= 0; j--) {
                        stack.push(str.get(j));
                    }
                }

            } else
                stack.push(ch);
        }
        return charListtoString(stack);
    }
}
