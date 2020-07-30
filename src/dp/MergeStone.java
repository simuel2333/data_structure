package dp;

import java.util.Scanner;

public class MergeStone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] += s[i-1] + a[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                while (j <= n) {
                    f[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
                    }
                    j++;
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
