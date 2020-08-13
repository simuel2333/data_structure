package math;

import java.util.Scanner;

public class Main891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= sc.nextInt();
        }
        if (res != 0) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}
