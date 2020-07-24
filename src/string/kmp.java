package string;

import java.util.Scanner;

public class kmp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] p = new char[n + 1];
        String str = sc.next();
        System.arraycopy(str.toCharArray(), 0, p, 1, str.length());
        int m = sc.nextInt();
        char[] s = new char[m + 1];
        str = sc.next();
        System.arraycopy(str.toCharArray(), 0, s, 1, str.length());
        int[] next = new int[m + 1];
        //求next
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j+1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                j = next[j];
                System.out.print(i - n + 1 + " ");
            }
        }
    }
}
