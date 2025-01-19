import java.util.Arrays;

class MaxSum {
    public static void main(String[] args) {
        int[] arr = { 9, 9, 8, 2 };
        // System.out.println(maxSum(arr, 0, 0));

        // int[] dp = new int[arr.length];
        // Arrays.fill(dp, -1);
        // dp[0] = arr[0];
        // System.out.println(maxSumMem(arr, arr.length - 1, dp));

        System.out.println(maxSumTab(arr));
        System.out.println(maxSumSpa(arr));
    }

    private static int maxSum(int[] arr, int index, int sum) {
        if (index >= arr.length) {
            return sum;
        }

        int first = maxSum(arr, index + 2, sum + arr[index]);
        int second = maxSum(arr, index + 1, sum);

        return Math.max(first, second);
    }

    private static int maxSumMem(int[] arr, int index, int[] dp) {
        if (index == 0) {
            return dp[0];
        }

        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int leftSum = arr[index] + maxSumMem(arr, index - 2, dp);
        int rightSum = maxSumMem(arr, index - 1, dp);

        dp[index] = Math.max(leftSum, rightSum);
        return dp[index];
    }

    private static int maxSumTab(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int include = 0;
            if (i - 2 < 0) {
                include = arr[i];
            } else {
                include = arr[i] + dp[i - 2];
            }

            int exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[dp.length - 1];
    }

    private static int maxSumSpa(int[] arr) {
        int prev1 = 0;
        int prev2 = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int include = arr[i] + prev1;

            int m = Math.max(include, prev2);
            prev1 = prev2;
            prev2 = m;

        }

        return prev2;
    }
}