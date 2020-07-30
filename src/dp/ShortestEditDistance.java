package dp;

import java.util.Scanner;

public class ShortestEditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }
        for (int i = 0; i < m; i++) {
            String b = sc.next();
            int limit = sc.nextInt();
            int res = 0;
            for (String a : strings) {
                if(helper(a,b) <= limit) res++;
            }
            System.out.println(res);
        }
    }

    public static int helper(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) f[i][0] = i;
        for (int j = 1; j <= m; j++) f[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                f[i][j] = Math.min(f[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1), f[i][j]);
            }
        }
        return f[n][m];
    }


}
