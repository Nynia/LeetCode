package Hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {
    /*
    K-Sum问题 http://tech-wonderland.net/blog/summary-of-ksum-problems.html
    本题时间复杂度O(n2)
    最后可以使用Hashset去重，以下代码通过每次将三个指针指向不同的数字避免了重复

    注意比如3sum的时候，先整体排一次序，然后枚举第三个数字的时候不需要重复，
    比如排好序以后的数字是 a b c d e f, 那么第一次枚举a, 在剩下的b c d e f中进行2 sum,
    完了以后第二次枚举b, 只需要在 c d e f中进行2sum好了，而不是在a c d e f中进行2sum

    K Sum可以写一个递归程序很优雅的解决，具体大家可以自己试一试。写递归的时候注意不要重复排序就行了。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return result;
        for (int i = 0; i <= nums.length - 3; i++) {
            int a = nums[i];

            int b = i + 1;
            int e = nums.length - 1;
            while (b < e) {
                if (nums[b] + nums[e] < 0 - a) {
                    b++;
                } else if (nums[b] + nums[e] > 0 - a) {
                    e--;
                } else {
                    List<Integer> tl = new ArrayList<>();
                    tl.add(a);
                    tl.add(nums[b]);
                    tl.add(nums[e]);
                    result.add(tl);

                    while (b < e && nums[b] == nums[b + 1]) b++;
                    while (b < e && nums[e] == nums[e - 1]) e--;

                    b++;
                    e--;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;

        }
        return result;
    }
}
