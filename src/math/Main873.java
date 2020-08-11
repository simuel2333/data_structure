package math;

import java.util.Scanner;

public class Main873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int ans = a;
            for (int j = 2; j <= a / j; j++) {
                if (a % j == 0) {
                    while (a % j == 0) {
                        a /= j;
                    }
                    ans = ans / j * (j - 1);
                }
            }
            if(a > 1) ans = ans / a * (a - 1);
            System.out.println(ans);
        }
    }
}
