package math;

import java.util.Scanner;

public class Main866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            if (a == 1) {
                System.out.println("No");
                continue;
            }
            boolean flag = true;
            for (long j = 2; j <= a / j; j++) {
                if (a % j == 0) {
                    System.out.println("No");
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("Yes");
        }
    }
}
