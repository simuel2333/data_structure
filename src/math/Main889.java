package math;

import java.util.Scanner;

public class Main889 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //C(n,2n)/n+1
        //C(n,2n) = 2n!/n!(2n-n)!
        int mod = (int) 1e9 + 7;
        long res = 1;
        for (int i = n + 1; i <= 2 * n; i++) res = res * i % mod;
        for (int i = 1; i <= n; i++) res = res * quickMi(i, mod - 2, mod) % mod;
        res = res * quickMi(n + 1, mod - 2, mod) % mod;
        System.out.println(res);
    }

    public static long quickMi(long a, long k, long p) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
