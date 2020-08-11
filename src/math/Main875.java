package math;

import java.util.Scanner;

public class Main875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong(), b = sc.nextLong(), p = sc.nextLong();
            long res = quickMi(a, b, p);
            System.out.println(res);
        }
    }

    private static long quickMi(long a, long b, long p) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = res * a % p;
            b >>= 1;
            a = a * a % p;
        }
        return res;
    }
}
