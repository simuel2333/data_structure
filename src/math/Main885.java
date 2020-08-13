package math;

import java.util.Scanner;

public class Main885 {
    static int[][] c = new int[2001][2001];
    static int mod = (int) 1e9 + 7;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= 2000; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) c[i][j] = 1;
                else c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
            }
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(c[a][b]);
        }
    }
}
