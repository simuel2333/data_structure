package math;

import java.util.Scanner;

public class Main867 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            for (int j = 2; j <= a / j; j++) {
                if (a % j == 0) {
                    int cnt = 0;
                    while (a % j == 0) {
                        cnt++;
                        a /= j;
                    }
                    System.out.println(j + " " + cnt);
                }
            }
            if(a > 1) System.out.println(a + " " + 1);
            System.out.println();
        }
    }
}
