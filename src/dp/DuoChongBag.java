package dp;

import java.util.Scanner;

public class DuoChongBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[25000];
        int[] w = new int[25000];
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int k = 1;
            while (k <= s) {
                cnt++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                s -= k;
                k = k << 1;
            }
            if (s > 0) {
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }
        int[] dp = new int[V + 1];
        for (int i = 1; i <= cnt; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]]+w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}
