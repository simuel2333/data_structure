package doublepointer;

import java.util.Scanner;

/**
 * 给定两个升序排序的有序数组A和B，以及一个目标值x。数组下标从0开始。
 * 请你求出满足A[i] + B[j] = x的数对(i, j)。
 * <p>
 * 数据保证有唯一解。
 * <p>
 * 输入格式
 * 第一行包含三个整数n，m，x，分别表示A的长度，B的长度以及目标值x。
 * <p>
 * 第二行包含n个整数，表示数组A。
 * <p>
 * 第三行包含m个整数，表示数组B。
 * <p>
 * 输出格式
 * 共一行，包含两个整数 i 和 j。
 */
public class Main800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (A[i] + B[j] == x) System.out.println((i++) + " " + j);
            else if (A[i] + B[j] < x) i++;
            else j--;
        }
    }
}
