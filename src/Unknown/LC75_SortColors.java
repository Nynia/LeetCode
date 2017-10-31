package Unknown;

public class LC75_SortColors {
    public void sortColors(int[] nums) {
        int r = 0;
        int w = 0;
        int b = 0;
        for (int n : nums) {
            if (n == 0)
                r++;
            else if (n == 1)
                w++;
            else
                b++;
        }
        int index = 0;
        for (index = 0; index < r; index++)
            nums[index] = 0;
        for (index = r; index < r+w; index++)
            nums[index] = 1;
        for (index = r+w; index < nums.length; index++)
            nums[index] = 2;
    }
}
