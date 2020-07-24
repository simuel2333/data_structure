package Queue;

import java.util.Scanner;

/**
 * 滑动窗口
 * 给定一个大小为n≤106的数组。
 * <p>
 * 有一个大小为k的滑动窗口，它从数组的最左边移动到最右边。
 * <p>
 * 您只能在窗口中看到k个数字。
 * <p>
 * 每次滑动窗口向右移动一个位置。
 * <p>
 * 以下是一个例子：
 * <p>
 * 该数组为[1 3 -1 -3 5 3 6 7]，k为3。
 */
public class Main154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[n]; //存a的下标
        int[] a = new int[n];
        int k = sc.nextInt();
        int hh = 0, tt = -1;
        //滑动窗口:双指针 [i-k+1,i]
        //单调递增队列 q[hh~tt]
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            if(i>=k-1) System.out.print(a[q[hh]]+" ");
        }
    }
}
