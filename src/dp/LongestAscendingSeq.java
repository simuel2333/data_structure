package dp;

import java.util.Map;
import java.util.Scanner;

public class LongestAscendingSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] q = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int len = 0;
        q[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < a[i]) l = mid;
                else r = mid - 1;
            }
            len = Math.max(len, r + 1);
            q[r + 1] = a[i];
        }
        System.out.println(len);
    }
}
