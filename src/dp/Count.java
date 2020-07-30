package dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a == 0 && b == 0) break;
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            int[] countA = count(a - 1);
            int[] countB = count(b);
            for (int i = 0; i < 10; i++) {
                System.out.print((countB[i] - countA[i]) + " ");
            }
            System.out.println();
        }
    }

    private static int[] count(int x) {
        int[] res = new int[10];
        //计算x有几位
        int n = 0;
        int tmp = x;
        while (tmp != 0) {
            n++;
            tmp /= 10;
        }
        int[] nn = new int[n]; //统计各个位置上的数是多少
        tmp = x;
        int mod = 10;
        for (int i = 0; i < n; i++) {
            nn[i] = (x % mod) / (mod / 10);
            mod *= 10;
        }
        //统计0~x 中0的个数
        mod = 1;
        for (int i = 0; i < n; i++) { //最高位没有0
            int abc = x / (mod * 10);
            if (nn[i] > 0) {
                res[0] += abc * mod;
            } else {
                int efg = x % mod;
                res[0] += abc * (efg + 1) + (abc - 1) * mod;
            }
            mod *= 10;
        }
        for (int i = 0; i < 10; i++) { // 统计1~9出现多少次
            mod = 1;
            for (int j = 0; j < n; j++) { // 统计第1~n位，i出现多少次
                int abc = x / (mod * 10);
                if (nn[j] > i) {
                    res[i] += (abc + 1) * mod;
                } else if (nn[j] == i) {
                    int efg = x % mod;
                    res[i] += abc * mod + efg + 1;
                } else {
                    res[i] += abc * mod;
                }
                mod *= 10;
            }
        }
        return res;
    }


}
