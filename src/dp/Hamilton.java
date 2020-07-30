package dp;

import java.util.Scanner;

public class Hamilton {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1 << n;
        long[][] w = new long[n][n];
        long[][] dp = new long[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[1][0] = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                //确保i包含j
                if ((i >> j & 1) == 1)
                    for (int k = 0; k < n; k++)
                        if (((i - (1 << j)) >> k & 1) == 1)
                            dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][k] + w[k][j]);
        System.out.println(dp[m-1][n-1]);
    }
}
