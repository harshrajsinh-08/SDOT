import java.util.*;

class knapsack {
    static int knapsack(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];
        for (int w = wt[0]; w <= W; w++) {
            dp[w] = val[0];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                int notTaken = dp[w];
                int taken = 0;
                if (wt[i] <= w) {
                    taken = val[i] + dp[w - wt[i]];
                }
                
                curr[w] = Math.max(notTaken, taken);
            }
            dp = curr;
        }
        
        return dp[W];
    }

    public static void main(String args[]) {
        int wt[] = {1, 2, 3,4,5};
        int val[] = {40, 20, 30,40,50};
        int W = 5;
        int n = wt.length;

        System.out.println("ANS : " + knapsack(wt, val, n, W));
    }
}
