package algorithm;

import java.util.*;

/**
 * 用离散化做
 * 假定有一个无限长的数轴，数轴上每个坐标上的数都是0。
 * <p>
 * 现在，我们首先进行 n 次操作，每次操作将某一位置x上的数加c。
 * <p>
 * 接下来，进行 m 次询问，每个询问包含两个整数l和r，你需要求出在区间[l, r]之间的所有数的和。
 * <p>
 * 输入格式
 * 第一行包含两个整数n和m。
 * <p>
 * 接下来 n 行，每行包含两个整数x和c。
 * <p>
 * 再接下里 m 行，每行包含两个整数l和r。
 */
public class IntervalSum {
    /**
     * 将所有需要操作的断点离散化，然后使用前缀和数组计算区间和。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        List<int[]> add = new ArrayList<>();
        List<int[]> query = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            add.add(new int[]{x, c});
            set.add(x);
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            query.add(new int[]{l, r});
            set.add(l);
            set.add(r);
        }
        List<Integer> all = new ArrayList<>(set);
        all.sort(Comparator.comparingInt(o -> o));
        int[] a = new int[all.size() + 1], s = new int[all.size() + 1];
        //通过find离散化，将当前值转换为下标+1
        for (int[] ad : add) {
            a[find(all, ad[0])] += ad[1];
        }
        //计算前缀和数组
        for (int i = 1; i < s.length; i++) s[i] = s[i - 1] + a[i];
        for (int[] q : query) {
            System.out.println(s[find(all, q[1])] - s[find(all, q[0])-1]);
        }
    }


    private static int find(List<Integer> all, int x) {
        int p = 0, r = all.size() - 1;
        while (p < r) {
            int mid = p + r >> 1;
            if (all.get(mid) >= x) r = mid;
            else p = mid + 1;
        }
        return p + 1;
    }
}
