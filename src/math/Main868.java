package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main868 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] st = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>(n);
        for (int i = 2; i <= n; i++) {
            if(!st[i]) primes.add(i);
            for (int j = 0; primes.get(j) <= n / i; j++) {
                st[primes.get(j) * i] = true;
                if(i % primes.get(j) == 0) break;
            }
        }
        System.out.println(primes.size());
    }
}
