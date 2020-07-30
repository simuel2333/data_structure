package dp;

import java.util.Scanner;

/**
 * 我们用f[i][j]表示使用前i个数组成j的方案总数
 * 状态划分：
 *         1. 用使用第i个数的次数划分状态 f[i][j] = f[i-1][j] + f[i-1][j-i] + f[i-1][j-2i]+...+f[i-1][j-si]
 *         2. 优化                      f[i][j-i]=            f[i-1][j-1] + f[i-1][j-2i]+...+f[i-1][j-si]
 *         3.                          f[i][j] = f[i-1][j] + f[i-1][j-i]
 *
 */
public class SplitInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[n + 1];
        f[0] = 1; //初始和为0只有一种方案，不放任何数
        int mod = (int) (1e9 + 7);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] = f[j] + f[j - i] % mod;
            }
        }
        System.out.println(f[n]);
    }
}
