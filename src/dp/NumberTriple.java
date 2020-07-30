package dp;

import java.util.Scanner;

public class NumberTriple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+1][n+1];
        int[][] f = new int[n+1][n+1];
        for(int i = 1; i <= n; i ++)
            for(int j = 1; j <= i; j++){
                a[i][j] = sc.nextInt();
                f[i][j] = Integer.MIN_VALUE;
            }
        //最后一行的初值
        if (n >= 0) System.arraycopy(a[n], 1, f[n], 1, n);
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i + 1][j], f[i + 1][j + 1]) + a[i][j];
            }
        }
        System.out.println(f[1][1]);
    }
}
