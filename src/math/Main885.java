package math;

import java.util.Scanner;

public class Main885 {
    static int[][] c = new int[2001][2001];
    static int mod = (int) 1e9 + 7;

    //C[a][b] = C[a-1][b-1] + C[a-1][b]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        c[0][0] = 1;
        for (int i = 1; i < 2001; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j])%mod;
            }
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(c[a][b]);
        }
    }
}
