package math;

import java.util.Scanner;

public class Main866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a < 2) {
                System.out.println("No");
                continue;
            }
            boolean flag = true;
            for (int j = 2; j <= a / j; j++) {
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
