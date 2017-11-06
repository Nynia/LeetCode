package Bit;

public class LC338_CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        int m = 1;
        for (int i=1; i<=num; i++) {
            if (i == m*2) m*=2;
            res[i] = res[i-m] + 1;
        }
        return res;
    }
}
