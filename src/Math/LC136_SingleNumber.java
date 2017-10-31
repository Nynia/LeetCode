package Math;

public class LC136_SingleNumber {
    /*
    x^x = 0
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int sum = 0;
            for (int n: nums) {
                sum ^= n;
            }
            return sum;
        }
    }
}
