package math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int mod = (int) (1e9 + 7);
        //N = p1^a1 * p2^a2 * ... * pk^ak
        //sum = (p1^0 + p1^1 + ... + p1^a1)...(pk^0 + pk^1 + pk^2 + ... + pk^ak)
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            for (int j = 2; j <= n / j; j++) {
                while (n % j == 0) {
                    n /= j;
                    map.merge(j, 1, Integer::sum);
                }
            }
            if(n>1) map.merge(n, 1, Integer::sum);
        }
        long sum = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int p = entry.getKey(), a = entry.getValue();
            long t = 1;
            for (int i = 0; i < a; i++) t = (t * p + 1) % mod;
            sum = sum * t % mod;
        }
        System.out.println(sum);
    }
}
