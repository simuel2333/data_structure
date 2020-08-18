package math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main870 {
    public static void main(String[] args) {
        int mod = (int) (1e9 + 7);
        Scanner sc = new Scanner(System.in);
        //N = p1^a1 * p2^a2 * ... * pk^ak
        //count = (a1+1)(a2+1)...(ak+1)
        int m = sc.nextInt();
        Map<Integer, Integer> primes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            for (int j = 2; j <= n / j; j++) {
                while (n % j == 0) {
                    n /= j;
                    primes.merge(j, 1, Integer::sum);
                }
            }
            if (n > 1) primes.merge(n, 1, Integer::sum);
        }
        long res = 1;
        for (int v : primes.values()) {
            res = res * (v + 1) % mod;
        }
        System.out.println(res);
    }
}
