package math;

import java.util.Scanner;

public class Main889 {

    public static long quickMi(long a, long k, long p) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 1;
        long mod = (long) (1e9 + 7);
        for (int i = 2 * n; i > n; i--) res = res * i % mod;
        for (int i = 1; i <= n; i++) res = res * quickMi(i, mod - 2, mod) % mod;
        res = res * quickMi(n + 1, mod - 2, mod) % mod;
        System.out.println(res);
    }
}
