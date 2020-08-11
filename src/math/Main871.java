package math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = (int) (1e9 + 7);
        Map<Integer, Integer> mem = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            //求质因数
            //根据公式求因数之和
            for (int j = 2; j <= a / j; j++) {
                while (a % j == 0) {
                    a /= j;
                    mem.merge(j, 1, Integer::sum);
                }
            }
            if (a > 1) mem.merge(a, 1, Integer::sum);
        }
        long sum = 1;
        for (Map.Entry<Integer, Integer> entry : mem.entrySet()) {
            long t = 1;
            long p = entry.getKey(), a = entry.getValue();
            for (int i = 1; i <= a; i++) t = (t * p + 1) % mod;
            sum = (sum * t) % mod;
        }
        System.out.println(sum);
    }
}
