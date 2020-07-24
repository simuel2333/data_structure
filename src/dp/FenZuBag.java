package dp;

import java.util.Scanner;

public class FenZuBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] v = new int[N + 1][101];
        int[][] w = new int[N + 1][101];
        int[] s = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            s[i] = sc.nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= v[i][k]) dp[j] = Math.max(dp[j], dp[j - v[i][k]] + w[i][k]);
                }
            }
        }
        System.out.println(dp[V]);
    }
}
