
import java.util.Arrays;

public class Mincoins {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(mincoins(arr, 3));
    }

    private static int mincoins(int[] arr, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - arr[j]]);
                }
            }
        }

        return dp[target];
    }
}
