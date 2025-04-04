import java.util.*;

class longestincr {
    public int findNumberOfLIS(int[] nums) {
      final int n = nums.length;
      int ans = 0;
      int maxLength = 0;
      int[] length = new int[n];
      int[] count = new int[n];
  
      Arrays.fill(length, 1);
      Arrays.fill(count, 1);

      for (int i = 0; i < n; ++i)
        for (int j = 0; j < i; ++j)
          if (nums[j] < nums[i])
            if (length[i] < length[j] + 1) {
              length[i] = length[j] + 1;
              count[i] = count[j];
            } else if (length[i] == length[j] + 1) {
              count[i] += count[j];
            }
      for (int i = 0; i < n; ++i)
        if (length[i] > maxLength) {
          maxLength = length[i];
          ans = count[i];
        } else if (length[i] == maxLength) {
          ans += count[i];
        }
  
      return ans;
    }
    public static void main(String[] args) {
        longestincr obj = new longestincr();
        System.out.println(obj.findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
  }