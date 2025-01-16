import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int n = 1000;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(ways(n, 0, dp));
        System.out.println(ways2(n, dp));
        System.out.println(ways3(n));
    }

    private static int ways2(int n, int[] dp) {
        dp[n] = 1;
        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }

    private static int ways3(int n) {
        int prev2 = 1;
        int prev1 = 1;

        for (int i = n - 2; i >= 0; i--) {
            int way = prev1 + prev2;
            prev2 = prev1;
            prev1 = way;
        }

        return prev1;
    }

    private static int ways(int n, int cur, int[] dp) {
        if (cur == n) {
            return 1;
        }

        if (cur > n) {
            return 0;
        }

        if (dp[cur] != -1) {
            return dp[cur];
        }

        int onestep = ways(n, cur + 1, dp);
        int twostep = ways(n, cur + 2, dp);

        dp[cur] = onestep + twostep;
        return dp[cur];
    }
}
