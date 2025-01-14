import java.util.Arrays;

class Fibonacci {
    public static void main(String[] args) {
        int n = 6;

        /* Normal Fibo */
        // System.out.println(norFib(n));

        /* Top-down Approach */
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        // System.out.println(tdFib(n, dp));
        
        /* Bottom-up Approach */ 
        // System.out.println(buFib(n, dp));

        /* Space Optimised Approach */
        System.out.println(soFib(n));
    }

    /* Normal Fibo */
    private static int norFib(int n) {
        if (n <= 1) {
            return n;
        }

        return norFib(n - 1) + norFib(n - 2);
    }

    /* DP-Top-Down Approach */
    private static int tdFib(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = tdFib(n - 1, dp) + tdFib(n - 2, dp);
        return dp[n];
    }

    /* DP-Bottom-Up Approach */
    private static int buFib(int n, int[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int soFib(int n){
        int prev1=0;
        int prev2=1;

        for(int i=2;i<=n;i++){
            int sum=prev1+prev2;
            prev1=prev2;
            prev2=sum;
        }

        return prev2;
    }
}