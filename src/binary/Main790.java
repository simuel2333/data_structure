package binary;

import java.util.Scanner;

/**
 * 给定一个浮点数n，求它的三次方根。
 */
public class Main790 {

    public static double cubic(double n) {
        boolean flag = n > 0;
        n = flag ? n : -n;
        double p = 0, r = n;
        double eps = 1e-8;
        while (r - p > eps) {
            double t = (p + r) / 2;
            if (t * t * t >= n) r = t;
            else p = t;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double ans = cubic(n);
        System.out.printf("%.6f", ans);
    }
}
