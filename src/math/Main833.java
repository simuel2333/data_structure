package math;

import java.util.Scanner;

public class Main833 {
    /**
     * 1、找到当前列绝对值最大的行，并将该行置换到最上面
     * 2、将该行当前列的值缩放到1
     * 3、用当前的1去将其下面的行减到0.
     * 4、遍历到下一行下一列，从1循环到4.
     *
     * @param a
     * @return 0 : 唯一解 1：无解 2：无穷解
     */
    public static int gauss(double[][] a, int n) {
        int r, c;
        double eps = 1e-6;
        for (r = 0, c = 0; c < n; c++) {
            //找到绝对值最大的行
            int t = r;
            for (int i = r + 1; i < n; i++) if (Math.abs(a[i][c]) > Math.abs(a[t][c])) t = i;
            if (Math.abs(a[t][c]) < eps) continue; //该列所有值都为0
            for (int i = c; i < n + 1; i++) swap(a, t, i, r, i);
            for (int i = n; i >= c; i--) a[r][i] /= a[r][c];
            for (int i = r + 1; i < n; i++) {
                if (Math.abs(Math.abs(a[i][c])) > eps) {
                    for (int j = n; j >= c; j--) {
                        a[i][j] -= a[r][j] * a[i][c];
                    }
                }
            }
            r++;
        }
        if (r < n) {
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][n]) > eps) {
                    return 2;
                }
            }
            return 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                a[i][n] -= a[j][n] * a[i][j];
            }
        }
        return 0;
    }

    private static void swap(double[][] a, int x1, int y1, int x2, int y2) {
        double t = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] a = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        int flag = gauss(a, n);
        if (flag == 2) {
            System.out.println("No solution");
        } else if (flag == 1) {
            System.out.println("Infinite group solutions");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("%.2f\n", a[i][n]);
            }
        }
    }
}
