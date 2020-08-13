package math;

import java.util.Scanner;

public class Main886 {

    static long[] fact = new long[100001], infact = new long[100001];

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
        fact[0] = 1;
        infact[0] = 1;
        int mod = (int)1e9+7;
        for (int i = 1; i <= 100000 ; i++) {
            fact[i] = fact[i-1] * i % mod;
            infact[i] = infact[i-1] * quickMi(i, mod-2, mod) % mod;
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            long res = fact[a] * infact[a-b] % mod;
            res =  res * infact[b] % mod;
            System.out.println(res);
        }
    }
}
