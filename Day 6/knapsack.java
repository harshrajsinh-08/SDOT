import java.util.*;

class knapsack {
    static int knapsack(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        for (int w = wt[0]; w <= W; w++) {
            prev[w] = val[0];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                int notTaken = prev[w];
                int taken = 0;
                if (wt[i] <= w) {
                    taken = val[i] + prev[w - wt[i]];
                }
                
                curr[w] = Math.max(notTaken, taken);
            }
            prev = curr;
        }
        
        return prev[W];
    }

    public static void main(String args[]) {
        int wt[] = {1, 2, 3};
        int val[] = {40, 20, 30};
        int W = 5;
        int n = wt.length;

        System.out.println("ANS : " + knapsack(wt, val, n, W));
    }
}
