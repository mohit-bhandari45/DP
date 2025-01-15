
import java.util.Arrays;

public class Stairs {
    public static void main(String[] args) {
        int[] cost = { 10, 15, 20,30,25,40,35 };
        int n = cost.length;

        // System.out.println(Math.min(helper(n - 1, cost), helper(n - 2, cost)));

        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        // System.out.println(Math.min(helper2(n-1, cost, dp), helper2(n-2, cost, dp)));

        dp[0]=cost[0];
        dp[1]=cost[1];
        // System.out.println(helper3(cost, dp));

        System.out.println(helper4(cost));
    }

    private static int helper(int n, int[] cost) {
        // base case

        if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }

        int c1 = helper(n - 1, cost);
        int c2 = helper(n - 2, cost);
        int min = Math.min(c1, c2);

        return cost[n] + min;
    }

    private static int helper2(int n, int[] cost, int[] dp) {
        // base case

        if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int c1 = helper2(n - 1, cost, dp);
        int c2 = helper2(n - 2, cost, dp);
        int min = Math.min(c1, c2);

        dp[n] = cost[n] + min;
        return dp[n];
    }

    private static int helper3(int[] cost,int[] dp) {
        // base case
        int n=cost.length;

        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }

    private static int helper4(int[] cost) {
        // base case
        int n=cost.length;
        int prev1=cost[0];
        int prev2=cost[1];

        for(int i=2;i<n;i++){
            int min=Math.min(prev1,prev2)+cost[i];
            prev1=prev2;
            prev2=min;
        }

        return Math.min(prev1,prev2);
    }

    private static int ways(int n, int pos, int[] dp) {
        if (pos > n) {
            return 0;
        }

        if (pos == n) {
            return 1;
        }

        if (dp[pos] != -1) {
            return dp[pos];
        }

        int oneStep = ways(n, pos + 1, dp);
        int twoStep = ways(n, pos + 2, dp);

        dp[pos] = oneStep + twoStep;

        return dp[pos];
    }

}
