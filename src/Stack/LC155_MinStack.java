package Stack;

import java.util.ArrayList;
import java.util.List;

public class LC155_MinStack {
    /** initialize your data structure here. */
    private List<Integer> dt;
    private List<Integer> mt;
    private int top;

    /*
    额外使用一个堆栈存储最小值
     */
    public LC155_MinStack() {
        dt = new ArrayList<>();
        mt = new ArrayList<>();
        top = -1;
    }

    public void push(int x) {
        dt.add(x);
        int lastmin = top >= 0 ? mt.get(top):Integer.MAX_VALUE;
        if (x < lastmin)
            mt.add(x);
        else
            mt.add(lastmin);
        top++;
    }

    public void pop() {
        mt.remove(top);
        dt.remove(top--);

    }

    public int top() {
        return dt.get(top);
    }

    public int getMin() {
        return mt.get(top);
    }
}
