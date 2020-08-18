package math;

import java.util.Scanner;

public class Main890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //能被整除的数?
        //如何判断能不能被整除？
        //pipj|n : n % pipj == 0
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        int res = 0;
        //根据容斥原理k为奇数时，为+，为偶数时，为-
        for (int i = 1; i < 1 << m; i++) {
            int k = 0; //选择多少个质数
            long d = 1;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    k++;
                    d *= p[j];
                    if (d >= n) break;
                }
            }
            res += ((k & 1) == 1 ? 1 : -1) * (n / d);
        }
        System.out.println(res);
    }
}
