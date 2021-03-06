package dp;

import java.util.Map;
import java.util.Scanner;

public class bag01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] dp = new int[V+1];
        int[] v = new int[N+1];
        int[] w = new int[N+1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}
