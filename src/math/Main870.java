package math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main870 {
    public static void main(String[] args) {
        int mod = (int) (1e9 + 7);
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> mem = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
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
            int a = entry.getValue();
            sum = sum * (a+1) % mod;
        }
        System.out.println(sum);
    }
}
