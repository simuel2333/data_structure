package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main894 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        Arrays.fill(f, -1);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            res ^= sg(a);
        }
        if(res != 0) System.out.println("Yes");
        else System.out.println("No");
    }

    private static final int[] f = new int[110];
    private static int sg(int x) {
        if (f[x] == -1) {
            Set<Integer> set = new HashSet<>(); //存当前局面的可以到达的局面
            for (int i = 0; i < x; i++) {
                for (int j = 0; j <= i; j++) {
                    set.add(sg(i) ^ sg(j));
                }
            }
            //求mex
            int i = 0;
            while(set.contains(i)) i++;
            f[x] = i;
        }
        return f[x];
    }
}
