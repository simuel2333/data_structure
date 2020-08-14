package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main893 {
    static int[] s;
    static int[] f = new int[10010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        s = new int[k];
        for (int i = 0; i < k; i++) {
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int res = 0;
        Arrays.fill(f, -1);
        for (int i = 0; i < n; i++) {
            res ^= sg(sc.nextInt());
        }
        if (res > 0) System.out.println("Yes");
        else System.out.println("No");
    }

    private static int sg(int x) {
        if (f[x] == -1) {
            Set<Integer> set = new HashSet<>();
            for (int v : s) {
                if (x >= v) set.add(sg(x - v));
            }
            int i = 0;
            while(set.contains(i)) i++;
            f[x] = i;
        }
        return f[x];
    }
}
