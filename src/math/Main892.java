package math;

import java.util.Scanner;

public class Main892 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if ((i & 1) == 1)
                res ^= x ;
        }
        if (res != 0) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}
