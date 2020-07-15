package algorithm;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 *
 * 注意如果在端点处相交，也算有交集。
 *
 * 输出合并完成后的区间个数。
 *
 * 例如：[1,3]和[2,6]可以合并为一个区间[1,6]。
 */
public class IntervalMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            list.add(new int[]{l, r});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = merge(list);
        System.out.println(ans.size());
    }

    private static List<int[]> merge(List<int[]> list) {
        List<int[]> ans = new ArrayList<>();
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for (int[] seg : list) {
            if (seg[0] > end) {
                if(end != Integer.MIN_VALUE) ans.add(new int[]{start, end});
                start = seg[0];
                end = seg[1];
            } else end = Math.max(end, seg[1]);
        }
        if(end != Integer.MIN_VALUE) ans.add(new int[]{start, end});
        return ans;
    }
}
