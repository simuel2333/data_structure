package dp;

import java.util.*;


public class Skiing {
    private static int[][] f, h;
    private static int r, c;
    private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        f = new int[r + 1][c + 1];
        h = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++)
            for (int j = 1; j <= c; j++) {
                h[i][j] = sc.nextInt();
                f[i][j] = -1;
            }

        int res = 0;
        for (int i = 1; i <= r; i++)
            for (int j = 1; j <= c; j++) {
                res = Math.max(res, dp(i, j));
            }
        System.out.println(res);
    }

    private static int dp(int x, int y) {
        if (f[x][y] != -1) return f[x][y];
        f[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 1 && a <= r && b >= 1 && b <= c && h[x][y] > h[a][b]) f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
        }
        return f[x][y];
    }

}
