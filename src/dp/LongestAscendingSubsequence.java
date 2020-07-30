package dp;

import java.util.Scanner;

public class LongestAscendingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] q = new int[n + 1];
        q[0] = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < nums[i]) l = mid;
                else r = mid - 1;
            }
            q[r + 1] = nums[i];
            len = Math.max(len, r + 1);
        }
        System.out.println(len);
    }
}
