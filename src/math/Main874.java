package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] phi = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        phi[1] = 1;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes.add(i);
                phi[i] = i-1;
            }
            for (int j = 0; primes.get(j) <= n / i; j++) {
                int t = i * primes.get(j);
                st[t] = true;
                if (i % primes.get(j) == 0) {
                    phi[t] = phi[i] * primes.get(j);
                    break;
                }
                phi[t] = phi[i] * (primes.get(j) - 1);
            }
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += phi[i];
        }
        System.out.println(sum);
    }
}
