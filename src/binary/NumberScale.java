package binary;


import java.util.Scanner;

public class NumberScale {

    private static void search(int[] nums, int k) {
        int p = 0, r = nums.length - 1;
        while (p < r) {
            int mid = p + r >> 1;
            if (nums[mid] >= k) r = mid;
            else p = mid + 1;
        }
        if (nums[p] != k) {
            System.out.println("-1 -1");
            return;
        }
        System.out.print(p + " ");
        p = 0;
        r = nums.length - 1;
        while (p < r) {
            int mid = p + r + 1 >> 1;
            if (nums[mid] <= k) p = mid;
            else r = mid - 1;
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        int n, q;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            search(nums, k);
        }
    }
}
