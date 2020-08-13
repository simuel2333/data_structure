package math;

import java.util.Scanner;

public class Main890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        int res = 0;
        //用二进制数表示选择了哪些质数。
        for (int i = 1; i < 1 << m; i++) {
            int k = 0; //选择k个质数
            long d = 1; //除数，被除数为n
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    d *= p[j];
                    k++;
                    if (d >= n) break;
                }
            }
            res += ((k & 1) == 1 ? 1 : -1) * (n / d);
        }
        System.out.println(res);
    }
}
