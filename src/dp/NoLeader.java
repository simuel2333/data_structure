package dp;

import java.util.Arrays;
import java.util.Scanner;

public class NoLeader {
    private static int[] h, e, ne, w;
    private static int[][] f;
    private static int idx = 0;

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        w = new int[n + 1];
        ne = new int[n + 1];
        e = new int[n + 1];
        h = new int[n + 1];
        f = new int[n + 1][2];
        for (int i = 1; i <= n; i++) w[i] = sc.nextInt();
        Arrays.fill(h, -1);
        boolean[] st = new boolean[n + 1];
        while (sc.hasNextInt()) {
            int a = sc.nextInt(), b = sc.nextInt();
            add(b, a);
            st[a] = true;
        }
        int root = 1;
        while(st[root]) root++;
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));
    }
    private static void dfs(int u){
        f[u][1] = w[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            f[u][1] += f[j][0];
            f[u][0] += Math.max(f[j][0], f[j][1]);
        }
    }
}
