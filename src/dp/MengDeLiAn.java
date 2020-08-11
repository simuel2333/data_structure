package dp;

import java.util.Scanner;

public class MengDeLiAn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;
            long[][] f = new long[m + 1][1 << n];
            boolean[] st = new boolean[1 << n];
            for (int j = 0; j < 1 << n; j++) {
                int cnt = 0;
                st[j] = true;
                for (int i = 0; i < n; i++) {
                    if (((j >> i) & 1) == 0) cnt++;
                    else {
                        if ((cnt & 1) == 1) {
                            st[j] = false;
                            break;
                        } else cnt = 0;
                    }
                }
                if ((cnt & 1) == 1) st[j] = false;
            }

            f[0][0] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < 1 << n; k++) {
                        if ((j & k) == 0 && st[j | k]) f[i][j] += f[i - 1][k];
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }
}
